<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
		<meta charset="ISO-8859-1">
		<title>Subscriptions</title>
	</head>
	
	<body>
		<a href="/logout">Logout</a>
		<div class="container p-3 my-3 border" style="margin-left:30%; width:40%">
			<h1>Welcome! <c:out value="${user.name}" /></h1>
			<p>Your current Package: <c:out value="${customer.paquete.name}" /></p>
			<p>Package Cost: $<c:out value="${customer.paquete.cost}" /></p>
			
			<form:form action="/changePaquete" method="post" modelAttribute="paquetes">
				<form:label path="id">Switch Package:</form:label>
				<form:errors path="id"/>
				<form:select path="id" class="form-control" style="width:40%">
					<c:forEach items="${paqueteList}" var="paquete">
						<form:option value="${paquete.id}"><c:out value="${paquete.name}"/></form:option>
					</c:forEach>
				</form:select>
				<input type="text" name="customerId" value="${customer.id}" hidden="hidden"/>
				<input type="text" name="userId" value="${user.id}" hidden="hidden"/>
				<input type="submit" value="Switch" class="btn btn-outline-info"/>
			</form:form>
			
		</div>
	</body>

</html>