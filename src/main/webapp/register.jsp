<%@ page language="java" 
		 contentType="text/html; charset=ISO-8859-1"
     	 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Response-JSP</title>
 
<link rel="stylesheet" href="css/OnlineStoreStyles.css"> 
  	<link rel="icon" href="https://cdn-icons-png.freepik.com/256/2921/2921222.png?ga=GA1.1.564359830.1708451628&">
  

</head>
<body>
<div class="container">
<%
	String msg = (String)request.getAttribute("msg");
	out.println(msg);
%>
</div>
<%@ include file="UserLogin.html" %>

</body>
</html>