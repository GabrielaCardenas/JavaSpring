<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ninja Gold</title>
	<link rel="stylesheet" type="text/css" href="css/Game2Style.css">
</head>
<body>
	<label>Your Gold: </label>
	<h3><c:out value="${gold}"/></h3>
	
	<form action="/Farm" method="post">
		<h2>Farm</h2>
		<p>(earns 10-20 gold)</p>
		<button name="farm">Find Gold</button>
	</form>
	
	<form action="/Cave" method="post">
		<h2>Cave</h2>
		<p>(earns 5-10 gold)</p>
		<button name="cave">Find Gold</button>
	</form>
	
	<form action="/House" method="post">
		<h2>House</h2>
		<p>(earns 2-5 gold)</p>
		<button name="house">Find Gold</button>
	</form>
	
	<form action="/Casino" method="post">
		<h2>Casino</h2>
		<p>(earns/takes 0-50 gold)</p>
		<button name="casino">Find Gold</button>
	</form>
	
	<form action="/Spa" method="post">
		<h2>Spa</h2>
		<p>(takes 5-20 gold)</p>
		<button name="spa">Find Gold</button>
	</form>
	
	<h1>Activities:</h1>
	<textarea cols="100" rows="10" style="overflow:scroll;">
	<c:forEach var="listact" items="${listActivities}">
         <c:out value = "${listact}"/>
     </c:forEach>
     </textarea>
     
     <form action="/Reset" method="post">
     	<button name="reset">Reset</button>
     </form>

</body>
</html>