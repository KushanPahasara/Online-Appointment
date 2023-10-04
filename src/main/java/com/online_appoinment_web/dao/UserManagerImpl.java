package com.online_appoinment_web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.online_appoinment_web.dao.dbutils.DbDriverManager;
import com.online_appoinment_web.dao.dbutils.DbDriverManagerFactory;
import com.online_appoinment_web.model.Appoinment;
import com.online_appoinment_web.model.User;

public class UserManagerImpl implements UserManager {

	
	public UserManagerImpl() {
		// TODO Auto-generated constructor stub
	}
	
       private Connection getConnection() throws ClassNotFoundException, SQLException {
		
		DbDriverManagerFactory driverFactory = new DbDriverManagerFactory();
		DbDriverManager driverManager = driverFactory.getDbDriver("MySQL");
		return driverManager.getConnection();
		
	}
	
	@Override
	public boolean addUser(User user) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
		String query = "INSERT INTO user (user_name,user_password,user_email,tel_number,role_id) VALUES (?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, user.getUser_name());
		ps.setString(2, user.getUser_password());
		ps.setString(3, user.getUser_email());
		ps.setInt(4, user.getTel_number());
		ps.setInt(5, user.getUser_role());
		
		boolean result = false;
		
		if (ps.executeUpdate() > 0)
		    result = true;
		
		
	    ps.close();
		connection.close();
		return result;
	}

	@Override
	public boolean editUser(User user) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
		
		String query = "UPDATE user SET user_name=?, user_password=?, user_email=?, tel_number=?, role_id=? WHERE user_id=?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, user.getUser_name());
		ps.setString(2, user.getUser_password());
		ps.setString(3, user.getUser_email());
		ps.setInt(4, user.getTel_number());
		ps.setInt(5, user.getUser_role());
		ps.setInt(6, user.getUser_id());
		
		boolean result = false;
		
		if(ps.executeUpdate() > 0)
			result = true;
		
		ps.close();
		connection.close();
		
		return result;
	}

	@Override
	public boolean deleteUser(int user_id) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		String query = "DELETE FROM user WHERE user_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, user_id);
		
		boolean result = false;
		
		if(ps.executeUpdate() > 0)
			result = true;
		
		ps.close();
		connection.close();
		
		return result;
	}

	@Override
	public User fetchSingleUser(int user_id) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		
		String query = "SELECT * FROM user WHERE user_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, user_id);
		
		ResultSet rs = ps.executeQuery();
		
		User user = new User();
		
		while(rs.next()) {
			user.setUser_id(rs.getInt("user_id"));
			user.setUser_name(rs.getString("user_name"));
			user.setUser_password(rs.getString("user_password"));
			user.setUser_email(rs.getString("user_email"));
			user.setTel_number(rs.getInt("tel_number"));
			user.setUser_role(rs.getInt("role_id"));
		}
		
		ps.close();
		connection.close();
		return user;
	}

	@Override
	public List<User> fetchAllUsers() throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		String query = "SELECT * FROM user";
		Statement st = connection.createStatement();
		
		List<User> userList = new ArrayList<User>();
		
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			
			User user = new User();
			user.setUser_id(rs.getInt("user_id"));
			user.setUser_name(rs.getString("user_name"));
			user.setUser_password(rs.getString("user_password"));
			user.setUser_email(rs.getString("user_email"));
			user.setTel_number(rs.getInt("tel_number"));
			user.setUser_role(rs.getInt("role_id"));
			
			userList.add(user);
	
		}
		
		st.close();
		connection.close();
		return userList;
	}

	@Override
	public List<User> fetchAllConsultants() throws SQLException, ClassNotFoundException {
		
		Connection connection = getConnection();
		String query = "SELECT * FROM user where role_id=?";
		Statement st = connection.createStatement();
		
		List<User> userList = new ArrayList<User>();
		
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			
			User user = new User();
			user.setUser_id(rs.getInt("user_id"));
			user.setUser_name(rs.getString("user_name"));
			user.setUser_password(rs.getString("user_password"));
			user.setUser_email(rs.getString("user_email"));
			user.setTel_number(rs.getInt("tel_number"));
			user.setUser_role(rs.getInt("role_id"));
			
			userList.add(user);
	
		}
		
		st.close();
		connection.close();
		return userList;
	}

	

}
