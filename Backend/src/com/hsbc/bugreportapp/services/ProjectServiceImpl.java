package com.hsbc.bugreportapp.services;

import java.sql.SQLException;
import java.util.List;

import com.hsbc.bugreportapp.beans.Project;
import com.hsbc.bugreportapp.beans.User;
import com.hsbc.bugreportapp.dao.ProjectServiceDAO;
import com.hsbc.bugreportapp.dao.ProjectServiceDAOImpl;

public class ProjectServiceImpl implements ProjectService {
    private ProjectServiceDAO projectDAO= new ProjectServiceDAOImpl();

	@Override
	public Project searchProjectById(int projectId) throws SQLException {
		// TODO Auto-generated method stub
		return projectDAO.getProjectById(projectId);
	}

	@Override
	public List<Project> searchProjectsManagedByUser(User projectManager) throws SQLException {
		// TODO Auto-generated method stub
		return projectDAO.getProjectsManagedByManager(projectManager);
	}

	@Override
	public List<Project> searchProjectsAssignedToTester(User tester) throws SQLException {
		// TODO Auto-generated method stub
		return projectDAO.getProjectsAssignedToTester(tester);
	}

	@Override
	public int createProject(Project project) throws SQLException {
		// TODO Auto-generated method stub
		return projectDAO.createProject(project);
	}


}
