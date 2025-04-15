<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.m.user.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OrderSuccess</title>
<link rel="stylesheet" href="css/OnlineStoreStyles.css">
</head>
<body>
	<div class="container">
		<%
		UserBean ub = (UserBean) session.getAttribute("ubean");
		out.println("<h2>Page belongs to User : " + ub.getFirstName() + "</h2><br>");
		float msg = (float) request.getAttribute("msg");
		out.println("<h2>Your Total Bill Amount is : Rs." + msg + "</h2><br>");
		%>
		<a href="payment.html">Payment</a> <a href="view2">View All
			Products</a> <a href="logout">Logout</a>
	</div>
</body>
</html>