<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Response(Msg)JSP</title>
<link rel="stylesheet" href="css/OnlineStoreStyles.css">
</head>
<body>

	<%
	String msg = (String) request.getAttribute("msg");
	out.println("<h2>" + msg + "</h2>");
	%>

	<%@ include file="home.html"%>

</body>
</html>