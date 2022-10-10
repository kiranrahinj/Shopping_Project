
<%@page import="tables.User"%>
<%
 User us1 = (User)session.getAttribute("us");
%>



<nav class="navbar navbar-expand-lg navbar-dark"
	style="margin-top: -10px;">
	<div class="container-fluid custom_nav ">
		<div class="navbar container navbar-dark">
			<a class="navbar-brand" href="index.jsp">My Cart</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Categories </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul></li>

				</ul>
				<%
				if (us1 == null) {
				%>
				<ul class="navbar-nav mr-auto mb-2 ">
					<li><a class="me-3 text-white" href="register.jsp">Register</a></li>
					<li><a class="text-white" href="login.jsp">Login</a></li>
				</ul>

				<%
				} 
				else 
				{
				%>
				<ul class="navbar-nav mr-auto mb-2">
					<li><a class="me-3 text-white"><%=us1.getuName()%></a></li>
					<li><a class="text-white"href="logout.jsp" id="log">Logout</a></li>
				</ul>
				<%
				}
				%>



			</div>
		</div>
	</div>
</nav>