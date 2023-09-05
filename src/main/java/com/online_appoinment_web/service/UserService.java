package com.online_appoinment_web.service;

import java.sql.SQLException;
import java.util.List;

import com.online_appoinment_web.dao.UserManager;
import com.online_appoinment_web.dao.UserManagerImpl;
import com.online_appoinment_web.model.User;



public class UserService {
	
	
private static UserService userServiceObj;
	
	
	private UserService() {
		
	}
	
	public synchronized static UserService getUserService() {
		if(userServiceObj == null) {
			userServiceObj = new UserService();
		}
		
		return userServiceObj;
	}
	
	private UserManager getUserManager() {
		return new UserManagerImpl();
	}
	
	public boolean addUser(User user) throws ClassNotFoundException, SQLException {
		return getUserManager().addUser(user);
	}
	
	public boolean editUser(User user) throws ClassNotFoundException, SQLException {
		return getUserManager().editUser(user);
	}
	
	public boolean deleteUser(int user_id) throws ClassNotFoundException, SQLException {
		return getUserManager().deleteUser(user_id);
	}
	
	public User fetchSinglUser(int user_id) throws ClassNotFoundException, SQLException {
		return getUserManager().fetchSingleUser(user_id);
	}
	
	public List<User> fetchAllUsers() throws ClassNotFoundException, SQLException{
		return getUserManager().fetchAllUsers();
	}

}
