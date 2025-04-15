<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.m.user.UserBean"%>
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
		UserBean ub = (UserBean) session.getAttribute("ubean");
		out.println("<h2>Welcome User : " + ub.getFirstName() + "</h2><br>");
		%>
	</div>

	<a href="view2">View All Products</a>
	<a href="logout">Logout</a>
</body>
</html>