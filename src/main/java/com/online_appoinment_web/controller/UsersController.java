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


import com.online_appoinment_web.model.User;
import com.online_appoinment_web.service.UserService;



/**
 * Servlet implementation class UsersController
 */
public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
     String message = "";
	
	private UserService getUserService() {
		return UserService.getUserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String actionType= request.getParameter("actiontype");
		
		if(actionType.equals("single")) {
			fetchSingleUser(request, response);
		}
		else {
			fetchAllUsers(request, response);
		}
       
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionType = request.getParameter("actiontype");
		
		if(actionType.equals("add")) {
			addUser(request, response);
		}
		else if(actionType.equals("edit")){
			editUser(request, response);
		}
		else if(actionType.equals("delete")) {
			deleteUser(request, response);
		}
		
	}
	
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		User user = new User();
		user.setUser_name(request.getParameter("userName"));
		user.setUser_password(request.getParameter("userPassword"));
		user.setUser_email(request.getParameter("userEmail"));
		user.setUser_role(Integer.parseInt(request.getParameter("role")));
		user.setTel_number(Integer.parseInt(request.getParameter("telNumber")));
				
	
		try {
			if(getUserService().addUser(user))
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
		RequestDispatcher rd = request.getRequestDispatcher("register-new.jsp");
		rd.forward(request, response);
		
	}
	
	private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 clearMessage();
			
			
			User user = new User();
			user.setUser_id(Integer.parseInt(request.getParameter("productcode")));
			user.setUser_name(request.getParameter("userName"));
			user.setUser_password(request.getParameter("userPassword"));
			user.setUser_email(request.getParameter("userEmail"));
			user.setUser_role(Integer.parseInt(request.getParameter("role")));
			user.setTel_number(Integer.parseInt(request.getParameter("telNumber")));
					
			
			try {
				if(getUserService().editUser(user)) {
					message = "The product has been successfully updated! Product Code: " + user.getUser_id();
				}
				else {
					message = "Failed to update the product! Product Code: " + user.getUser_id();
				}
			} 
			catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
			}
			
			request.setAttribute("feebackMessage", message);
			RequestDispatcher rd = request.getRequestDispatcher("search-and-update.jsp");
			rd.forward(request, response);
		
		
		
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		clearMessage();
		int userId = Integer.parseInt(request.getParameter("productCode"));
		
		try {
			if(getUserService().deleteUser(userId)) {
				message = "The product has been successfully deleted. ProductCode: " + userId;
			}
			else {
				message = "Failed to delet the product! ProductCode: " + userId;
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
	
	private void fetchSingleUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
      int userId = Integer.parseInt(request.getParameter("productcode"));
		
		try {
			User user = getUserService().fetchSinglUser(userId);
			if(user.getUser_id() > 0) {
				request.setAttribute("user", user);
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
	
	private void fetchAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 clearMessage();
			
			List<User> userList = new ArrayList<User>();
			try {
				userList = getUserService().fetchAllUsers();
				
				if(!(userList.size() > 0)) {
					message = "No record found!";
				}
			} 
			catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
			}
			
			request.setAttribute("userList", userList);
			request.setAttribute("feebackMessage", message);
			
			RequestDispatcher rd = request.getRequestDispatcher("view-all-and-delete.jsp");
			rd.forward(request, response);
			
			
		
	}
	
	private void clearMessage() {
		message = "";
	}

}
