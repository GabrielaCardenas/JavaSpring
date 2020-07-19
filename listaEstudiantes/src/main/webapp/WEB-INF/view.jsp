<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Students</title>
	</head>

	<body>
		
		<h1>All Students</h1>
		<table border=1>
			<thead>
			
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>Address</th>
					<th>City</th>
					<th>State</th>
				</tr>
				
			</thead>
    		
    		<tbody>
        		
        		<tr>
        		
        			<td>
        			<c:forEach items="${studentList}" var="student">
        				<a href="/students/${student.id}"><c:out value="${student.firstName} ${student.lastName}"/></a><br>
        			</c:forEach>
        			</td>
        			
            		<td>
            		<c:forEach items="${studentList}" var="student">
            			<c:out value="${student.age}"/><br>
            		</c:forEach>
            		</td>
            		
            		<td>
            		<c:forEach items="${contactList}" var="contact">
            			<c:out value="${contact.address}"/><br>
            		</c:forEach>
            		</td>
            		
            		<td>
            		<c:forEach items="${contactList}" var="contact">
            			<c:out value="${contact.city}"/><br>
            		</c:forEach>
            		</td>
            		
            		<td>
            		<c:forEach items="${contactList}" var="contact">
            			<c:out value="${contact.state}"/><br>
            		</c:forEach>
            		</td>
            		
        		</tr>
    		
    		</tbody>
		
		</table>
		
		<a href="/students/new">Add Student</a>
		<a href="/dorms">Bedrooms</a>
		<a href="/classes">Classes</a>
		
	</body>

</html>