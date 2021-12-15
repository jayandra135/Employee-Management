<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #800080">
			<div>
				<a href="#" class="navbar-brand"> Employee Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employee</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit Employee
            		</c:if>
						<c:if test="${user == null}">
            			Add New Employee
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Employee Name</label> <input type="text"
						value="<c:out value='${user.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Email</label> <input type="text"
						value="<c:out value='${user.email}' />" class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Country</label> <input type="text"
						value="<c:out value='${user.country}' />" class="form-control"
						name="country">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Employee PhoneNo</label> <input type="text"
						value="<c:out value='${user.phoneno}' />" class="form-control"
						name="phoneno">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Employee Job</label> <input type="text"
						value="<c:out value='${user.job}' />" class="form-control"
						name="job">
				</fieldset>

					
				<%-- <fieldset class="form-group">
					<label>Employee HireDate</label> 
					<fmt:formatDate pattern = "yyyy-MM-dd" value = "${user.hiredate}" /></p>
				</fieldset> --%>
					<%-- <input type="date" 
					value="<c:out value='${user.hiredate}' />" class="form-control" 
					name="hiredate"> --%>
					
				<fieldset class="form-group">
					<label>Employee Salary</label> <input type="text"
						value="<c:out value='${user.salary}' />" class="form-control"
						name="salary">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>