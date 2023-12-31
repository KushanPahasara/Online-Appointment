package com.online_appoinment_web.model;

import java.util.ArrayList;
import java.util.List;

public class Appoinment {
	
	private int ap_id;
	private String ap_note;
	private int user_id;
	private String user_name;
	private String consultant_id;
	private String ap_date;
	private String ap_time;
	private String country;
	private int status;
	private String user_phone;
	private List<String> consultants = new ArrayList<>();
	
	
	
	public Appoinment() {
		// TODO Auto-generated constructor stub
		
	}

	public Appoinment(int ap_id, String ap_note, int user_id, String consultant_id, String ap_date, String ap_time, String country, String user_name, int status, List<String> consultants, String user_phone) {
		
		this.ap_id = ap_id;
		this.ap_note = ap_note;
		this.user_id = user_id;
		this.user_name = user_name;
		this.consultant_id = consultant_id;
		this.ap_date = ap_date;
		this.ap_time = ap_time;
		this.country = country;
		this.status = status;
		this.user_phone = user_phone;
		this.consultants = consultants;
		
	}

	public int getAp_id() {
		return ap_id;
	}

	public void setAp_id(int ap_id) {
		this.ap_id = ap_id;
	}

	public String getAp_note() {
		return ap_note;
	}

	public void setAp_note(String ap_note) {
		this.ap_note = ap_note;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getConsultant_id() {
		return consultant_id;
	}

	public void setConsultant_id(String consultant_id) {
		this.consultant_id = consultant_id;
	}

	public String getAp_date() {
		return ap_date;
	}

	public void setAp_date(String ap_date) {
		this.ap_date = ap_date;
	}
	

	public String getAp_time() {
		return ap_time;
	}

	public void setAp_time(String ap_time) {
		this.ap_time = ap_time;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<String> getConsultants() {
		return consultants;
	}

	public void setConsultants(List<String> consultants) {
		this.consultants = consultants;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	
	
	
	
	
	

}
