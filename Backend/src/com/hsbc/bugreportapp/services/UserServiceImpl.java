package com.hsbc.bugreportapp.services;



import com.hsbc.bugreportapp.dao.UserDAO;
import com.hsbc.bugreportapp.dao.UserDAOImpl;

import java.sql.SQLException;

import com.hsbc.bugreportapp.beans.User;

public class UserServiceImpl implements UserService {
	
	UserDAO userDAO = new UserDAOImpl();
    
    @Override
    public boolean authenticateUser(String userId, String password) throws SQLException {
        return userDAO.authenticateUser(userId, password);
    }

    @Override
    public boolean registerUser(User user) throws SQLException {
        return userDAO.registerUser(user);
    }
}
