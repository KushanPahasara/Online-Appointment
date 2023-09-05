<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>KFC Sri Lanka onAir</title>
		<!-- Latest compiled and minified CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<!-- Latest compiled JavaScript -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<div class="container">
			<ul class="nav nav-tabs">
			  <li class="nav-item">
			    <a class="nav-link" aria-current="page" href="add-user.jsp">Add Product</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="search-and-update.jsp">Search & Update the Product</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link active" href="#">View All & Delete Specific</a>
			  </li>
			</ul>			
			<br/>
			<h2>View All & Delete Specific Product</h2>
			<p style='color:magenta'>${message}</p>			
			<br/>		
			<table class="table table-striped">
				<thead>
					<tr>
						<th>User Id</th>
						<th>User Name</th>
						<th>User age</th>
						<th>User gender</th>
						<th>User Email</th>
						<th>User Telephone</th>
					</tr>
				</thead>			
				<tbody>
					<tag:forEach var="consultant" items="${consultantList}">
						<tr>
							<td>${consultant.consultant_id}</td>
							<td>${consultant.consultant_name}</td>
							<td>${consultant.consultant_age}</td>
							<td>${consultant.gender}</td>
							<td>${consultant.consultant_email}</td>
							<td>${consultant.consultant_telephone}</td>
							
							<td>
								<form action="consultant" method="post">								
									<input type="hidden" id="Id" name="Id" value="${consultant.consultant_id}">
									<input type="hidden" name="actiontype" value="delete">
									<button type="submit" class="btn btn-danger">Delete the Product</button>
								</form>							
							</td>
						</tr>
					</tag:forEach>
				</tbody>
			</table>	
		</div>
	</body>
</html>