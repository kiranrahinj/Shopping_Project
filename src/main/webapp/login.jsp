<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<%@include file="components/bootstrap/bootstrap.jsp"%>
</head>
<body>
	<%@ include file="components/navbar/navbar.jsp"%>

	<div class="row">
		<div class="col-md-4 offset-md-4">
			<div class="card">
				<div class="card-body">
				<%@include file="components/message/msg.jsp" %>
				
				<h4 class="text-center">Login Here!!</h4>
					<form action="login" method="post">
						<label for="exampleInputEmail1" class="form-label">Email address</label>
						<input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"> 
						
						<label for="exampleInputEmail1" class="form-label">Password</label> 
						<input name="pass" type="password" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"> 
						

					
					<div class="text-center mt-3">
						<button class="btn btn-primary" type="submit">Login</button>
					</div>
				</form>	
				</div>
			</div>
		</div>
	</div>


</body>
</html>