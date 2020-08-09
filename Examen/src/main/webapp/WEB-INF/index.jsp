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
		
		<div class="container p-3 my-3 border" style="display:inline-block; width:40%; margin-left:10%">
			<h1>Register!</h1>
	    	<p><form:errors path="user.*"/></p>
	    	<form:form method="POST" action="/registration" modelAttribute="user">
	        	<p>
	            	<form:label path="name">Name:</form:label>
	            	<form:input type="text" path="name"/>
	        	</p>
	        	<p>
	            	<form:label path="email">Email:</form:label>
	            	<form:input type="email" path="email"/>
	        	</p>
	        	<p>
	            	<form:label path="password">Password:</form:label>
	            	<form:password path="password"/>
	        	</p>
	        	<p>
	            	<form:label path="passwordConfirmation">Password Confirmation:</form:label>
	            	<form:password path="passwordConfirmation"/>
	        	</p>
	        	<input type="submit" value="Register!" class="btn btn-outline-success"/>
	    	</form:form>
	    </div>
	    
	    <div class="container p-3 my-3 border" style="display:inline-block; width:30%; margin:50px">
	    	<h1>Login</h1>
    		<p><c:out value="${error}" /></p>
    		<form method="post" action="/login">
        		<p>
            		<label for="email">Email</label>
            		<input type="text" id="email" name="email"/>
        		</p>
        		<p>
            		<label for="password">Password</label>
            		<input type="password" id="password" name="password"/>
        		</p>
        		<input type="submit" value="Login!" class="btn btn-outline-info"/>
    		</form>
	    </div>
		
	</body>

</html>