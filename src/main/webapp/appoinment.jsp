<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add Appoinment</title>
		
		<!-- Latest compiled and minified CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<!-- Latest compiled JavaScript -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>		
	</head>
	
	<body>		
		<div class="container">
			<ul class="nav nav-tabs">
			  <li class="nav-item">
			    <a class="nav-link active" aria-current="page" href="#">Add Appoinment</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="search-and-update.jsp">Search & Update the Product</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="register?actiontype=all">View All & Delete Specific</a>
			  </li>
			</ul>
			
			<br/>
			<h2>Add Appoinment</h2>
			<p>${feebackMessage}</p>
			<br/>
			<form action="appoinment" method="post">
				<label for="userName">Note:</label>
				<input class="form-control" type="text" name="note" id="note"/>
				<br/>
				<label for="Date">Date:</label>
				<input class="form-control" type="date" name="date" id="date"/>
				<br/>
			    <label for="country">Country:</label>
				<input class="form-control" type="text" name="country" id="country"/>
				<br/>
				<label for="consultent">consultent:</label>
				<input class="form-control" type="text" name="consultent" id="consultent"/>
				<br/>
				<label for="userID">User ID:</label>
				<input class="form-control" type="text" name="user" id="user"/>
				<br/>
				<input type="hidden" name="actiontype" value="add"/>
			    <button class="btn btn-primary" type="submit">Add the Appoinment</button>
			</form>
			
		</div>
	</body>
</html>