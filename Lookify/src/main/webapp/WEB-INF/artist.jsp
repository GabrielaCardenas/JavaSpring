<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Search</title>
	</head>
	
	<body>
		<a href="/dashboard">Dashboard</a>
		
		<h1>Songs by artist: <c:out value="${artist}"/></h1>
		
		<form action="/search" method="post">
			<input type="text" name="artist" required value="${artist}">
			<button type="submit">New Search</button>
		</form>
		
		<table>
    		<thead>
        		<tr>
            		<th>Name</th>
            		<th>Artist</th>
            		<th>Ranking</th>
            		<th>Actions</th>
        		</tr>
    		</thead>
    		
    		<tbody>
        		<c:forEach items="${songs}" var="song">
        		<tr>
            		<td><a href="/songs/${song.id}"><c:out value="${song.name}"/></a></td>
            		<td><c:out value="${song.artist}"/></td>
            		<td><c:out value="${song.ranking}"/></td>
            		<td>
            			<form action="/songs/${song.id}" method="post">
		    				<input type="hidden" name="_method" value="delete">
		    				<input type="submit" value="Delete">
						</form>
            		</td>
        		</tr>
        		</c:forEach>
    		</tbody>
		</table>
	</body>

</html>