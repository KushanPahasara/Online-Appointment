package com.online_appoinment_web.model;

public class Consultant {
	
	private int consultant_id;
	private String consultant_name;
	private String consultant_email;
	private int consultant_age;
	private String gender;
	private String consultant_telephone;
	
	
	public Consultant() {
		
	}


	public Consultant(int consultant_id, String consultant_name, String consultant_email, int consultant_age,
			String gender, String consultant_telephone) {
		
		this.consultant_id = consultant_id;
		this.consultant_name = consultant_name;
		this.consultant_email = consultant_email;
		this.consultant_age = consultant_age;
		this.gender = gender;
		this.consultant_telephone = consultant_telephone;
	}


	public int getConsultant_id() {
		return consultant_id;
	}


	public void setConsultant_id(int consultant_id) {
		this.consultant_id = consultant_id;
	}


	public String getConsultant_name() {
		return consultant_name;
	}


	public void setConsultant_name(String consultant_name) {
		this.consultant_name = consultant_name;
	}


	public String getConsultant_email() {
		return consultant_email;
	}


	public void setConsultant_email(String consultant_email) {
		this.consultant_email = consultant_email;
	}


	public int getConsultant_age() {
		return consultant_age;
	}


	public void setConsultant_age(int consultant_age) {
		this.consultant_age = consultant_age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getConsultant_telephone() {
		return consultant_telephone;
	}


	public void setConsultant_telephone(String consultant_telephone) {
		this.consultant_telephone = consultant_telephone;
	}
	
	
	
	

}
