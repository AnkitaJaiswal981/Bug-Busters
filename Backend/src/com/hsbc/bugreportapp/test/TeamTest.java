package com.hsbc.bugreportapp.test;

import java.sql.SQLException;
import java.util.List;

import com.hsbc.bugreportapp.beans.Team;
import com.hsbc.bugreportapp.beans.User;
import com.hsbc.bugreportapp.services.TeamService;
import com.hsbc.bugreportapp.services.TeamServiceImpl;

public class TeamTest  {
	private static TeamService teamService = new TeamServiceImpl();
    public static void main(String[] args) {
    

        teamByProjectAndUser();

        //developersByProject();

        //testersByProject();

        //createTeam();
    }

	private static void createTeam() {
		// Test Case 4: Create Team
        try {
        	int teamID=0;
            Team newTeam = new Team();
            newTeam.setManager("M001"); // Replace with a valid manager ID
            newTeam.setDeveloper1("D001"); // Replace with a valid developer ID
            newTeam.setDeveloper2("D002"); // Replace with a valid developer ID
            newTeam.setTester("T001"); // Replace with a valid tester ID
            teamID= teamService.createTeam(newTeam);
            if(teamID>0)
            	System.out.println("Team created successfully with team ID: "+teamID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	private static void testersByProject() {
		// Test Case 3: Get Testers By Project
        try {
            int projectId = 1; // Replace with a valid project ID
            List<User> testers = teamService.getTestersByProject(projectId);
            if (!testers.isEmpty()) {
                System.out.println("Testers for Project " + projectId + ":");
                for (User tester : testers) {
                    System.out.println("User ID: " + tester.getUserId());
                    System.out.println("Name: " + tester.getName());
                    System.out.println("Email: " + tester.getEmail());
                    System.out.println("User Type: " + tester.getUserType());
                    System.out.println();
                }
            } else {
                System.out.println("No testers found for the given project.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	private static void developersByProject() {
		// Test Case 2: Get Developers By Project
        try {
            int projectId = 1; // Replace with a valid project ID
            List<User> developers = teamService.getDevelopersByProject(projectId);
            if (!developers.isEmpty()) {
                System.out.println("Developers for Project " + projectId + ":");
                for (User developer : developers) {
                    System.out.println("Name: " + developer.getName());
                    System.out.println("Email: " + developer.getEmail());
                    System.out.println("User Type: " + developer.getUserType());
                    System.out.println();
                }
            } else {
                System.out.println("No developers found for the given project.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	private static void teamByProjectAndUser() {
		// Test Case 1: Get Team By Project And User
        try {
            int projectId = 1; // Replace with a valid project ID
            User user = new User(); // Replace with a valid User object
            Team team = teamService.getTeamByProjectAndUser(projectId, user);
            if (team != null) {
                System.out.println("Team Details:");
                System.out.println("Team ID: " + team.getTeamId());
                System.out.println("Manager: " + team.getManager());
                System.out.println("Developer 1: " + team.getDeveloper1());
                System.out.println("Developer 2: " + team.getDeveloper2());
                System.out.println("Tester: " + team.getTester());
            } else {
                System.out.println("Team not found for the given project and user.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}