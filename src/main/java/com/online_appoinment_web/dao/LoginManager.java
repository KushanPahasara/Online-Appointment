package com.online_appoinment_web.dao;

import java.sql.SQLException;

import com.online_appoinment_web.model.User;



public interface LoginManager {
	 
	public User fetchSingleUser(String user_name) throws SQLException, ClassNotFoundException;

}
