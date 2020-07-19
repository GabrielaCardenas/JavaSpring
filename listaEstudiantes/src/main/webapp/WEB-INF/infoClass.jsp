<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Class</title>
	</head>

	<body>
		<div>
			<h1><c:out value="${clase.name}"/></h1><br>
			<h2> Student taking this class</h2>
			<br><br>
			
			<table border=1>
		    	<thead>
		        	<tr>
		            	<th>Name</th>
		        	</tr>
		    	</thead>
		   
		   		<tbody>
					<c:forEach items="${studentsList}" var="student">
						<tr>
							<td>${student.firstName} ${student.lastName}</td>
						</tr>
					</c:forEach>
				</tbody>			
			</table>
			<a href="/classes">Back</a>	
		</div>
	</body>

</html>