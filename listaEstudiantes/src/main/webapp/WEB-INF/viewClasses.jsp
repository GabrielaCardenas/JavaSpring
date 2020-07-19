<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>All Classes</title>
	</head>

	<body>
		<table border=1>
			<thead>
			
				<tr>
					<th>Name</th>
				</tr>
				
			</thead>
    		
    		<tbody>
        		
        		<c:forEach items="${classesList}" var="class">
        		<tr>
        		
        			<td><a href="/classes/${class.id}"><c:out value="${class.name}"/></a></td>
            		
        		</tr>
    			</c:forEach>
    		</tbody>
		
		</table>
		<a href="/classes/new">Add New Class</a>
		<a href="/students">Back</a>
	</body>

</html>