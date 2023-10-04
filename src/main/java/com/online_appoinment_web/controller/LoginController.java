package com.online_appoinment_web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.online_appoinment_web.dao.*;
import com.online_appoinment_web.model.Login;
import com.online_appoinment_web.model.User;
import com.online_appoinment_web.service.LoginService;
import com.online_appoinment_web.service.UserService;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 String message = "";
		
	private LoginService getLoginService() {
			return LoginService.getLoginService();
		}


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		 response.sendRedirect("loginPage.jsp");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String actionType= request.getParameter("actiontype");
		 
		if(actionType.equals("login")) {
			fetchSingleUser(request, response);
		}
		
			
	    }
	
	private void fetchSingleUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		
		try {
			User user = getLoginService().fetchSingleUser(name);
			System.out.println(user.getUser_name());
			System.out.println(user.getUser_email());
			if(name.equals(user.getUser_email())&&(password.equals(user.getUser_password()))){
				
				if( 1 == (user.getUser_role())){
					HttpSession session = request.getSession();

					session.setAttribute("User", user);
					request.setAttribute("User", user);
					session.setAttribute("userName", user.getUser_name());
					request.setAttribute("userName", user.getUser_name());
					session.setAttribute("userEmail", user.getUser_email());
					request.setAttribute("userEmail", user.getUser_email());
					response.sendRedirect("appointments.jsp");
				}else if( 2 == (user.getUser_role())){
					HttpSession session = request.getSession();

					session.setAttribute("User", user);
					request.setAttribute("User", user);
					session.setAttribute("userName", user.getUser_name());
					request.setAttribute("userName", user.getUser_name());
					session.setAttribute("userEmail", user.getUser_email());
					request.setAttribute("userEmail", user.getUser_email());
					response.sendRedirect("admin-main.jsp");
				}else if( 3 == (user.getUser_role())){
					HttpSession session = request.getSession();

					session.setAttribute("User", user);
					request.setAttribute("User", user);
					session.setAttribute("userName", user.getUser_name());
					request.setAttribute("userName", user.getUser_name());
					session.setAttribute("userEmail", user.getUser_email());
					request.setAttribute("userEmail", user.getUser_email());
					response.sendRedirect("appoinment?actiontype=consultant");
				}
				
				
			}else {
				message = "Sorry Invalid Login";
				request.setAttribute("feebackMessage", message);
				RequestDispatcher rd = request.getRequestDispatcher("newlogin.jsp");
				rd.forward(request, response);
			}
				
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			   message=e.getMessage();
		}
		
		
		
		
	}
	
	
}


