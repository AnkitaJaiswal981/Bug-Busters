package com.hsbc.bugreportapp.dao;

import java.sql.SQLException;

import com.hsbc.bugreportapp.beans.User;

public interface UserDAO {
    boolean authenticateUser(String userId, String password) throws SQLException;
    boolean registerUser(User user) throws SQLException;
}
