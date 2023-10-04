<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>  <%@page import=" java.util.ArrayList" %>
<%@ page import="com.online_appoinment_web.model.User" %>
<%@page import=" java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@page import="java.util.*"%>
<% 
 //In case, if User session is not set, redirect to Login page.

if (request.getSession(false).getAttribute("User") == null) {
	
    %>
    <jsp:forward page="newlogin.jsp"></jsp:forward>
    <%
} 
%>  
<!DOCTYPE html>
<html lang="en">
<%@include file="structure/header.jsp" %>
<body>
<div class="container-scroller">

  <%@include file="structure/navbar.jsp" %>

  <div class="container-fluid page-body-wrapper">

    <%@include file="structure/admin-sidebar.jsp" %>

    <div class="main-panel">
      <div class="content-wrapper">
        <div class="row purchace-popup">
          <div class="col-12 stretch-card grid-margin">
            <div class="card card-secondary">
              <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Update User</h4>
                    <p>${feebackMessage}</p>
                    <p class="card-description"> </p>
                    <form class="forms-sample" action="register" method="post">
                     <div class="form-group">
              
                      <input class="form-control" type="hidden" id="productCodeUpdate" name="Id" readonly="readonly" value="${user.user_id}"/>
                        <label for="Name">Name</label>
                        <input type="text" class="form-control" id="name" name="userName" placeholder="Name" value="${user.user_name}">
                      </div>
                      <div class="form-group">
                        <label for="Password">Password</label>
                        <input type="text" class="form-control" id="userPassword" name="userPassword" placeholder=userPassword value="${user.user_password}">
                      </div>
                      <div class="form-group">
                        <label for="Email">Email</label>
                        <input type="text" class="form-control" id="userEmail" name="userEmail" placeholder="UserEmail" value="${user.user_email}">
                      </div>
                      <div class="form-group">
                        <label for="Telephone">Telephone</label>
                        <input type="text" class="form-control" id="telNumber" name="telNumber" placeholder="Telephone" value="${user.tel_number}">
                      </div>
                      <div class="form-group">
                        <label for="role">Role</label>
                        <input type="text" class="form-control" id="role" name="role" placeholder="Role" value="${user.user_role}">
                      </div>
                       
                       
                        <input type="hidden" name="actiontype" value="updateUser"/>
                      <button type="submit" class="btn btn-primary mr-2">Submit</button>
                      <button type="reset" class="btn btn-danger">Reset</button>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
    </div>
    <%@include file="structure/footer.jsp" %>
  </div>
</div>
</div>
<%@include file="structure/footerLinks.jsp" %>
</body>
</html>

