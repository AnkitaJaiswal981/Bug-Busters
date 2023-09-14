package com.hsbc.bugreportapp.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.bugreportapp.beans.Project;
import com.hsbc.bugreportapp.beans.User;
import com.hsbc.bugreportapp.connection.DBConnection;
import com.hsbc.bugreportapp.connection.DBConnectionImpl;

public class ProjectServiceDAOImpl implements ProjectServiceDAO {

	private static DBConnection db= new DBConnectionImpl();
	private static Connection connection=null;;
	private static PreparedStatement preparedStatement=null;
	private static ResultSet resultSet=null;

    @Override
    public Project getProjectById(int projectId) throws SQLException {
            String sql = "SELECT * FROM Projects WHERE project_id = ?";
            connection= db.connect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, projectId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Project project = new Project();
                project.setProjectId(resultSet.getInt("project_id"));
                project.setProjectName(resultSet.getString("project_name"));
                project.setDescription(resultSet.getString("description"));
                project.setStartDate(resultSet.getDate("start_date").toLocalDate());
                project.setStatus(resultSet.getBoolean("status"));
                project.setTeamId(resultSet.getInt("team_id"));
                return project;
            }
        return null;
    }

    @Override
    public List<Project> getProjectsManagedByManager(User projectManager) throws SQLException {
        	List<Project> projects = new ArrayList<>();
            String sql = "SELECT * FROM Projects WHERE team_id IN " +
                         "(SELECT team_id FROM Teams WHERE manager = ?)";
            connection= db.connect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, projectManager.getUserId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Project project = new Project();
                project.setProjectId(resultSet.getInt("project_id"));
                project.setProjectName(resultSet.getString("project_name"));
                project.setDescription(resultSet.getString("description"));
                project.setStartDate(resultSet.getDate("start_date").toLocalDate());
                project.setStatus(resultSet.getBoolean("status"));
                project.setTeamId(resultSet.getInt("team_id"));
                projects.add(project);
            }
        return projects;
    }

    @Override
    public List<Project> getProjectsAssignedToTester(User tester) throws SQLException {
        List<Project> projects = new ArrayList<>();
            String sql = "SELECT * FROM Projects WHERE team_id IN " +
                         "(SELECT team_id FROM Teams WHERE tester = ?)";
            connection= db.connect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tester.getUserId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Project project = new Project();
                project.setProjectId(resultSet.getInt("project_id"));
                project.setProjectName(resultSet.getString("project_name"));
                project.setDescription(resultSet.getString("description"));
                project.setStartDate(resultSet.getDate("start_date").toLocalDate());
                project.setStatus(resultSet.getBoolean("status"));
                project.setTeamId(resultSet.getInt("team_id"));
                projects.add(project);
            }
        return projects;
    }

    @Override
    public int createProject(Project project) throws SQLException {
        // Implement logic to create a project in the database
    		int projectID=0;
            String sql = "INSERT INTO Projects (project_name, description, start_date, status, team_id) " +
                         "VALUES (?, ?, ?, ?, ?)";
            connection= db.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, project.getProjectName());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setDate(3, Date.valueOf(project.getStartDate()));
            preparedStatement.setBoolean(4, project.isStatus());
            preparedStatement.setInt(5, project.getTeamId());
            preparedStatement.executeUpdate();
            PreparedStatement pstmt1 = connection.prepareStatement(sql);
            
    	    resultSet = pstmt1.executeQuery("select last_insert_id()");
    	    while(resultSet.next()){
    	    	projectID = resultSet.getInt(1);
    	    }
    		
    		return projectID;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}