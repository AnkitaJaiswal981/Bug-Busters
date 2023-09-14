package com.hsbc.bugreportapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.hsbc.bugreportapp.beans.User;
import com.hsbc.bugreportapp.connection.DBConnection;
import com.hsbc.bugreportapp.connection.DBConnectionImpl;

public class UserDAOImpl implements UserDAO {
	private static DBConnection db= new DBConnectionImpl();
	private static Connection con=null;
	private static PreparedStatement stmt=null;
	private static ResultSet rs=null;


    public boolean authenticateUser(String userId, String password) throws SQLException {
        	String query= "SELECT password FROM users WHERE user_id=?";
    		con=db.connect();
            stmt = con.prepareStatement(query);

            stmt.setString(1, userId);
            rs = stmt.executeQuery();
                if (rs.next()) {
                    String storedPassword = rs.getString("Password");   
                    // Verify the entered password against the stored password
                    if(password.equals(storedPassword))
                    	return true;	// Authentication success
                    	// Authentication failed
                }
				return false;

    }

	@Override
	public boolean registerUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		String query= "INSERT INTO users (user_id, name, email, password, user_type) VALUES (?, ?, ?, ?, ?)";
		con=db.connect();
		stmt = con.prepareStatement(query);
        stmt.setString(1, user.getUserId());
        stmt.setString(2, user.getName());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getPassword());
        stmt.setString(5, user.getUserType());
        
       
	    return stmt.executeUpdate() > 0;
	}
	
	//future scope
	
	/**
	 * private String generateSessionId() { 
	 * 
	 * return UUID.randomUUID().toString(); 
	 * }
	 */
}
