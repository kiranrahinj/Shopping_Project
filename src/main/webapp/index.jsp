<%@page import="Dao.categoryDao"%>
<%@page import="Dao.productDao"%>
<%@page import="java.util.*"%>
<%@page import="tables.Category"%>
<%@page import="tables.Products"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="com.Factory"%>
<%@page import="com.helper"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Home Page</title>
        <%@include file="components/bootstrap/bootstrap.jsp" %>
    </head>
    <body>
        <%@ include file="components/navbar/navbar.jsp" %>
        <div class="row  container-fluid">

            <%                categoryDao cd = new categoryDao(Factory.getFactory());
                List<Category> cl = cd.getCategory();

                productDao pd = new productDao(Factory.getFactory());
                List<Products> pl = pd.getProducts();

            %>

            <!--Categories-->
            <div class="col-md-2 ms-2 mt-3">
                <ul class="list-group">
                    <li class="list-group-item active" aria-current="true">Products</li>
                        <%                    for (Category s : cl) {
                        %>



                    <li class="list-group-item"><%=s.getcName()%></li>
                        <%
                            }
                        %>
                </ul>
            </div>



            <!--<div>-->
            <div class="col-md-8 " style="width: 81.66666667%;">
                <div class="row " >

                    <div class="row row-cols-1 row-cols-md-4 g-2 "   >

                        <!--traversing products-->
                        <%
                            for (Products s : pl) {
                        %>

                        <div class="col">
                            <div class="card" >
                                <div class="container text-center mt-3"> <img style="max-height:100px;max-width: 100%;width: auto;" src="components/img/products/<%=s.getPhoto()%>" class="card-img-top" alt="pic.img"></div>
                                <div class="card-body">
                                    <center><h5 class="card-title"><%=s.getpName()%></h5>
                                    <p class="card-text"><%=helper.getDesc(s.getpDesc())%> </p></center>
                                </div>
                                <div class="card-footer my-auto">
                                    <button type="button" class="btn btn-primary text-white">Add to cart</button>
                                    <button  type="button" class="btn btn-success text-white"> &#8377;<%=s.getPrice()%></button>
                                </div>

                            </div>
                        </div>
                        <%
                            }
                        %>  

                    </div>


                </div>

            </div>
    </body>
</html>