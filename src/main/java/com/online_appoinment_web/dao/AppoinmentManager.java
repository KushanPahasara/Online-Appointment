package com.online_appoinment_web.dao;

import java.sql.SQLException;
import java.util.List;

import com.online_appoinment_web.model.Appoinment;


public interface AppoinmentManager {
	

	public boolean addAppoinment(Appoinment appoinment) throws SQLException, ClassNotFoundException;
	public boolean addAppoinmentAdmin(Appoinment appoinment) throws SQLException, ClassNotFoundException;
	public boolean addStatus(Appoinment appoinment) throws SQLException, ClassNotFoundException;
	
	public boolean editAppoinment(Appoinment appoinment) throws SQLException, ClassNotFoundException;
	public boolean editAppoinmentAdmin(Appoinment appoinment) throws SQLException, ClassNotFoundException;
	public boolean deleteAppoinment(int ap_id) throws SQLException, ClassNotFoundException;
	
	
	
	public Appoinment fetchSingleAppoinment(int ap_id) throws SQLException, ClassNotFoundException;
	public List<Appoinment> fetchAllAppoinment() throws SQLException, ClassNotFoundException;
	public List<Appoinment> fetchAllAppoinmentUser(int user_id) throws SQLException, ClassNotFoundException;
	public List<Appoinment> fetchAllAppoinmentConsultant(String consultant_id) throws SQLException, ClassNotFoundException;
	
	

}
