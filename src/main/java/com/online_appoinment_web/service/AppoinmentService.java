package com.online_appoinment_web.service;

import java.sql.SQLException;
import java.util.List;

import com.online_appoinment_web.dao.AppoinmentManager;
import com.online_appoinment_web.dao.AppoinmentManagerImpl;
import com.online_appoinment_web.model.Appoinment;


public class AppoinmentService {
	
	
	private static AppoinmentService appoinmentServiceObj;

	public AppoinmentService() {
		// TODO Auto-generated constructor stub
	}
	
	
	public synchronized static AppoinmentService getAppoinmentService() {
		if(appoinmentServiceObj == null) {
			appoinmentServiceObj = new AppoinmentService();
		}
		
		return appoinmentServiceObj;
	}
	
	private AppoinmentManager getAppoinmentManager() {
		return new AppoinmentManagerImpl();
	}
	
	public boolean addAppoinment(Appoinment appoinment) throws ClassNotFoundException, SQLException {
		return getAppoinmentManager().addAppoinment(appoinment);
	}
	
	public boolean editAppoinment(Appoinment appoinment) throws ClassNotFoundException, SQLException {
		return getAppoinmentManager().editAppoinment(appoinment);
	}
	
	public boolean deleteAppoinment(int ap_id) throws ClassNotFoundException, SQLException {
		return getAppoinmentManager().deleteAppoinment(ap_id);
	}
	
	public Appoinment fetchSinglAppoinment(int ap_id) throws ClassNotFoundException, SQLException {
		return getAppoinmentManager().fetchSingleAppoinment(ap_id);
	}
	
	public List<Appoinment> fetchAllAppoinment() throws ClassNotFoundException, SQLException{
		return getAppoinmentManager().fetchAllAppoinment();
	}
	
	public List<Appoinment> fetchAllAppoinmentUser(int user_id) throws ClassNotFoundException, SQLException{
		return getAppoinmentManager().fetchAllAppoinmentUser(user_id);
	}
	
	public boolean addAppoinmentAdmin(Appoinment appoinment) throws ClassNotFoundException, SQLException {
		return getAppoinmentManager().addAppoinmentAdmin(appoinment);
	}
	
	public boolean editAppoinmentAdmin(Appoinment appoinment) throws ClassNotFoundException, SQLException {
		return getAppoinmentManager().editAppoinmentAdmin(appoinment);
	}

}
