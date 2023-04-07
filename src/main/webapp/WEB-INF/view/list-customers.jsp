<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>List of Customer</title>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/customer-style.css" />
</head>
<body>
	<div id="Name">
		<center><h2>CRM - Customer Relationship Manager</h2></center>
		
		<input type="button" value="Add Customer" class="btn" onclick="window.location.href='CustomerForm'; return false;">
		<table>
			<thead>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th> 
			</thead>
			<tbody>
				<c:forEach var = "item" items="${customer}"> 
					<!-- Construct a update link -->
					<c:url var="updateLink" value="updateForm"> 
						<c:param name="customerId" value="${item.id}"/>
					</c:url>
					<!-- Construct a update link -->
					<c:url var="deleteLink" value="/customer/deleteCustomer"> 
						<c:param name="customerId" value="${item.id}"/>
					</c:url>
					<tr>
						<td>${item.firstaname}</td>
						<td>${item.lastName}</td>
						<td>${item.email}</td>
						<td><a href="${updateLink}">Update | </a>
						<a href="${deleteLink}"
						onclick="if(!(confirm('Are you sure you want to delete the user?'))) return false"> Delete </a>
						</td>
					</tr>
	      		</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>