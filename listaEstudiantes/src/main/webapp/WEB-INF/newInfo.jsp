<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert New Contact</title>
	</head>
	
	<body> 
		<h1>New Contact</h1>
		
		<form:form action="/contact" method="post" modelAttribute="contact">
		
			<p>
				
				<form:label path="students.id">Student</form:label>
				<form:errors path="students.id"/>
			        <form:select path="students.id">
						<c:forEach items="${studentList}" var="student">
							<form:option value="${student.id}"><c:out value="${student.firstName} ${student.lastName}"/></form:option>
						</c:forEach>
				</form:select>
				
    		</p>
    		
    		<p>
        		<form:label path="address">Address</form:label>
        		<form:errors path="address"/>
        		<form:input type="text" path="address"/>
    		</p>
    		
    		<p>
        		<form:label path="city">City</form:label>
        		<form:errors path="city"/>
			    <form:input type="text" path="city"/>
    		</p>
    		
    		<p>
        		<form:label path="state">State</form:label>
        		<form:errors path="state"/>
			    <form:input type="text" path="state"/>
    		</p>
    		
    		<input type="submit" value="Create"/>
		</form:form>    
	</body>
	
</html>