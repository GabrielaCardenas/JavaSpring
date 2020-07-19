<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Students</title>
	</head>

	<body>
		
		<h1><c:out value="${dorm.name}"/></h1>
		
		<form:form action="/dorms/${dorm.id}/add" method="post" modelAttribute="student">
			
			<p>
				
				<form:label path="id">Students:</form:label>
				<form:errors path="id"/>
			        <form:select path="id">
						<c:forEach items="${studentList}" var="student">
							<form:option value="${student.id}"><c:out value="${student.firstName} ${student.lastName}"/></form:option>
						</c:forEach>
					</form:select>
				
    		</p>
    		
    		<input type="submit" value="Add"/>
    		
    	</form:form>
		
		<table border=1>
			<thead>
			
				<tr>
					<th>Name</th>
					<th>Action</th>
				</tr>
				
			</thead>
    		
    		<tbody>
        		
        		<c:forEach items="${studentDorm}" var="student">
        		<tr>
        		
        			<td><c:out value="${student.firstName} ${student.lastName}"/></td>
            		<td>
            			<form:form action="/dorms/${dorm.id}/remove" method="post" modelAttribute="student">
							<form:errors path="id"/>
			        		<form:input hidden="hidden" path="id" value="${student.id}"/>
    						<input type="submit" value="Remove"/>
    					</form:form>
            		</td>
            		
        		</tr>
    			</c:forEach>
    		</tbody>
		
		</table>
		
		<a href="/dorms">Back</a>
		
	</body>

</html>