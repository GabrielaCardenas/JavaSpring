<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Top Ten</title>
	</head>
	
	<body>
		<h1>Top Ten Songs:</h1>
		<a href="/dashboard">Dashboard</a>
		
		<table>

    		<tbody>
        		<c:forEach items="${songs}" var="song">
        		<tr>
        		
        			<td><c:out value="${song.ranking}"/></td>
            		<td><a href="/songs/${song.id}"><c:out value="${song.name}"/></a></td>
            		<td><c:out value="${song.artist}"/></td>
        		</tr>
        		</c:forEach>
    		</tbody>
		</table>
	</body>

</html>