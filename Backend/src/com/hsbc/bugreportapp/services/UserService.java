package com.hsbc.bugreportapp.services;

import java.sql.SQLException;

import com.hsbc.bugreportapp.beans.User;

public interface UserService {
    boolean authenticateUser(String userId, String password) throws SQLException;
    boolean registerUser(User user) throws SQLException;
}
