package com.hsbc.bugreportapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.hsbc.bugreportapp.beans.Project;
import com.hsbc.bugreportapp.beans.User;

public interface ProjectServiceDAO {
	Project getProjectById(int projectId) throws SQLException;
    List<Project> getProjectsManagedByManager(User projectManager) throws SQLException;
    List<Project> getProjectsAssignedToTester(User tester) throws SQLException;
    int createProject(Project project) throws SQLException;
}
