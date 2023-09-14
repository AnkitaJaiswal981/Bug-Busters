package com.hsbc.bugreportapp.services;

import java.sql.SQLException;
import java.util.List;

import com.hsbc.bugreportapp.beans.Bug;
import com.hsbc.bugreportapp.beans.User;

public interface BugService {
	/**
	 * {@summary} This method calls the DAO method 'getBugsById' 
	 * and returns a Bug object to the testing page.
	 * 
	 * @param id: This parameter accepts an ID from the bug object.
	 * 
	 * @return Bug: It returns the record associated with the Bug ID.
	 * 
	 * @author Sayan Bakshi*/
	public Bug searchBugById(int id) throws SQLException;
	
	/**
	 * {@summary} This method calls the DAO method 'getBugsReportedByTester' 
	 * then returns a collection of Bug objects. 
	 * 
	 * @param tester: It is an instance of User object with type Tester.
	 * 
	 * @return bugs: It returns a collection of bug objects.
	 * 
	 * @author Sayan Bakshi
	 * */
	public List<Bug> searchBugsReportedByTester(User tester) throws SQLException;
	
	/**
	 * {@summary} This method calls the DAO method 'getBugsAssignedToDeveloper'
	 * then returns a collection of Bug objects. 
	 * 
	 * @param tester: It is an instance of User object with type Developer.
	 * 
	 * @return bugs: It returns a collection of bug objects.
	 * 
	 * @author Sayan Bakshi
	 * */
	public List<Bug> searchBugsAssignedToDeveloper(User developer) throws SQLException;
	
	/**
	 * {@summary} This method calls the DAO method 'saveBug' 
	 * only if the user ID is of Tester
	 * then returns a newly created unique BugID. 
	 * 
	 * @param tester: It is an instance of User object with type Tester.
	 * 			bug	: It is an instance of Bug object.
	 * 
	 * @return bugs: It returns a bugID.
	 * 
	 * @author Sayan Bakshi
	 * */
	public int createBug(User tester) throws SQLException; 
	
	/**
	 * {@summary} This method calls the DAO method 'updateBugsForDeveloper'
	 * only if the user ID is of Developer
	 * then returns a boolean value if the update is successful.
	 * 
	 * @param tester: It is an instance of User object with type Developer.
	 * 			bug	: It is an instance of Bug object.
	 * 
	 * @return bugs: It returns a boolean value.
	 * 
	 * @author Sayan Bakshi
	 * */
	public boolean assignBugToDeveloper(Bug bug, User developer) throws SQLException;
	
	/**
	 * {@summary} This method calls the DAO method 'updateBugForClosing'
	 * only if the user ID is of Developer
	 * then returns a boolean value if the bug has been successfully marked for closing.
	 * 
	 * @param tester: It is an instance of User object with type Developer.
	 * 			bug	: It is an instance of Bug object.
	 * 
	 * @return bugs: It returns a boolean value.
	 * 
	 * @author Sayan Bakshi
	 * */
	public boolean markBugForClosing(Bug bug,User developer) throws SQLException;
	
	/**
	 * {@summary} This method calls the DAO method 'updateBugAsClosed'
	 * only if the user ID is of Manager
	 * then returns a boolean value corresponding to the status. 
	 * 
	 * @param tester: It is an instance of User object with type Developer.
	 * 			bug	: It is an instance of Bug object.
	 * 
	 * @return bugs: It returns a boolean value corresponding to the status.
	 * 
	 * @author Sayan Bakshi
	 * */
	public boolean closeBug(Bug bug, User projectManager) throws SQLException;
	
}
