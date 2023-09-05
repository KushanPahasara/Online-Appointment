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

    <%@include file="structure/sidebar.jsp" %>

    <div class="main-panel">
      <div class="content-wrapper">
        <div class="row purchace-popup">
          <div class="col-12 stretch-card grid-margin">
            <div class="card card-secondary">
              <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Add New Appointments</h4>
                    <p>${feebackMessage}</p>
                    <p class="card-description"> </p>
                    <form class="forms-sample" action="appoinment" method="post">
                     <div class="form-group">
                        <label for="Appointment_Description">Appointment Description</label>
                        <textarea class="form-control" id="note" name="note" rows="4"></textarea>
                      </div>
                      <div class="form-group">
                        <label for="Date">Date</label>
                        <input type="date" class="form-control" id="date" name="date" placeholder="Date">
                      </div>
                      <div class="form-group">
                        <label for="Time">Appointment Time</label>
                        <input type="time" class="form-control" id="time" name="time" placeholder="Time">
                      </div>
                      <div class="form-group">
                        <label for="Country">Country</label>
                        <input type="text" class="form-control" id="country" name="country" placeholder="Country">
                      </div>
                       
                   
                       <input type="hidden" name="actiontype" value="add"/>
                      <button type="submit" class="btn btn-primary mr-2">Submit</button>
                      <button class="btn btn-light">Cancel</button>
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
