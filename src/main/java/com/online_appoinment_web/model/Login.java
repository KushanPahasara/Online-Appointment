package com.online_appoinment_web.model;

public class Login {
	
	
	private String user_name;
	private String password;
	private int role;
	private String user_email;

	public Login() {
	
	}

	public Login(int user_id, String user_name, String password, int role, String user_email) {
	
		
		this.user_name = user_name;
		this.password = password;
		this.role = role;
		this.user_email = user_email;
	}

	public String getUserName() {
		return user_name;
	}

	public void setUserName(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
	
	
	
	
	
	
	

}
