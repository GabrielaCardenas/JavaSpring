<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
		<meta charset="ISO-8859-1">
		<title>Subscriptions</title>
	</head>

	<body>
		
		<a href="/logout">Logout</a>
		<h1>Admin Dashboard</h1>
		
		<div class="container pt-3" style="display:inline-block; width:40%">
			<h1>Customers</h1>
			<table border=1>
				<thead>
				
					<tr>
						<th>Name</th>
						<th>Due Amount</th>
						<th>Due Date</th>
						<th>Package Type</th>
					</tr>
					
				</thead>
	    		
	    		<tbody>
	        		
	        		<c:forEach items="${customerList}" var="customer">
	        		<tr>
	        		
	        			<td><c:out value="${customer.name}"/></td>
	            		<td>$<c:out value="${customer.paquetes.cost}"/></td>
	            		<td><c:out value="${customer.dueDate}"/></td>
	            		<td><c:out value="${customer.paquetes.name}"/></td>
	            		
	        		</tr>
	    			</c:forEach>
	    		</tbody>
			
			</table>
		</div>
		
		<div class="container pt-3" style="display:inline-block; ; width:40%">
			<h1>Package</h1>
			<table border=1>
				<thead>
				
					<tr>
						<th>Package Name</th>
						<th>Package Cost</th>
						<th>Avaliable</th>
						<th>Action</th>
					</tr>
					
				</thead>
	    		
	    		<tbody>
	        		
	        		<c:forEach items="${paqueteList}" var="paquete">
	        		<tr>
	        		
	        			<td><c:out value="${paquete.name}"/></td>
	            		<td>$<c:out value="${paquete.cost}"/></td>
	            		<td><c:out value="${paquete.avaliable}"/></td>
	            		<td><a href="/packages/${paquete.id}/edit">Edit</a></td>
	            		
	        		</tr>
	    			</c:forEach>
	    		</tbody>
			
			</table>
		</div>
		
		<div class="container p-3 my-3 border" style="margin-left:40%; width:40%">
			<h1>Create Package</h1>
	    	<p><form:errors path="user.*"/></p>
	    	<form:form method="POST" action="/newPackage" modelAttribute="paquete">
	        	<p>
	            	<form:label path="name">Package Name:</form:label>
	            	<form:input type="text" path="name"/>
	        	</p>
	        	<p>
	            	<form:label path="cost">Cost:</form:label>
	            	<form:input type="text" path="cost"/>
	        	</p>
	        	<form:input type="text" value="Available" path="avaliable" hidden="hidden"></form:input>
	        	<form:input type="text" value="1" path="user.id" hidden="hidden"></form:input>
	        	<input type="submit" value="Create new package" class="btn btn-outline-success"/>
	    	</form:form>
	    </div>
		
	</body>

</html>