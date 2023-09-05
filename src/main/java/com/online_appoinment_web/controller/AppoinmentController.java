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
import com.online_appoinment_web.service.UserService;


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
	}
	
	private void addAppoinment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        System.out.println("test"+ user.getUser_id());
		
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
	
	private void editAppoinment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
		 
		    Appoinment appoinment = new Appoinment();
			appoinment.setAp_note(request.getParameter("note"));
			appoinment.setAp_date(request.getParameter("date"));
			appoinment.setAp_time(request.getParameter("time"));
			appoinment.setCountry(request.getParameter("country"));
			appoinment.setConsultant_id(Integer.parseInt(request.getParameter("consultent")));
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
			RequestDispatcher rd = request.getRequestDispatcher("search-and-update.jsp");
			rd.forward(request, response);
		
		
		
	}
	
	private void deleteAppoinment(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		clearMessage();
		int apId = Integer.parseInt(request.getParameter("APCode"));
		
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
		
		//request.setAttribute("feebackMessage", message);
		//RequestDispatcher rd = request.getRequestDispatcher("view-all-and-delete-specific.jsp");
		//rd.forward(request, response);
		
		HttpSession session = request.getSession();
		session.setAttribute("message", message);
		
		response.sendRedirect("register?actiontype=all");
		
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
		RequestDispatcher rd = request.getRequestDispatcher("search-and-update.jsp");
		rd.forward(request, response);
		
	}
	
	private void fetchAllAppoinment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		    
			List<Appoinment> apList = new ArrayList<Appoinment>();
			try {
				apList = getAppoinmentService().fetchAllAppoinment();
				
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
	
	private void fetchAllAppoinmentUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
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
	
	private void clearMessage() {
		message = "";
	}

}
