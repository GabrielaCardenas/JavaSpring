<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>All Dorms</title>
	</head>
	
	<body>
		<h1>All Dorms</h1>
		<table border=1>
			<thead>
			
				<tr>
					<th>Name</th>
					<th>Action</th>
				</tr>
				
			</thead>
    		
    		<tbody>
        		
        		<c:forEach items="${dormList}" var="dorms">
        		<tr>
        		
        			<td><c:out value="${dorms.name}"/></td>
            		<td><a href="/dorms/${dorms.id}">View</a></td>
            		
        		</tr>
    			</c:forEach>
    		</tbody>
		
		</table>
		<a href="/dorms/create">Create Dorm</a>
		<a href="/students">Back</a>
		
	</body>

</html>