<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<%@include file="components/bootstrap/bootstrap.jsp"%>
</head>
<body>
<%@ include file="components/navbar/navbar.jsp"%>

	<div class="container-fluid">
	
	<div class="row">
		<div class="col-md-4 offset-md-4">
			<div class="card">
				<div class="card-body">
				<%@ include file="components/message/msg.jsp" %>
				<h4 class="text-center">Sign Up Here!!</h4>
					<form action="register" method="post">
					
						<label for="exampleInputEmail1" class="form-label">Name</label> 
						<input name="nm" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"> 
						
						<label for="exampleInputEmail1" class="form-label">Email address</label>
						<input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"> 
						
						<label for="exampleInputEmail1" class="form-label">Password</label> 
						<input name="pass" type="password" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"> 
						
						<label for="exampleInputEmail1" class="form-label">Phone Number</label> 
						<input name="pn" type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"> 
						
						<label for="exampleInputEmail1" class="form-label">Address</label></br>
						<textarea name="add" id="exampleInputEmail1" style="width: 100%; height: 100px;"></textarea>

					
					<div class="text-center">
						<input class="btn btn-outline-success" type="submit" value="Register">
						<button type="reset" class="btn btn-outline-warning ">Reset</button>
						
					</div>
					
				</form>	
				</div>
			</div>
		</div>
	</div>
	
	
	</div>

</body>
</html>