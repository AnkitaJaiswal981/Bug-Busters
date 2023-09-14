package com.hsbc.bugreportapp.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnection {
	/**
	 * {@summary} This method calls the JDBC Driver and accepts three parameters: URL, Username, Password
	 * and returns a connection instance.
	 * 
	 * @return con: An instance of Connection type 
	 * */
	public Connection connect() throws SQLException;
}
