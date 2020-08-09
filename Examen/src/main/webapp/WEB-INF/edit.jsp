<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
		<meta charset="ISO-8859-1">
		<title>Buy Lunch</title>
	</head>
	
	<body>
		
		<div class="container p-3 my-3 border" style="margin-left:30%; width:30%">
			<h1>Package: <c:out value="${paquete.name}" /></h1>
			<form:form method="POST" action="/editCost" modelAttribute="paquetes" style="display:inline-block; width:30%">
				<p>
		            	<form:label path="cost">Cost:</form:label>
		            	<form:input type="number" path="cost"/>
		        </p>
		        <form:input type="text" path="id" value="${paquete.id}" hidden="hidden"/>
		        <form:input type="text" path="name" value="${paquete.name}" hidden="hidden"/>
		        <form:input type="text" path="avaliable" value="${paquete.avaliable}" hidden="hidden"/>
		        <form:input type="text" path="user.id" value="${paquete.user.id}" hidden="hidden"/>
				<input type="submit" value="Edit" class="btn btn-outline-info"/>
			</form:form>
			
			<c:if test="${paquete.customers.isEmpty()}">
			
			<form:form method="POST" action="/delete" modelAttribute="paquetes" style="display:inline-block">
				<form:input type="text" path="id" value="${paquete.id}" hidden="hidden"/>
				<input type="submit" value="Delete" class="btn btn-outline-danger"/>
			</form:form>
			
			</c:if>
			
		</div>
		
	</body>

</html>