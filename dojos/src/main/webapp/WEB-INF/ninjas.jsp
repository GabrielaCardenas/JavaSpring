<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>All Ninjas</title>
	</head>

	<body>
		<div id="ninjas">
			<h1>Ninjas</h1>
    
    		<c:forEach begin="1" end="${totalPages}" var="index">
        		<a href="/pages/${index}">${index}</a>
    		</c:forEach>
    		
    		<table class="table" border=1>
        		
        		<thead>
        			<tr>
        				<th>Dojo Name</th>
            			<th>Ninja Name</th>
            		</tr>
        		</thead>
        		
        		<tbody>
            		
            		<c:forEach var="ninja" items="${ninjas.content}">                 
            		<tr>
            			<td><a href="/dojos/${ninja.dojo.id}"><c:out value="${ninja.dojo.name}"/></a></td>
                		<td><c:out value="${ninja.firstName}"/> <c:out value="${ninja.lastName}"/></td>
            		</tr>
            		</c:forEach>
        		
        		</tbody>
    		
    		</table>
    		<a href="/ninjas/new">New Ninja</a>
		</div>
	
	</body>

</html>