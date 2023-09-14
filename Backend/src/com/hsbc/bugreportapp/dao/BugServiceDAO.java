package com.hsbc.bugreportapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.hsbc.bugreportapp.beans.Bug;
import com.hsbc.bugreportapp.beans.User;

public interface BugServiceDAO {
	/**
	 * {@summary} This method accepts an integer as parameter (Bug ID) 
		and fetches the record from the 'bugs' table.
		It returns a Bug object. 
	 *	
	 *	@param id: This parameter accepts an ID from the Bug object.
	 *
	 * 	@return bug: It returns a Bug object.
	 * 
	 * 	*/
	public Bug getBugsById(int id) throws SQLException;
	
	/**
	 * {@summary} This method accepts an User object of type tester 
	 * and fetches all the records from the bug table 
	 * then returns a collection of Bug objects. 
	 * 
	 * @param tester: It is an instance of User object with type Tester.
	 * 
	 * @return bugs: It returns a collection of bug objects.
	 * */
	public List<Bug> getBugsReportedByTester(User tester) throws SQLException;
	
	/**
	 * {@summary} This method accepts an User object of type developer 
	 * and fetches all the records from the bug table 
	 * then returns a collection of Bug objects. 
	 * 
	 * @param tester: It is an instance of User object with type Developer.
	 * 
	 * @return bugs: It returns a collection of bug objects.
	 * */
	public List<Bug> getBugsAssignedToDeveloper(User developer) throws SQLException;
	
	/**
	 * {@summary} This method accepts an User object of type tester 
	 * and an initialized Bug object and enters a new record into the bug table. 
	 * then returns a newly created unique BugID. 
	 * 
	 * @param tester: It is an instance of User object with type Tester.
	 * 			bug	: It is an instance of Bug object.
	 * 
	 * @return bugs: It returns a bugID.
	 * */
	public int saveBug(Bug bug, User tester) throws SQLException;
	
	/**
	 * {@summary} This method accepts an User object of type developer 
	 * and updates the record of the bug table with developer ID,
	 * It must have the same unique bug ID as our parameter. 
	 * then returns a boolean value. 
	 * 
	 * @param tester: It is an instance of User object with type Developer.
	 * 			bug	: It is an instance of Bug object.
	 * 
	 * @return bugs: It returns a boolean value.
	 * */
	public boolean updateBugsForDeveloper(Bug bug, User developer) throws SQLException;
	
	/**
	 * {@summary} This method accepts an User object of type developer and a Bug Object 
	 * and updates the field "mark_for_closing" of the bug table with developer ID, 
	 * It must have the same unique bug ID as our parameter. 
	 * then returns a boolean value. 
	 * 
	 * @param tester: It is an instance of User object with type Developer.
	 * 			bug	: It is an instance of Bug object.
	 * 
	 * @return bugs: It returns a boolean value.
	 * */
	public boolean updateBugForClosing(Bug bug, User developer) throws SQLException;
	
	/**
	 * {@summary} This method accepts an User object of type developer and a Bug Object 
	 * and updates the field "closed_by","closed_on","status" of the bug table with Manager ID,
	 * current date, and a boolean value. 
	 * It must have the same unique bug ID as our parameter. 
	 * then returns a boolean value corresponding to the status. 
	 * 
	 * @param tester: It is an instance of User object with type Developer.
	 * 			bug	: It is an instance of Bug object.
	 * 
	 * @return bugs: It returns a boolean value corresponding to the status.
	 * */
	public boolean updateBugAsClosed(Bug bug, User projectManager) throws SQLException;
}
