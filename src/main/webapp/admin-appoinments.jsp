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
                    <h4 class="card-title">List of Appointments </h4>
                    
                    
                    <p class="card-description"> <code></code>
                    </p>
                    <table class="table table-bordered">
                      <thead>
                      <tr>
                        <th> Appointment ID</th>
                        <th> Note </th>
                        <th> User  </th>
                        <th> Consultant </th>
                        <th id="dateHeader">
                        Date
                       <span id="dateSortIcon" class="fa fa-sort"></span>
                       </th>
                        <th> Time </th>
                        <th id="countryHeader">
                        Country
                       <span id="countrySortIcon" class="fa fa-sort"></span>
                      </th>
                        <th> Update </th>
                        <th> Delete </th>
                      </tr>
                      </thead>
                      <tbody>
                      
                      	<tag:forEach var="appoinment" items="${appoinment}">
						<tr>
							<td>${appoinment.ap_id}</td>
							<td>${appoinment.ap_note}</td>
							<td>${appoinment.user_name}</td>
							<td>
							<c:choose>
                            <c:when test="${appoinment.consultant_id == null}">
                            Pending
                            </c:when>
                            <c:otherwise>
                            ${appoinment.consultant_id}
                            </c:otherwise>
                            </c:choose>
                              </td>
							<td>${appoinment.ap_date}</td>
							<td>${appoinment.ap_time}</td>
							<td>${appoinment.country}</td>
							
							<td> <form action="appoinment">			
				             <input type="hidden" id="Id" name="apCode" value="${appoinment.ap_id}">
				             <input type="hidden" name="actiontype" value="singleAdmin"/>
				             <br/>
				             <button type="submit" class="btn btn-primary">Update</button>			
			                 </form></td>
							<td> <form action="appoinment" method="post">								
									<input type="hidden" id="Id" name="Id" value="${appoinment.ap_id}">
									<input type="hidden" name="actiontype" value="adminDelete">
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
 <script>
    document.addEventListener("DOMContentLoaded", function() {
        const dateHeader = document.getElementById("dateHeader");
        const dateSortIcon = document.getElementById("dateSortIcon");
        const countryHeader = document.getElementById("countryHeader");
        const countrySortIcon = document.getElementById("countrySortIcon");
        let ascendingDateOrder = true;
        let ascendingCountryOrder = true;

        const sortRows = (header, icon, ascendingOrder, cellIndex) => {
            const rows = document.querySelectorAll("tbody tr");
            const sortedRows = Array.from(rows).sort((a, b) => {
                const cellA = a.cells[cellIndex].textContent;
                const cellB = b.cells[cellIndex].textContent;
                return ascendingOrder ? cellA.localeCompare(cellB) : cellB.localeCompare(cellA);
            });

            // Toggle the sorting order for the clicked header
            if (header === dateHeader) {
                ascendingDateOrder = !ascendingDateOrder;
                dateSortIcon.className = ascendingDateOrder ? "fa fa-sort-asc" : "fa fa-sort-desc";
            } else if (header === countryHeader) {
                ascendingCountryOrder = !ascendingCountryOrder;
                countrySortIcon.className = ascendingCountryOrder ? "fa fa-sort-asc" : "fa fa-sort-desc";
            }

            // Remove existing rows from the table
            rows.forEach(row => row.remove());

            // Append sorted rows to the table
            const tbody = document.querySelector("tbody");
            sortedRows.forEach(row => {
                tbody.appendChild(row);
            });
        };

        dateHeader.addEventListener("click", () => sortRows(dateHeader, dateSortIcon, ascendingDateOrder, 4));
        countryHeader.addEventListener("click", () => sortRows(countryHeader, countrySortIcon, ascendingCountryOrder, 6));
    });
</script>
</body>
</html>
