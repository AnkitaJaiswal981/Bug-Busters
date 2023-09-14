package com.hsbc.bugreportapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.bugreportapp.beans.Team;
import com.hsbc.bugreportapp.beans.User;
import com.hsbc.bugreportapp.connection.DBConnection;
import com.hsbc.bugreportapp.connection.DBConnectionImpl;

public class TeamServiceDAOImpl implements TeamServiceDAO {

	private static DBConnection db= new DBConnectionImpl();
	private static Connection connection=null;
	private static PreparedStatement preparedStatement=null;
	private static ResultSet resultSet=null;

    @Override
    public Team getTeamByProjectAndUser(int projectId, User user) throws SQLException {
            String sql = "SELECT * FROM Teams WHERE team_id IN (SELECT team_id FROM Projects WHERE project_id = ?)";
            connection= db.connect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, projectId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Team team = new Team();
                team.setTeamId(resultSet.getInt("team_id"));
                team.setManager(resultSet.getString("manager"));
                team.setDeveloper1(resultSet.getString("developer_1"));
                team.setDeveloper2(resultSet.getString("developer_2"));
                team.setTester(resultSet.getString("tester"));
                return team;
            }
        return null;
    }

    @Override
    public List<User> getDevelopersByProject(int projectId) throws SQLException {
        List<User> developers = new ArrayList<>();
            String sql = "SELECT * FROM Users WHERE user_id IN " +
                         "(SELECT developer_1 FROM Teams WHERE team_id IN " +
                         "(SELECT team_id FROM Projects WHERE project_id = ?))";
            connection= db.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, projectId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            	
            	User developer = new User();
            	developer.setName(resultSet.getString("name"));
                developer.setEmail(resultSet.getString("email"));
                developer.setPassword(resultSet.getString("password"));
                developer.setUserType(resultSet.getString("user_type"));
                developers.add(developer);
            }
        return developers;
    }

    @Override
    public List<User> getTestersByProject(int projectId) throws SQLException {
        List<User> testers = new ArrayList<>();
            String sql = "SELECT * FROM Users WHERE user_id IN " +
                         "(SELECT tester FROM Teams WHERE team_id IN " +
                         "(SELECT team_id FROM Projects WHERE project_id = ?))";
            connection= db.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, projectId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User tester = new User();
                tester.setUserId(resultSet.getString("user_id"));
                tester.setName(resultSet.getString("name"));
                tester.setEmail(resultSet.getString("email"));
                tester.setUserType(resultSet.getString("user_type"));
                testers.add(tester);
            }
        return testers;
    }

    @Override
    public int createTeam(Team team) throws SQLException {
        // Implement logic to create a team in the database
    		int teamID=0;
            String sql = "INSERT INTO Teams (manager, developer_1, developer_2, tester) VALUES (?, ?, ?, ?)";
            connection= db.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, team.getManager());
            preparedStatement.setString(2, team.getDeveloper1());
            preparedStatement.setString(3, team.getDeveloper2());
            preparedStatement.setString(4, team.getTester());
            preparedStatement.executeUpdate();
            PreparedStatement pstmt1 = connection.prepareStatement(sql);
            
    	    resultSet = pstmt1.executeQuery("select last_insert_id()");
    	    while(resultSet.next()){
    	    	teamID = resultSet.getInt(1);
    	    }
    		
    		return teamID;
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
