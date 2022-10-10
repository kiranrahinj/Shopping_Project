
<%@page import="com.Factory"%>
<%@page import="Dao.categoryDao"%>
<%@page import="tables.User"%>
<%@page import="java.util.*"%>
<%@page import="tables.Category"%>
<%
User us = (User)session.getAttribute("us");

if (us == null) {
	session.setAttribute("msg", "U Have Not Login!! please login");
	response.sendRedirect("login.jsp");
	return;
} else {
	if (us.getuType().equals("normal")) {
		session.setAttribute("msg", "U Have Not Login!! please login");
		response.sendRedirect("login.jsp");
		return;
	}
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Panel</title>
<%@include file="components/bootstrap/bootstrap.jsp"%>
</head>
<body>
	<%@ include file="components/navbar/navbar.jsp"%>
	<div class="container">

		<!-- First Row -->
		<div class="row mt-4 ">

			<div class="col-md-4 " style="margin-bottom: 10px;" id="kiran">
				<div class="card ">
					<div class="card-body" id="kk">
						<center>
							<img class="img-fluid  rounded-circle border"
								style="max-width: 100px;" alt="user.png"
								src="components/img/team.png">
						</center>
						<h6 class="text-center mt-2">200</h6>
						<h6 class="text-center text-uppercase">Users</h6>
					</div>
				</div>

			</div>

			<div class="col-md-4" style="margin-bottom: 10px;" id="kiran">
				<div class="card">
					<div class="card-body" id="kk">
						<center>
							<img class="img-fluid rounded-circle border"
								style="max-width: 100px;" alt="cat.png"
								src="components/img/menu.png">
						</center>
						<h6 class="text-center mt-2">200</h6>
						<h6 class="text-center text-uppercase">Categories</h6>
					</div>
				</div>

			</div>

			<div class="col-md-4" style="margin-bottom: 10px;" id="kiran">
				<div class="card ">
					<div class="card-body" id="kk">
						<center>
							<img class="img-fluid rounded-circle border"
								style="max-width: 100px;" alt="pro.png"
								src="components/img/product.png">
						</center>
						<h6 class="text-center mt-2">200</h6>
						<h6 class="text-center text-uppercase">Products</h6>
					</div>
				</div>

			</div>

		</div>

		<!-- Second Row -->
		<div class="row mt-4 ">


			<div class="col-md-6 " id="kiran" style="margin-bottom: 10px;">
				<div class="card" data-bs-toggle="modal"
					data-bs-target="#exampleModal">
					<div class="card-body " id="kk">
						<center>
							<img class="img-fluid  rounded-circle border mt-2"
								style="max-width: 100px;" alt="user.png"
								src="components/img/plus.png">
						</center>

						<h6 class="text-center text-uppercase mt-4">Add Categories</h6>
					</div>
				</div>

			</div>



			<div class="col-md-6 " id="kiran" style="margin-bottom: 10px;">
				<div class="card " data-bs-toggle="modal"
					data-bs-target="#productModal">
					<div class="card-body" id="kk">
						<center>
							<img class="img-fluid  rounded-circle border mt-2"
								style="max-width: 100px;" alt="user.png"
								src="components/img/box.png">
						</center>

						<h6 class="text-center text-uppercase mt-4">Add Products</h6>
					</div>
				</div>

			</div>



		</div>


	</div>


	<!-- Modal 1-->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header bg-primary text-center">
					<h5 class="modal-title text-white " id="exampleModalLabel">Add
						Categories Here !!!</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>

				<div class="modal-body">
					<form action="CategoryData" method="post">
                                            <%@include file="components/message/msg.jsp" %>
						<div class="form-group">

							<label for="exampleInputEmail1" class="form-label">Product
								Name</label></br> <input name="name" id="exampleInputEmail1"
								style="width: 100%;">

						</div>

						<div class="form-group">

							<label for="exampleInputEmail1" class="form-label">Description</label></br>
							<textarea name="desc" id="exampleInputEmail1"
								style="width: 100%; height: 200px;"></textarea>

						</div>
						<div class="form-group container text-center">
							<button type="submit" class="btn btn-success"
								data-bs-dismiss="modal">Submit</button>
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>

						</div>

					</form>

				</div>

			</div>
		</div>
	</div>


	<!-- Modal 2-->
	<div class="modal fade" id="productModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header bg-primary ">
					<h5 class="modal-title text-white" id="exampleModalLabel">Add
						Products !!!</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="productsData" method="post" enctype="multipart/form-data">

						<div class="form-group">

							<label for="exampleInputEmail1" class="form-label">Product_Name
							</label></br> <input name="pname" id="exampleInputEmail1" type="text"
								style="width: 100%;">

						</div>

						<div class="form-group">

							<label for="exampleInputEmail1" class="form-label">Product
								Description</label></br>
							<textarea name="pdesc" id="exampleInputEmail1" type="text"
								style="width: 100%;"></textarea>

						</div>
						<div class="form-group">

							<label for="exampleInputEmail1" class="form-label">Product
								Price</label></br> <input name="price" type="number" id="exampleInputEmail1"
								style="width: 100%;">

						</div>
						
						<div class="form-group mb-2">

							<label for="exampleInputEmail1" class="form-label">Category</label></br> 
								<select style="width:100%;" name="cat">
<!--                                                                <option>Select</option>-->
                                                                <%
                                                                    categoryDao cd=new categoryDao(Factory.getFactory());
                                                                    List<Category>l=cd.getCategory(); 
                                                                    
                                                                    for(Category c:l)
                                                                    {
                                                                    %>
                                                                  
                                                                    <option  value="<%=c.getcId()%>"><%=c.getcName()%></option>
								 <%
                                                                     }
                                                                %>
								</select>

						</div>

						<div class="form-group">

							<label for="exampleInputEmail1" class="form-label">Product
								Pic</label></br> <input name="pic" id="exampleInputEmail1" type="file" 
								style="width: 100%;">

						</div>

						<div class="form-group container text-center mt-4">
							<input type="submit" class="btn btn-success"
								value="Submit"/>
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>

						</div>

					</form>


				</div>

			</div>
		</div>
	</div>



</body>
</html>












