package com.online_appoinment_web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.online_appoinment_web.dao.dbutils.DbDriverManager;
import com.online_appoinment_web.dao.dbutils.DbDriverManagerFactory;
import com.online_appoinment_web.model.Appoinment;
import com.online_appoinment_web.model.User;

public class AppoinmentManagerImpl implements AppoinmentManager {

	public AppoinmentManagerImpl() {
		// TODO Auto-generated constructor stub
	}
	

    private Connection getConnection() throws ClassNotFoundException, SQLException {
		
		DbDriverManagerFactory driverFactory = new DbDriverManagerFactory();
		DbDriverManager driverManager = driverFactory.getDbDriver("MySQL");
		return driverManager.getConnection();
		
	}

	@Override
	public boolean addAppoinment(Appoinment appoinment) throws SQLException, ClassNotFoundException {
		
		 Connection connection = getConnection();
			String query = "INSERT INTO appoinment(ap_note,user_id,ap_date,ap_time,country) VALUES (?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, appoinment.getAp_note());
			ps.setInt(2, appoinment.getUser_id());
		    ps.setString(3, appoinment.getAp_date());
		    ps.setString(4, appoinment.getAp_time());
			ps.setString(5, appoinment.getCountry());
			
			boolean result = false;
			
			if (ps.executeUpdate() > 0)
			    result = true;
			
			
		    ps.close();
			connection.close();
			return result;
		
		
	}

	@Override
	public boolean editAppoinment(Appoinment appoinment) throws SQLException, ClassNotFoundException {
           
	    Connection connection = getConnection();
		
			String query = "UPDATE appoinment SET ap_note=?, user_id=?, ap_date=?, ap_time=?, country=? WHERE ap_id=?";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, appoinment.getAp_note());
			ps.setInt(2, appoinment.getUser_id());
			ps.setString(3, appoinment.getAp_date());
			ps.setString(4, appoinment.getAp_time());
			ps.setString(5, appoinment.getCountry());
			ps.setInt(6, appoinment.getAp_id());
			
			boolean result = false;
			
			if(ps.executeUpdate() > 0)
				result = true;
			
			ps.close();
			connection.close();
			
