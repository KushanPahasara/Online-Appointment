package com.online_appoinment_web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.online_appoinment_web.model.Appoinment;
import com.online_appoinment_web.model.User;
import com.online_appoinment_web.service.AppoinmentService;



public class AppoinmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    String message = "";
	
	private AppoinmentService getAppoinmentService() {
		return AppoinmentService.getAppoinmentService();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String actionType= request.getParameter("actiontype");
		
		if(actionType.equals("single")) {
			fetchSingleAppoinment(request, response);
		}
		else if(actionType.equals("singleAdmin")) {
			fetchSingleAppoinmentAdmin(request, response);
		}
		else if(actionType.equals("admin")) {
			fetchAllAppoinment(request, response);
		}
		else if(actionType.equals("consultant")) {
			fetchAllAppoinmentConsultant(request, response);
		}
		else {
			fetchAllAppoinmentUser(request, response);
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 String actionType = request.getParameter("actiontype");
			
			if(actionType.equals("add")) {
				addAppoinment(request, response);
			}
			else if(actionType.equals("edit")){
				editAppoinment(request, response);
			}
			else if(actionType.equals("delete")) {
				deleteAppoinment(request, response);
			}
			else if(actionType.equals("addAdmin")) {
				addAppoinmentAdmin(request, response);
			}
			else if(actionType.equals("editAdmin")) {
				editAppoinmentAdmin(request, response);
			}
			else if(actionType.equals("adminDelete")) {
				deleteAppoinmentAdmin(request, response);
			}
			else if(actionType.equals("acccept")) {
				addStatus(request, response);
			}
			else if(actionType.equals("conDelete")) {
				deleteAppoinmentConsultant(request, response);
			}
			
	}
	
	private void addAppoinment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        
		
		Appoinment appoinment = new Appoinment();
		appoinment.setAp_note(request.getParameter("note"));
		appoinment.setAp_date(request.getParameter("date"));
		appoinment.setAp_time(request.getParameter("time"));
		appoinment.setCountry(request.getParameter("country"));
		appoinment.setUser_id(user.getUser_id());

				
		try {
			if(getAppoinmentService().addAppoinment(appoinment))
			{
				message = "The Appoinment has been successfully added!";
			}
			else {
				message = "Failed to add the Appoinment!";
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			message = "operation failed! " + e.getMessage();
		}
		
		request.setAttribute("feebackMessage", message);
		RequestDispatcher rd = request.getRequestDispatcher("appointments.jsp");
		rd.forward(request, response);
		
	}
	
	private void addAppoinmentAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
       
		
		Appoinment appoinment = new Appoinment();
		appoinment.setAp_note(request.getParameter("note"));
		appoinment.setAp_date(request.getParameter("date"));
		appoinment.setAp_time(request.getParameter("time"));
		appoinment.setConsultant_id(request.getParameter("consultant"));
		appoinment.setCountry(request.getParameter("country"));
		appoinment.setUser_id(user.getUser_id());

				
		try {
			if(getAppoinmentService().addAppoinmentAdmin(appoinment))
			{
				message = "The Appoinment has been successfully added!";
			}
			else {
				message = "Failed to add the Appoinment!";
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			message = "operation failed! " + e.getMessage();
		}
		
		request.setAttribute("feebackMessage", message);
		RequestDispatcher rd = request.getRequestDispatcher("admin-main.jsp");
		rd.forward(request, response);
		
	}
	
	private void editAppoinment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		clearMessage();
		
		HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
		 
		    Appoinment appoinment = new Appoinment();
		    appoinment.setAp_id(Integer.parseInt(request.getParameter("Id")));
			appoinment.setAp_note(request.getParameter("note"));
			appoinment.setAp_date(request.getParameter("date"));
			appoinment.setAp_time(request.getParameter("time"));
			appoinment.setCountry(request.getParameter("country"));
			appoinment.setUser_id(user.getUser_id());
			
			
			try {
				if(getAppoinmentService().editAppoinment(appoinment)) {
					message = "The Appoinmet has been successfully updated! Appoinment Code: " + appoinment.getAp_id();
					
				}
				else {
					message = "Failed to update the Appoinment! Appoinment Code: " + appoinment.getAp_id();
				}
			} 
			catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
			}
			
			request.setAttribute("feebackMessage", message);
			RequestDispatcher rd = request.getRequestDispatcher("update-appoinments.jsp");
			rd.forward(request, response);
		
		
		
	}
	
	private void editAppoinmentAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		clearMessage();
		
		 
		    Appoinment appoinment = new Appoinment();
		    appoinment.setAp_id(Integer.parseInt(request.getParameter("Id")));
			appoinment.setAp_note(request.getParameter("note"));
			appoinment.setAp_date(request.getParameter("date"));
			appoinment.setAp_time(request.getParameter("time"));
			appoinment.setConsultant_id(request.getParameter("consultant"));
			appoinment.setCountry(request.getParameter("country"));
			
			
			
			try {
				if(getAppoinmentService().editAppoinmentAdmin(appoinment)) {
					message = "The Appoinmet has been successfully updated! Appoinment Code: " + appoinment.getAp_id();
					
				}
				else {
					message = "Failed to update the Appoinment! Appoinment Code: " + appoinment.getAp_id();
				}
			} 
			catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
			}
			
			request.setAttribute("feebackMessage", message);
			RequestDispatcher rd = request.getRequestDispatcher("update-apAdmin.jsp");
			rd.forward(request, response);
		
		
		
	}
	
	private void deleteAppoinment(HttpServletRequest request, HttpServletResponse response) throws IOException
	{ 
		clearMessage();
		
		int apId = Integer.parseInt(request.getParameter("Id"));
		
		try {
			if(getAppoinmentService().deleteAppoinment(apId)) {
				message = "The Appoinment has been successfully deleted. AppoinmentCode: " + apId;
			}
			else {
				message = "Failed to delet the Appoinment! AppoinmentCode: " + apId;
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			message =e.getMessage();
		}
		
		
		HttpSession session = request.getSession();
		session.setAttribute("message", message);
		
		response.sendRedirect("appoinment?actiontype=all");
		
	}
	
	private void deleteAppoinmentAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		
		
		int apId = Integer.parseInt(request.getParameter("Id"));
		
		try {
			if(getAppoinmentService().deleteAppoinment(apId)) {
				message = "The Appoinment has been successfully deleted. AppoinmentCode: " + apId;
			}
			else {
				message = "Failed to delet the Appoinment! AppoinmentCode: " + apId;
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			message =e.getMessage();
		}
		
		
		HttpSession session = request.getSession();
		session.setAttribute("message", message);
		
		response.sendRedirect("appoinment?actiontype=admin");
		
		
	}
	
	private void deleteAppoinmentConsultant(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		
		
		int apId = Integer.parseInt(request.getParameter("Id"));
		
		try {
			if(getAppoinmentService().deleteAppoinment(apId)) {
				message = "The Appoinment has been successfully deleted. AppoinmentCode: " + apId;
			}
			else {
				message = "Failed to delet the Appoinment! AppoinmentCode: " + apId;
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			message =e.getMessage();
		}
		
		
		HttpSession session = request.getSession();
		session.setAttribute("message", message);
		
		response.sendRedirect("appoinment?actiontype=consultant");
		
		
	}
	
	private void fetchSingleAppoinment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
      int apId = Integer.parseInt(request.getParameter("apCode"));
		
		try {
			Appoinment appoinment = getAppoinmentService().fetchSinglAppoinment(apId);
			if(appoinment.getAp_id() > 0) {
				request.setAttribute("appoinment", appoinment);
			}
			else {
				message = "No record found!";
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("feebackMessage", message);
		RequestDispatcher rd = request.getRequestDispatcher("update-appoinments.jsp");
		rd.forward(request, response);
		
	}
	
	private void fetchAllAppoinment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		clearMessage();
			List<Appoinment> apList = new ArrayList<Appoinment>();
			try {
				apList = getAppoinmentService().fetchAllAppoinment();
			    if (!(apList.size() > 0)) {
			        message = "No records found!";
			    } 
			} 
			catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
			}
			
			request.setAttribute("appoinment", apList);
			request.setAttribute("feebackMessage", message);
			
			RequestDispatcher rd = request.getRequestDispatcher("admin-appoinments.jsp");
			rd.forward(request, response);
			
			
		
	}
	
	private void fetchAllAppoinmentUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		clearMessage();
		HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        int userId = user.getUser_id();
		
		
			List<Appoinment> apList = new ArrayList<Appoinment>();
			try {
				apList = getAppoinmentService().fetchAllAppoinmentUser(userId);
				
				if(!(apList.size() > 0)) {
					message = "No record found!";
				}
			} 
			catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
			}
			
			request.setAttribute("appoinment", apList);
			request.setAttribute("feebackMessage", message);
			
			RequestDispatcher rd = request.getRequestDispatcher("view-all-appointments.jsp");
			rd.forward(request, response);
			
			
		
	}
	private void fetchAllAppoinmentConsultant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		clearMessage();
		
		HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        String userName = user.getUser_name();
		
		
			List<Appoinment> apList = new ArrayList<Appoinment>();
			try {
				apList = getAppoinmentService().fetchAllAppoinmentConsultant(userName);
				
				if(!(apList.size() > 0)) {
					message = "No record found!";
				}
			} 
			catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
			}
			
			request.setAttribute("appoinment", apList);
			request.setAttribute("feebackMessage", message);
			
			RequestDispatcher rd = request.getRequestDispatcher("ConsultantAppointments.jsp");
			rd.forward(request, response);
			
			
		
	}
	
	private void fetchSingleAppoinmentAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		clearMessage();
		
      int apId = Integer.parseInt(request.getParameter("apCode"));
		
		try {
			Appoinment appoinment = getAppoinmentService().fetchSinglAppoinment(apId);
			System.out.println(appoinment);
			if(appoinment.getAp_id() > 0) {
				request.setAttribute("appoinment", appoinment);
			}
			else {
				message = "No record found!";
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("feebackMessage", message);
		RequestDispatcher rd = request.getRequestDispatcher("update-apAdmin.jsp");
		rd.forward(request, response);
		
	}
	
	   private void addStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
		   Appoinment appoinment = new Appoinment();
		    appoinment.setAp_id(Integer.parseInt(request.getParameter("Id")));
			appoinment.setStatus(Integer.parseInt(request.getParameter("apCode")));
			
			
			
			
			try {
				if(getAppoinmentService().addStatus(appoinment)) {
					message = "The Appoinmet has been successfully updated! Appoinment Code: " + appoinment.getAp_id();
					
				}
				else {
					message = "Failed to update the Appoinment! Appoinment Code: " + appoinment.getAp_id();
				}
			} 
			catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
			}
			
			String redirectURL = "appoinment?actiontype=consultant";
            response.sendRedirect(redirectURL);
			
//			RequestDispatcher rd = request.getRequestDispatcher("ConsultantAppointments.jsp");
//			rd.forward(request, response);
		
	}
	

	
	private void clearMessage() {
		message = "";
	}

}
