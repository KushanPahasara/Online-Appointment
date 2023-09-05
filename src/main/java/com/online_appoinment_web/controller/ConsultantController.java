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

import com.online_appoinment_web.model.Consultant;
import com.online_appoinment_web.service.ConsultantService;


/**
 * Servlet implementation class ConsultantController
 */
public class ConsultantController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    String message = "";
	
	private ConsultantService getConsultantService() {
		return ConsultantService.getConsultantService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String actionType= request.getParameter("actiontype");
			
			if(actionType.equals("single")) {
				fetchSingleConsultant(request, response);
			}
			else {
				fetchAllConsultant(request, response);
			}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionType = request.getParameter("actiontype");
		
		if(actionType.equals("add")) {
			addConsultant(request, response);
		}
		else if(actionType.equals("edit")){
			editConsultant(request, response);
		}
		else if(actionType.equals("delete")) {
			deleteConsultant(request, response);
		}
	}
	
	private void addConsultant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		Consultant consultant = new Consultant();
		consultant.setConsultant_name(request.getParameter("name"));
		consultant.setConsultant_age(Integer.parseInt(request.getParameter("age")));
		consultant.setGender(request.getParameter("gender"));
		consultant.setConsultant_telephone(request.getParameter("telephone"));
		consultant.setConsultant_email(request.getParameter("email"));
		
		try {
			if(getConsultantService().addConsultant(consultant))
			{
				message = "The product has been successfully added!";
			}
			else {
				message = "Failed to add the product!";
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			message = "operation failed! " + e.getMessage();
		}
		
		request.setAttribute("feebackMessage", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-user.jsp");
		rd.forward(request, response);
		
	}
	
	private void editConsultant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 clearMessage();
			
			
		   Consultant consultant = new Consultant();
		    consultant.setConsultant_id(Integer.parseInt(request.getParameter("Id")));
			consultant.setConsultant_name(request.getParameter("name"));
			consultant.setConsultant_age(Integer.parseInt(request.getParameter("age")));
			consultant.setGender(request.getParameter("gender"));
			consultant.setConsultant_telephone(request.getParameter("telephone"));
			consultant.setConsultant_email(request.getParameter("email"));
					
			
			try {
				if(getConsultantService().editConsultant(consultant)) {
					message = "The product has been successfully updated! Product Code: " + consultant.getConsultant_id();
				}
				else {
					message = "Failed to update the product! Product Code: " + consultant.getConsultant_id();
				}
			} 
			catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
			}
			
			request.setAttribute("feebackMessage", message);
			RequestDispatcher rd = request.getRequestDispatcher("search-and-update.jsp");
			rd.forward(request, response);
		
		
		
	}
	
	private void deleteConsultant(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		clearMessage();
		int conId = Integer.parseInt(request.getParameter("Id"));
		
		try {
			if(getConsultantService().deleteConsultant(conId)) {
				message = "The product has been successfully deleted. ProductCode: " + conId;
			}
			else {
				message = "Failed to delet the product! ProductCode: " + conId;
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
	
	private void fetchSingleConsultant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		int conId = Integer.parseInt(request.getParameter("Id"));
		
		try {
			Consultant consultant = getConsultantService().fetchSinglConsultant(conId);
			if(consultant.getConsultant_id() > 0) {
				request.setAttribute("consultant", consultant);
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
	
	private void fetchAllConsultant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 clearMessage();
			
			List<Consultant> consultantList = new ArrayList<Consultant>();
			try {
				consultantList = getConsultantService().fetchAllConsultant();
				
				if(!(consultantList.size() > 0)) {
					message = "No record found!";
				}
			} 
			catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
			}
			
			request.setAttribute("consultantList", consultantList);
			request.setAttribute("feebackMessage", message);
			
			RequestDispatcher rd = request.getRequestDispatcher("view-all-and-delete.jsp");
			rd.forward(request, response);
			
			
		
	}
	
	private void clearMessage() {
		message = "";
	}

}
