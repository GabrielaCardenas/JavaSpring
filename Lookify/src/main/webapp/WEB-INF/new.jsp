<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert song</title>
	</head>
	
	<body> 
		<a href="/dashboard">Dashboard</a>
		<form:form action="/dashboard" method="post" modelAttribute="song">
    		<p>
        		<form:label path="name">Title</form:label>
        		<form:errors path="name"/>
        		<form:input path="name"/>
    		</p>
    		
    		<p>
        		<form:label path="artist">Artist</form:label>
        		<form:errors path="artist"/>
        		<form:input path="artist"/>
    		</p>
    		
    		<p>
        		<form:label path="ranking">Ranking (1-10)</form:label>
        		<form:errors path="ranking"/>
        		<form:input type="number" min="1" max="10" step="1" path="ranking"/>
    		</p>  
    		
    		<input type="submit" value="Add Song"/>
		</form:form>    
	</body>
	
</html>