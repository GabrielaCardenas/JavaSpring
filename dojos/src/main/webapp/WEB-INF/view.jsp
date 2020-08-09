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
		
		<h1><c:out value="${dojo.name}"/></h1>
		<table border=1>
			<thead>
			
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
				
			</thead>
    		
    		<tbody>
        		
        		<c:forEach items="${ninjaList}" var="ninja">
        		<tr>
        		
        			<td><c:out value="${ninja.firstName}"/></td>
            		<td><c:out value="${ninja.lastName}"/></td>
            		<td><c:out value="${ninja.age}"/></td>
            		
        		</tr>
    			</c:forEach>
    		</tbody>
		
		</table>
		<a href="/pages/1">Back</a><br>
		<a href="/dojos/new">New Dojo</a>
		
	</body>

</html>