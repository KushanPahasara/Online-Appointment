<%@page import=" java.util.ArrayList" %>
<%@ page import="com.online_appoinment_web.model.User" %>
<%@page import=" java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@page import="java.util.*"%>
<% 
 //In case, if User session is not set, redirect to Login page.
 String username = (String) request.getSession().getAttribute("User");
 out.println("Username in session: " + username);
if (request.getSession(false).getAttribute("User") == null) {
	/* String username = (String) request.getSession().getAttribute("User"); */
    out.println("Username in session: " + username);
    %>
    <jsp:forward page="loginPage.jsp"></jsp:forward>
    <%
} 
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add User</title>
		
		<!-- Latest compiled and minified CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<!-- Latest compiled JavaScript -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>		
	</head>
	
	<body>		
		<div class="container">
			<ul class="nav nav-tabs">
			  <li class="nav-item">
			    <a class="nav-link active" aria-current="page" href="#">Add User</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="search-and-update.jsp">Search & Update the Product</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="register?actiontype=all">View All & Delete Specific</a>
			  </li>
			</ul>
			
			<br/>
			<h2>Register User</h2>
			<p>${feebackMessage}</p>
			<br/>
			<form action="consultant" method="post">
				<label for="userName">User Name:</label>
				<input class="form-control" type="text" name="name" id="name"/>
				<br/>
			    <label for="age">age</label>
			    <input class="form-control" type="number" id="age" name="age">
			    <br/>
			    <label for="userEmail">User Email:</label>
				<input class="form-control" type="email" name="email" id="email"/>
				<br/>
				<label for="userRole">gender:</label>
				<input class="form-control" type="text" name="gender" id="gender"/>
				<br/>
				<label for="telNumber">Telephone Number:</label>
				<input class="form-control" type="text" name="telephone" id="telephone"/>
				<br/>
			    <input type="hidden" name="actiontype" value="add"/>
			    <button class="btn btn-primary" type="submit">Add the Product</button>
			</form>
			
		</div>
	</body>
</html>