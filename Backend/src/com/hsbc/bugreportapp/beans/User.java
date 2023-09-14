package com.hsbc.bugreportapp.beans;

import java.util.Objects;

public class User {

	private int id;						// Unique id of 'users' table. It is auto-incremented every time a user is created.
	private String userId;				// User ID of a user. It is unique
	private String name;				// Name of a user
	private String email;				// Email of the user
	private String password;			// Password of the user
	private String userType;			// Type of user (Manager/Developer/Tester)
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String userId) {
		this.userId = userId;
	}
	
	

	public User(String userId, String name, String email, String userType) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.userType = userType;
	}
	
	


	public User(String userId, String name, String email, String password, String userType) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.userType = userType;
	}



	public int getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", name=" + name + ", email=" + email + ", password="
				+ password + ", userType=" + userType + "]";
	}

	

	
	
}
