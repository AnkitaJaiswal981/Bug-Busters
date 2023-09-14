package com.hsbc.bugreportapp.services;

import java.sql.SQLException;
import java.util.List;

import com.hsbc.bugreportapp.beans.Bug;
import com.hsbc.bugreportapp.beans.User;
import com.hsbc.bugreportapp.dao.BugServiceDAO;
import com.hsbc.bugreportapp.dao.BugServiceDAOImpl;
import com.hsbc.bugreportapp.enums.SeverityLevel;

public class BugServiceImpl implements BugService{
	private static BugServiceDAO bugDAO= new BugServiceDAOImpl();

	@Override
	public Bug searchBugById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return bugDAO.getBugsById(id);
	}

	@Override
	public List<Bug> searchBugsReportedByTester(User tester) throws SQLException {
		// TODO Auto-generated method stub
		return bugDAO.getBugsReportedByTester(tester);
	}

	@Override
	public List<Bug> searchBugsAssignedToDeveloper(User developer) throws SQLException {
		// TODO Auto-generated method stub
		
		// Checking if the user is developer
		if(developer.getUserType().equals("Developer") || developer.getUserType().equals("developer"))
			return bugDAO.getBugsAssignedToDeveloper(developer);
		else
			System.out.println("Error: The user is not a Developer");
		return null;
	}

	@Override
	public int createBug(User tester) throws SQLException { 
		// Need to pass project status-id to check if the project is in progress (True)
		
		
		Bug bug= new Bug("Login page not working",
						"Login page not loading",
						4, SeverityLevel.Critical);
		// Only testers can report new bug. Testing if the user is a tester.
		if(tester.getUserType().equals("Tester") || tester.getUserType().equals("Tester"))
			//if(project.isStatus())
				return bugDAO.saveBug(bug, tester);
		else
			System.out.println("Error: The user is not a tester");
		
		return 0;
		//Returns Zero to indicate that no BugId has been generated.s
	}
	
	@Override
	public boolean assignBugToDeveloper(Bug bug, User developer) throws SQLException {
		// Accept team parameter and check developer and manager belongs to the same team
		
		//Only developer
		if(developer.getUserType().equals("Developer") || developer.getUserType().equals("developer"))
			return bugDAO.updateBugsForDeveloper(bug, developer);
		else
			System.out.println("User is not a developer. Cannot be assigned");
		return false;
		//Returns false to indicate that bug has not been assigned to a developer.
		
	}

	@Override
	public boolean markBugForClosing(Bug bug, User developer) throws SQLException {
		// TODO Auto-generated method stub
		if(developer.getUserType().equals("Developer") || developer.getUserType().equals("developer"))
			return bugDAO.updateBugForClosing(bug, developer);
		else
			System.out.println("Error: The user is not a developer");
			return false;
			//Returns false to indicate that bug hasn't been marked for closing.
	}

	@Override
	public boolean closeBug(Bug bug, User projectManager) throws SQLException {
		// TODO Auto-generated method stub
		//Only Manager can close a bug.
		if(projectManager.getUserType().equals("Manager") || projectManager.getUserType().equals("manager"))
		{
			if(bug.isMarkedForClosing())							
				// Bugs can also be closed if it is marked for closing
				return bugDAO.updateBugAsClosed(bug, projectManager);
			else
			{
				System.out.println("This bug has not been marked for closing.");
				return true;										
				// Returns true to indicate that bug is still open.	
			}
		}
		else
		{
			System.out.println("Error: The user is not a Manager.");
			return true;
		}
		
		
	}

}
