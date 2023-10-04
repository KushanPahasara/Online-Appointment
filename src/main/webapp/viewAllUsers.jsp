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
                    <h4 class="card-title">List of All Users</h4>
                     
                    <p class="card-description"> <code></code>
                    </p>
                    <table class="table table-bordered">
                      <thead>
                      <tr>
                        <th> User ID</th>
                        <th> User Name </th>
                        <th> User Password</th>
                        <th> User Email </th>
                        <th> User Role</th>
                        <th> User Telephone Number</th>
                        <th> Update </th>
                        <th> Delete </th>
                      </tr>
                      </thead>
                      <tbody>
                      	<tag:forEach var="user" items="${userList}">
						<tr>
							<td>${user.user_id}</td>
							<td>${user.user_name}</td>
							<td>${user.user_password}</td>
							<td>${user.user_email}</td>
							
							<td>
                            <c:choose>
                                <c:when test="${user.user_role == '1'}">
                                    User
                                </c:when>
                                <c:when test="${user.user_role == '2'}">
                                    Admin
                                </c:when>
                                <c:when test="${user.user_role == '3'}">
                                    Consultant
                                </c:when>
                                
                            </c:choose>
                        </td>
							                        
							
							<td>${user.tel_number}</td>
							
							
							<td> <form action="register">			
				             <input type="hidden" id="Id" name="userCode" value="${user.user_id}">
				             <input type="hidden" name="actiontype" value="update"/>
				             <br/>
				             <button type="submit" class="btn btn-primary">Update</button>			
			                 </form></td>
							<td> <form action="register" method="post">								
									<input type="hidden" id="Id" name="Id" value="${user.user_id}">
									<input type="hidden" name="actiontype" value="delete">
									<button type="submit" class="btn btn-danger">Delete</button>
						     </form></td>
									
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