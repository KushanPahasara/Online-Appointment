package com.online_appoinment_web.dao;

import java.sql.SQLException;
import java.util.List;

import com.online_appoinment_web.model.Consultant;


public interface ConsultantManager {
	
	public boolean addConsultant(Consultant consultant) throws SQLException, ClassNotFoundException;
	public boolean editConsultant(Consultant consultant) throws SQLException, ClassNotFoundException;
	public boolean deleteConsultant(int consultant_id) throws SQLException, ClassNotFoundException;
	
	public Consultant fetchSingleConsultant(int consultant_id) throws SQLException, ClassNotFoundException;
	public List<Consultant> fetchAllConsultant() throws SQLException, ClassNotFoundException;

}
