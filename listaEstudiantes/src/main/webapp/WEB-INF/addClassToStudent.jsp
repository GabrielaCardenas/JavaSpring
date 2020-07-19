<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add Class to Student</title>
	</head>

	<body>
		<div>
			<div>
				
				<p>${estudiante.firstName} ${estudiante.lastName}</p>
				<form:form action="/classStudent/add" method="post" modelAttribute="classStudent">
					<form:input type="hidden" path="student.id" value="${estudiante.id}"></form:input>
					<div>
						<form:select path="clase.id">
							<c:forEach items="${classes}" var="clas">
								<form:option value="${clas.id}">${clas.name}</form:option>
							</c:forEach>
						</form:select>
		 			</div>
					<button class="button" >Add</button>
				</form:form>
			
			</div>
			
			<div>
			
				<table border=1>
		    		<thead>
		        		<tr>
		            		<th>Class Name</th>
		            		<th>Action</th>
		        		</tr>
		    		</thead>
		   
		   			<tbody>
						<c:forEach items="${studentClasses}" var="class">
							<tr>
								<td>${class.name}</td>
								<td>
									<form:form action="/${estudiante.id}/drop" method="post" modelAttribute="classStudent">
										<form:input hidden="hidden" path="student.id" value="${estudiante.id}"/>
										<form:errors path="clase.id"/>
			        					<form:input hidden="hidden" path="clase.id" value="${class.id}"/>
    									<input type="submit" value="Drop"/>
    								</form:form>
								</td>
							</tr>
						</c:forEach>
					</tbody>			
				</table>
			
			</div>
			
			<a href="/students">Back</a>
			
		</div>
	</body>

</html>