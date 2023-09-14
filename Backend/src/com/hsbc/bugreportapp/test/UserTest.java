package com.hsbc.bugreportapp.test;



import com.hsbc.bugreportapp.services.UserService;
import com.hsbc.bugreportapp.services.UserServiceImpl;

import java.sql.SQLException;

import com.hsbc.bugreportapp.beans.User;
public class UserTest {
	private static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        
		/**  Future Scope (Prototype code for SQL Injection Validator)
		 * 
		 * 
		 * String userInput1 = "John Doe"; String userInput2 = "John' OR '1'='1"; String
		 * userInput3 = "SELECT * FROM users";
		 * 
		 * System.out.println("User Input 1 (Safe): " + isSafeInput(userInput1));
		 * System.out.println("User Input 2 (Potentially Unsafe): " +
		 * isSafeInput(userInput2));
		 * System.out.println("User Input 3 (Potentially Unsafe): " +
		 * isSafeInput(userInput3));
		 */
        authenticateUser();
        //registerUser();
        
        
//      public int addBug(String title, String description, int projectid, int createdby, int assignedto, 
//  			Boolean markedforclosing, int closedby, Date closedon, String status, String severity);
      
//      BugService bugService = new BugImpl();
//      bugService.addBug("Login Issue", "Unable to change password", 2, 4, 3, null, 0, null, "open", "medium");
//      
//  }
    
}

	private static void registerUser() {
		
		try {
				/// Register User
				User user = new User("D003","Ankita", "ankita@example","ankita123", "Developer");
				if(userService.registerUser(user))
					System.out.println(" Record saved of user ID: "+ user.getUserId());
				else
					System.out.println("User registration failed.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void authenticateUser() {

        try {
        	// Authenticating user:
            String userId = "D003";
            String password = "ankita123";
			if (userService.authenticateUser(userId, password)) {
			    System.out.println("Login successful.");
			} else {
			    System.out.println("Login failed. Invalid credentials.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    }
	