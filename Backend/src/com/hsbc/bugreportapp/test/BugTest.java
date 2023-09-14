package com.hsbc.bugreportapp.test;

import java.sql.SQLException;

import com.hsbc.bugreportapp.services.UserService;
import com.hsbc.bugreportapp.services.UserServiceImpl;
import com.hsbc.bugreportapp.beans.Bug;
import com.hsbc.bugreportapp.beans.User;
import com.hsbc.bugreportapp.services.BugService;
import com.hsbc.bugreportapp.services.BugServiceImpl;

public class BugTest {

	private static BugService bugService= new BugServiceImpl();
	private static UserService userService = new UserServiceImpl();
	private static int bugId;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bugsByIdSearch();
		//bugCreate();
		//bugsReportedByTesterSearch();
		//bugsAssignedToDeveloperSearch();
		//bugAssignmentToDeveloper();
		//bugMarkedForClosing();
		//bugMarkedAsClosed();
		
	}

	private static void bugMarkedAsClosed() {
		try {
			Bug bug= new Bug();
			bug= bugService.searchBugById(1);
			User manager= new User("M001","abc","abc@example","Manager");
			if(!bugService.closeBug(bug, manager))
				{
					System.out.println("Bug has been closed by Manager with user id: "+manager.getUserId());
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void bugMarkedForClosing() {
		try {
			Bug bug= new Bug();
			bug= bugService.searchBugById(1);
			User developer= new User("D002","abc","abc@example","Beveloper");
			if(bugService.markBugForClosing(bug, developer))
				System.out.println("Bug has been marked for closing by developer with User ID: "+developer.getUserId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void bugAssignmentToDeveloper() { 
		// Send team parameter and check developer and manager belongs to the same team
		try {
			Bug bug= new Bug();
			bug= bugService.searchBugById(1);
			User developer= new User("D002","abc","abc@example","Developer");
			if(bugService.assignBugToDeveloper(bug,developer))
					System.out.println("Bug has been assigned to developer with User ID: "+developer.getUserId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void bugsAssignedToDeveloperSearch() {
		try {
			User developer= new User("D001", "abc", "abc@example.com","Developer");
			System.out.println(bugService.searchBugsAssignedToDeveloper(developer));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void bugsReportedByTesterSearch() {
		try {
			User tester= new User("T001");
			System.out.println(bugService.searchBugsReportedByTester(tester));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void bugCreate() {
		User tester= new User("T001","abc","abc@example","Tester");
		
			try {
				
					bugId = bugService.createBug(tester);
					if(bugId>0)
						System.out.println("A new bug has been reported by Tester with user ID: "+tester.getUserId()
						+" with unique bug ID: "+bugId);
					else
						System.out.println("Bug has not been created. Please check if the user is a tester.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	private static void bugsByIdSearch() {
		
		try {
			System.out.println(bugService.searchBugById(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
