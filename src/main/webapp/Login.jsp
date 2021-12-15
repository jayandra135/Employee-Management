<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body style='background-color:#ffc48a;'>

<!-- <div align ="center">
		<h1>Admin Login Form </h1>
		<form action ="login" method="post">
		
			<table>
			
			<tr><td>Admin Name: </td><td><input type="text" name="username"></td></tr>
			<tr><td>Password: </td><td><input type="password" name="password"></td></tr>
			
			<tr><td></td><td><input type="submit" value="Submit"></td></tr>
			</table>
		</form>
</div> -->

<nav class="navbar navbar-expand-lg navbar-light bg-info">
<a class="navbar-brand" href="#">Employee Management</a>
   <a class="nav-link text-white" href="Welcome.jsp" >Home</a>
   <a class="nav-link text-white" href="Login.jsp">Admin-Login</a>
   
</nav>
<div class="row">
	<div class="container">
	<div align="center">
		<div class="card mt-5" style='background-color: #bfdf9f;'>
			<div class="card-body">
			<h1 align="center" class="mb-5">Admin Login Form </h1>
				<form action ="login" method="post">
					 <fieldset class="form-group">
						<label>Admin username</label> 
						<input type="text" name="username">
					</fieldset>
					<fieldset class="form-group">
						<label >Admin Password</label>
					 	<input type="password" name="password">
					</fieldset> 
					<input type="submit" class="btn btn-primary" value="submit">
				</form>
			
			</div>
		
		</div>
	
	</div>
		
	
	</div>

</div>
</body>
</html>