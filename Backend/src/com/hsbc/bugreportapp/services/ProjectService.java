package com.hsbc.bugreportapp.services;

import java.sql.SQLException;
import java.util.List;

import com.hsbc.bugreportapp.beans.Project;
import com.hsbc.bugreportapp.beans.User;

public interface ProjectService {
    Project searchProjectById(int projectId) throws SQLException;
    List<Project> searchProjectsManagedByUser(User projectManager) throws SQLException;
    List<Project> searchProjectsAssignedToTester(User tester) throws SQLException;
    int createProject(Project project) throws SQLException;
}
