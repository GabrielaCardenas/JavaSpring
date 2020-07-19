<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert New Dorm</title>
	</head>
	
	<body> 
		<h1>New Dorm</h1>
		<form:form action="/dorms/create" method="post" modelAttribute="dorm">
    		<p>
        		<form:label path="name">Name:</form:label>
        		<form:errors path="name"/>
        		<form:input path="name"/>
    		</p>
    		
    		<input type="submit" value="Create"/>
		</form:form>    
		<a href="/dorms">Back</a>
		
	</body>
	
</html>