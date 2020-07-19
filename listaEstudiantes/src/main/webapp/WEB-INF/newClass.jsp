<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New Class</title>
	</head>

	<body>
		<h1>Create New Class</h1>
		<form:form action="/classes/new" method="post" modelAttribute="classeObject">
	    	
	    	<p>
	    		<form:label path="name">Name</form:label>
	        	<form:errors path="name"/>
	        	<form:input path="name"/>
	    	</p>
	   
	    	<input type="submit" value="Create"/>
		</form:form>    
		<a href="/classes">Back</a>
	</body>

</html>