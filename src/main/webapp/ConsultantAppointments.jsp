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

    <%@include file="structure/consultant-sidebar.jsp" %>

    <div class="main-panel">
      <div class="content-wrapper">
        <div class="row purchace-popup">
          <div class="col-12 stretch-card grid-margin">
            <div class="card card-secondary">
              <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">List Your of Appointments</h4> 
                    <p class="card-description"> <code></code>
                    </p>
                    <table class="table table-bordered">
                      <thead>
                      <tr>
                        <th> Appointment ID</th>
                        <th> Note </th>
                        <th> User  </th>
                        <th> Date </th>
                        <th> Time </th>
                        <th> Country </th>
                        <th> Update </th>
                        
                      </tr>
                      </thead>
                      <tbody>
                      	<tag:forEach var="appoinment" items="${appoinment}">
						<tr>
							<td>${appoinment.ap_id}</td>
							<td>${appoinment.ap_note}</td>
							<td>${appoinment.user_id}</td>
							<td>${appoinment.ap_date}</td>
							<td>${appoinment.ap_time}</td>
							<td>${appoinment.country}</td>
							
							 <td>
						        <c:choose>
                                <c:when test="${appoinment.status == 0}">
                                <form action="appoinment" method="post">
                                <input type="hidden" id="Id" name="Id" value="${appoinment.ap_id}">			
				                <input type="hidden" id="Id" name="apCode" value="1">
				                <input type="hidden" name="actiontype" value="acccept"/>
				                <br/>
				                <button type="submit" class="btn btn-primary">accept</button>			
			                   </form>
                              
                                 </c:when>
                                <c:otherwise>
                                
				                <button type="submit" class="btn btn-danger">accepted</button>			
			      
                               </c:otherwise>
                              </c:choose>
						    </td>
								
						</tr>
					</tag:forEach>
                     
                      </tbody>
                    </table>
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
