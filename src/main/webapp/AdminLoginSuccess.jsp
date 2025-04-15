<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.m.admin.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminLoginSuccess</title>
<link rel="stylesheet" href="css/OnlineStoreStyles.css">
</head>
<body>
	<div class="container">
		<%
		AdminBean ab = (AdminBean) session.getAttribute("abean");
		out.println("<h2>Welcome Admin : " + ab.getfName() + "</h2><br>");
		%>

		<a href="product.html">Add Product</a> 
		<a href="view1">View All Products</a> 
		<a href="logout">Logout</a>
	</div>
</body>
</html>