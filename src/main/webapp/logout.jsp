<%

session.removeAttribute("us");
session.removeAttribute("msg");
response.sendRedirect("login.jsp");

%>