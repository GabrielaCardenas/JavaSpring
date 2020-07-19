<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert New Student</title>
	</head>
	
	<body> 
		<h1>New Student</h1>
		<form:form action="/student" method="post" modelAttribute="student">
    		<p>
        		<form:label path="firstName">First Name</form:label>
        		<form:errors path="firstName"/>
        		<form:input path="firstName"/>
    		</p>
    		
    		<p>
        		<form:label path="lastName">Last Name</form:label>
        		<form:errors path="lastName"/>
        		<form:input path="lastName"/>
    		</p>
    		
    		<p>
        		<form:label path="age">Age</form:label>
        		<form:errors path="age"/>
        		<form:input type="number" path="age"/>
    		</p> 
    		
    		<input type="submit" value="Create"/>
		</form:form> 
		<a href="/students">Back</a>
		 
	</body>
	
</html>