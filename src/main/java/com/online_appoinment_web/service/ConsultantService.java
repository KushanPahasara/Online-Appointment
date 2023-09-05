package com.online_appoinment_web.service;

import java.sql.SQLException;
import java.util.List;

import com.online_appoinment_web.dao.ConsultantManager;
import com.online_appoinment_web.dao.ConsultantManagerImpl;
import com.online_appoinment_web.model.Consultant;


public class ConsultantService {
	
	
	private static ConsultantService consultantServiceObj;

	public ConsultantService() {
		
	}
	
	public synchronized static ConsultantService getConsultantService() {
		if(consultantServiceObj == null) {
			consultantServiceObj = new ConsultantService();
		}
		
		return consultantServiceObj;
	}
	
	private ConsultantManager getConsultantManager() {
		return new ConsultantManagerImpl();
	}
	
	public boolean addConsultant(Consultant consultant) throws ClassNotFoundException, SQLException {
		return getConsultantManager().addConsultant(consultant);
	}
	
	public boolean editConsultant(Consultant consultant) throws ClassNotFoundException, SQLException {
		return getConsultantManager().editConsultant(consultant);
	}
	
	public boolean deleteConsultant(int consultant_id) throws ClassNotFoundException, SQLException {
		return getConsultantManager().deleteConsultant(consultant_id);
	}
	
	public Consultant fetchSinglConsultant(int consultant_id) throws ClassNotFoundException, SQLException {
		return getConsultantManager().fetchSingleConsultant(consultant_id);
	}
	
	public List<Consultant> fetchAllConsultant() throws ClassNotFoundException, SQLException{
		return getConsultantManager().fetchAllConsultant();
	}

}
