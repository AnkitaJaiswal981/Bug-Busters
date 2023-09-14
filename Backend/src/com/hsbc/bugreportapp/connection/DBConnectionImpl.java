package com.hsbc.bugreportapp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionImpl implements DBConnection{

	@Override
	public Connection connect() throws SQLException {
		String url="jdbc:mysql://localhost:3306/codyfury";
		String user= "root";
		String pass="root";
		Connection con= null;
		con=DriverManager.getConnection(url,user,pass);
		return con;
	}

}
