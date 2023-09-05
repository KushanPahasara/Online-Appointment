package com.online_appoinment_web.service;

import java.sql.SQLException;

import com.online_appoinment_web.dao.LoginManager;
import com.online_appoinment_web.dao.LoginManagerImpl;
import com.online_appoinment_web.model.User;



public class LoginService {
	
	private static LoginService loginServiceObj;

	public LoginService() {
		
	}
	
	public synchronized static LoginService getLoginService() {
		if(loginServiceObj == null) {
			loginServiceObj = new LoginService();
		}
		
		return loginServiceObj;
		
	}
	
	private LoginManager getLoginManager() {
		return new LoginManagerImpl();
	}
	
	public User fetchSingleUser(String user_name) throws ClassNotFoundException, SQLException {
		return getLoginManager().fetchSingleUser(user_name);
	}
}
