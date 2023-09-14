package com.hsbc.bugreportapp.test;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.hsbc.bugreportapp.beans.Project;
import com.hsbc.bugreportapp.beans.User;
import com.hsbc.bugreportapp.services.ProjectService;
import com.hsbc.bugreportapp.services.ProjectServiceImpl;

public class ProjectTest {
    // Create an instance of ProjectService
    private static ProjectService projectService = new ProjectServiceImpl();
    
    public static void main(String[] args) {


        projectsById();

        //projectsManagedByUser();

        //projectAssignedToTester();

        //createProject();
    }

	private static void createProject() {
		// Test createProject method
        
        try {
        	Project newProject = new Project();
            newProject.setProjectName("New Project");
            newProject.setDescription("A new project");
            newProject.setStartDate(LocalDate.now());
            newProject.setStatus(true);
            newProject.setTeamId(1);
			int projectID= projectService.createProject(newProject);
			System.out.println("\nNew project created with ID: " + projectID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void projectAssignedToTester() {
		// Test getProjectsAssignedToTester method
        
		try {
			User tester = new User();
	        tester.setUserId("T001");
	        List<Project> projectsAssignedToTester;
			projectsAssignedToTester = projectService.searchProjectsAssignedToTester(tester);
			if (!projectsAssignedToTester.isEmpty()) {
	            System.out.println("\nProjects assigned to tester:");
	            for (Project project : projectsAssignedToTester) {
	                System.out.println(project);
	            }
	        } else {
	            System.out.println("\nNo projects assigned to tester: " + tester.getUserId());
	     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        

	private static void projectsManagedByUser() {
		// Test getProjectsManagedByUser method
		try {
			User manager = new User();
	        manager.setUserId("M001");
	        List<Project> projectsManagedByUser;
			projectsManagedByUser = projectService.searchProjectsManagedByUser(manager);
			if (!projectsManagedByUser.isEmpty()) {
	            System.out.println("\nProjects managed by user:");
	            for (Project project : projectsManagedByUser) {
	                System.out.println(project);
	            }
	        } else {
	            System.out.println("\nNo projects managed by user: " + manager.getUserId());
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

	private static void projectsById() {
		// Test getProjectById method
        
		try {
			int projectIdToRetrieve = 1;
	        Project retrievedProject= new Project();
			retrievedProject = projectService.searchProjectById(projectIdToRetrieve);
			if (retrievedProject != null) {
	            System.out.println("Project retrieved by ID:");
	            System.out.println(retrievedProject);
	        } else {
	            System.out.println("Project not found by ID: " + projectIdToRetrieve);
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
