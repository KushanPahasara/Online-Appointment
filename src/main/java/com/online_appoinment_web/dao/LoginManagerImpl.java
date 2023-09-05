package com.online_appoinment_web.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.online_appoinment_web.dao.dbutils.DbDriverManager;
import com.online_appoinment_web.dao.dbutils.DbDriverManagerFactory;
import com.online_appoinment_web.model.User;


public class LoginManagerImpl implements LoginManager {

	public LoginManagerImpl() {
		
	}
	
   private Connection getConnection() throws ClassNotFoundException, SQLException {
		
		DbDriverManagerFactory driverFactory = new DbDriverManagerFactory();
		DbDriverManager driverManager = driverFactory.getDbDriver("MySQL");
		return driverManager.getConnection();
		
	}

@Override
public User fetchSingleUser(String user_name) throws SQLException, ClassNotFoundException {
	
	Connection connection = getConnection();
	
	String query = "SELECT * FROM user WHERE user_name=?";
	PreparedStatement ps = connection.prepareStatement(query);
	ps.setString(1, user_name);
	
	ResultSet rs = ps.executeQuery();
	
	User user = new User();
	
	while(rs.next()) {
		user.setUser_id(rs.getInt("user_id"));
		user.setUser_name(rs.getString("user_name"));
		user.setUser_password(rs.getString("user_password"));
		user.setUser_role(rs.getInt("role_id"));
		user.setUser_email(rs.getString("user_email"));
		
	}
	
	ps.close();
	connection.close();
	return user;
	
}

	
		

	
		
	}

	
	