			return result;
		
		
	}

	@Override
	public boolean deleteAppoinment(int ap_id) throws SQLException, ClassNotFoundException {
		
		Connection connection = getConnection();
		String query = "DELETE FROM appoinment WHERE ap_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, ap_id);
		
		boolean result = false;
		
		if(ps.executeUpdate() > 0)
			result = true;
		
		ps.close();
		connection.close();
		
		return result;
		
		
	}

	@Override
	public Appoinment fetchSingleAppoinment(int ap_id) throws SQLException, ClassNotFoundException {
		
       Connection connection = getConnection();
		
		String query = "SELECT * FROM appoinment WHERE ap_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, ap_id);
		
		ResultSet rs = ps.executeQuery();
		
		Appoinment appoinment = new Appoinment();
		
		while(rs.next()) {
			appoinment.setAp_id(rs.getInt("ap_id"));
			appoinment.setAp_note(rs.getString("ap_note"));
			appoinment.setUser_id(rs.getInt("user_id"));
			appoinment.setConsultant_id(rs.getInt("consultant_id"));
			appoinment.setAp_date(rs.getString("ap_date"));
			appoinment.setAp_time(rs.getString("ap_time"));
			appoinment.setCountry(rs.getString("country"));
			
		}
		
		ps.close();
		connection.close();
		return appoinment;
		
		
	}

	@Override
	public List<Appoinment> fetchAllAppoinment() throws SQLException, ClassNotFoundException {
		
		
		
		Connection connection = getConnection();
		String query = "SELECT * FROM appoinment";
		Statement st = connection.createStatement();
		
		List<Appoinment> appoinmentList = new ArrayList<Appoinment>();
		
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			
			Appoinment appoinment = new Appoinment();
			appoinment.setAp_id(rs.getInt("ap_id"));
			appoinment.setAp_note(rs.getString("ap_note"));
			appoinment.setUser_id(rs.getInt("user_id"));
			appoinment.setConsultant_id(rs.getInt("consultant_id"));
			appoinment.setAp_date(rs.getString("ap_date"));
			appoinment.setAp_time(rs.getString("ap_time"));
			appoinment.setCountry(rs.getString("country"));
	
			String q = "SELECT user_name FROM user WHERE user_id=?";
			PreparedStatement ps = connection.prepareStatement(q);
			ps.setInt(1, rs.getInt("user_id"));
			ResultSet result = ps.executeQuery();
			
			if (result.next()) {
			    appoinment.setUser_name(result.getString("user_name"));
			} else {
			    appoinment.setUser_name("N/A"); // Set default value if user is not found
			}
			
			
			appoinmentList.add(appoinment);
	
		}
		
		st.close();
		connection.close();
		return appoinmentList;
		
		
	}


	@Override
	public List<Appoinment> fetchAllAppoinmentUser(int user_id) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		String query = "SELECT * FROM appoinment where user_id = ?";
		PreparedStatement st = connection.prepareStatement(query);
		st.setInt(1, user_id);
		List<Appoinment> appoinmentList = new ArrayList<Appoinment>();
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			
			Appoinment appoinment = new Appoinment();
			appoinment.setAp_id(rs.getInt("ap_id"));
			appoinment.setAp_note(rs.getString("ap_note"));
			appoinment.setUser_id(rs.getInt("user_id"));
			appoinment.setConsultant_id(rs.getInt("consultant_id"));
			appoinment.setAp_date(rs.getString("ap_date"));
			appoinment.setAp_time(rs.getString("ap_time"));
			appoinment.setCountry(rs.getString("country"));
			
			appoinmentList.add(appoinment);
	
		}
		
		st.close();
		connection.close();
		return appoinmentList;
		
	}


	@Override
	public boolean addAppoinmentAdmin(Appoinment appoinment) throws SQLException, ClassNotFoundException {
		   Connection connection = getConnection();
			String query = "INSERT INTO appoinment(ap_note,user_id,consultant_id,ap_date,ap_time,country) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, appoinment.getAp_note());
			ps.setInt(2, appoinment.getUser_id());
			ps.setInt(3, appoinment.getConsultant_id());
		    ps.setString(4, appoinment.getAp_date());
		    ps.setString(5, appoinment.getAp_time());
			ps.setString(6, appoinment.getCountry());
			
			boolean result = false;
			
			if (ps.executeUpdate() > 0)
			    result = true;
			
			
		    ps.close();
			connection.close();
			return result;
		
	}


	@Override
	public boolean editAppoinmentAdmin(Appoinment appoinment) throws SQLException, ClassNotFoundException {
		 Connection connection = getConnection();
			
			String query = "UPDATE appoinment SET ap_note=?, consultant_id=?, ap_date=?, ap_time=?, country=? WHERE ap_id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, appoinment.getAp_note());
			ps.setInt(2, appoinment.getConsultant_id());
			ps.setString(3, appoinment.getAp_date());
			ps.setString(4, appoinment.getAp_time());
			ps.setString(5, appoinment.getCountry());
			ps.setInt(6, appoinment.getAp_id());
			
			boolean result = false;
			
			if(ps.executeUpdate() > 0)
				result = true;
			
			ps.close();
			connection.close();
			
			return result;
	}


	@Override
	public List<Appoinment> fetchAllAppoinmentConsultant(int consultant_id) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		String query = "SELECT * FROM appoinment consultant_id=?";
		PreparedStatement st = connection.prepareStatement(query);
		st.setInt(1, consultant_id);
		List<Appoinment> appoinmentList = new ArrayList<Appoinment>();
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			
			Appoinment appoinment = new Appoinment();
			appoinment.setAp_id(rs.getInt("ap_id"));
			appoinment.setAp_note(rs.getString("ap_note"));
			appoinment.setUser_id(rs.getInt("user_id"));
			appoinment.setAp_date(rs.getString("ap_date"));
			appoinment.setAp_time(rs.getString("ap_time"));
			appoinment.setCountry(rs.getString("country"));
			
			appoinmentList.add(appoinment);
	
		}
		
		st.close();
		connection.close();
		return appoinmentList;
	}


}
