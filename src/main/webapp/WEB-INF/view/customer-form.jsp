<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Adding the link for jsp form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Customer form</title>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/form.css">
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/customer-style.css">
</head>
<body>
	<div id="Name">
		<center><h2>CRM - Customer Relationship Manager</h2></center>
		<div class="form">
			<form:form action="saveCustomer" modelAttribute="customer" method="post">
				<form:hidden path="id"/>
				<label>First name: </label><form:input path="firstaname"/>
				<br><br>
				
				<label>Last name: </label><form:input path="lastName"/>
				<br><br>
				
				<label>Email: </label><form:input path="email" class="email"/>
				<br><br>
				
				<button>Save</button>
			
			</form:form>
			<a href="list">Back To List</a>
		</div>
		
	</div>
</body>
</html>