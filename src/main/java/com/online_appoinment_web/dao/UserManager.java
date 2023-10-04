package com.online_appoinment_web.dao;

import java.sql.SQLException;
import java.util.List;

import com.online_appoinment_web.model.User;


public interface UserManager {
	
	public boolean addUser(User user) throws SQLException, ClassNotFoundException;
	public boolean editUser(User user) throws SQLException, ClassNotFoundException;
	public boolean deleteUser(int user_id) throws SQLException, ClassNotFoundException;
	
	public User fetchSingleUser(int user_id) throws SQLException, ClassNotFoundException;
	public List<User> fetchAllUsers() throws SQLException, ClassNotFoundException;
	public List<User> fetchAllConsultants() throws SQLException, ClassNotFoundException;
	
	

}
