<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.m.admin.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DeleteProduct</title>
<link rel="stylesheet" href="css/OnlineStoreStyles.css">
</head>
<body>

	<div class="container">
		<%
		AdminBean ab = (AdminBean) session.getAttribute("abean");
		String msg = (String) request.getAttribute("msg");
		out.println("<h2>Page Belongs to Admin : " + ab.getfName() + "</h2><br>");
		out.println("<h2>" + msg + "</h2><br>");
		%>

		<a href="product.html">Add Product</a> <a href="view1">View All
			Products</a> <a href="logout">Logout</a>
	</div>
</body>
</html>