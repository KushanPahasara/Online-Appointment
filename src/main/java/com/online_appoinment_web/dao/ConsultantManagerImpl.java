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
import com.online_appoinment_web.model.Consultant;
import com.online_appoinment_web.model.User;

public class ConsultantManagerImpl implements ConsultantManager {

	public ConsultantManagerImpl() {
		// TODO Auto-generated constructor stub
	}
	
   private Connection getConnection() throws ClassNotFoundException, SQLException {
		
		DbDriverManagerFactory driverFactory = new DbDriverManagerFactory();
		DbDriverManager driverManager = driverFactory.getDbDriver("MySQL");
		return driverManager.getConnection();
		
	}

	@Override
	public boolean addConsultant(Consultant consultant) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		String query = "INSERT INTO consultant (consultant_name, consultant_age, gender, consultant_telephone, consultant_email) VALUES (?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, consultant.getConsultant_name());
		ps.setInt(2, consultant.getConsultant_age());
		ps.setString(3, consultant.getGender());
		ps.setString(4, consultant.getConsultant_telephone());
		ps.setString(5, consultant.getConsultant_email());
	
		boolean result = false;
		
		if (ps.executeUpdate() > 0)
		    result = true;
		
		
	    ps.close();
		connection.close();
		return result;
	}

	@Override
	public boolean editConsultant(Consultant consultant) throws SQLException, ClassNotFoundException {
    Connection connection = getConnection();
		
		String query = "UPDATE consultant SET consultant_name=?, consultant_age=?, gender=?, consultant_telephone=?, consultant_email=? WHERE consultant_id=?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, consultant.getConsultant_name());
		ps.setInt(2, consultant.getConsultant_age());
		ps.setString(3, consultant.getGender());
		ps.setString(4, consultant.getConsultant_telephone());
		ps.setString(5, consultant.getConsultant_email());
	    ps.setInt(6, consultant.getConsultant_id());
		
		boolean result = false;
		
		if(ps.executeUpdate() > 0)
			result = true;
		
		ps.close();
		connection.close();
		
		return result;
	}

	@Override
	public boolean deleteConsultant(int consultant_id) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		String query = "DELETE FROM consultant WHERE consultant_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, consultant_id);
		
		boolean result = false;
		
		if(ps.executeUpdate() > 0)
			result = true;
		
		ps.close();
		connection.close();
		
		return result;
	}

	@Override
	public Consultant fetchSingleConsultant(int consultant_id) throws SQLException, ClassNotFoundException {
	Connection connection = getConnection();
		
		String query = "SELECT * FROM consultant WHERE consultant_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, consultant_id);
		
		ResultSet rs = ps.executeQuery();
		
		Consultant consultant = new Consultant();
		
		while(rs.next()) {
			consultant.setConsultant_id(rs.getInt("consultant_id"));
			consultant.setConsultant_name(rs.getString("consultant_name"));
			consultant.setConsultant_age(rs.getInt("consultant_age"));
			consultant.setGender(rs.getString("gender"));
			consultant.setConsultant_telephone(rs.getString("consultant_telephone"));
			consultant.setConsultant_email(rs.getString("consultant_email"));
			
		}
		
		ps.close();
		connection.close();
		return consultant;
	}

	@Override
	public List<Consultant> fetchAllConsultant() throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		String query = "SELECT * FROM consultant";
		Statement st = connection.createStatement();
		
		List<Consultant> consultantList = new ArrayList<Consultant>();
		
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			
			Consultant consultant = new Consultant();
			consultant.setConsultant_id(rs.getInt("consultant_id"));
			consultant.setConsultant_name(rs.getString("consultant_name"));
			consultant.setConsultant_age(rs.getInt("consultant_age"));
			consultant.setGender(rs.getString("gender"));
			consultant.setConsultant_telephone(rs.getString("consultant_telephone"));
			consultant.setConsultant_email(rs.getString("consultant_email"));
			
			
			consultantList.add(consultant);
	
		}
		
		st.close();
		connection.close();
		return consultantList;
	}

}
