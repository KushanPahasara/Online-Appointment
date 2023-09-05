<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
			    <a class="nav-link active" href="#">Search & Update the Product</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="consultant?actiontype=all">View All & Delete Specific</a>
			  </li>
			</ul>			
			<br/>
			<h2>Search & update the product</h2>
			<p style='color:magenta'>${feebackMessage}</p>
			<br/>
			
			<form action="consultant">			
				<label for="productCode">Enter Product Code:</label>
				<input class="form-control" type="number" id="Id" name="Id" placeholder="Type the product code"/>
				<input type="hidden" name="actiontype" value="single"/>
				<br/>
				<button type="submit" class="btn btn-info">Search</button>			
			</form>
			<hr/>
			<form action="consultant" method="post">	
			<label for="productCodeUpdate">Product Code:</label>
			<input class="form-control" type="number" id="productCodeUpdate" name="Id" readonly="readonly" value="${consultant.consultant_id}"/>		
		  <div class="input-group mb-3">
          <input type="text" class="form-control" placeholder="Name" name="name" id="name" value="${consultant.getConsultant_name()}">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
        
         <div class="input-group mb-3">
          <input type="text" class="form-control" placeholder="text" name="age" id="age" value="${consultant.getConsultant_age()}">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        
        <div class="input-group mb-3">
          <input type="text" class="form-control" placeholder="Email" name="email" id="email" value="${consultant.getGender()}">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="text" class="form-control" placeholder="User Role" name="telephone" id="telephone" value="${consultant.getConsultant_telephone()}">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="text" class="form-control" placeholder="Telephone" name="email" id="email" value="${consultant.getConsultant_email()}">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
        <input type="hidden" name="actiontype" value="edit"/>
		<br/>
		<br/>
				<button type="submit" class="btn btn-warning">Update the Product</button>			
			</form>
					
		</div>	
	</body>
</html>