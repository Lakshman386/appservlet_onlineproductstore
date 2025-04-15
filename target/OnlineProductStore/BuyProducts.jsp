<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.m.user.*, com.m.commons.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Products</title>
<link rel="stylesheet" href="css/OnlineStoreStyles.css">
</head>
<body>
	<div class="container">
		<%
		UserBean ub = (UserBean) session.getAttribute("ubean");
		ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("alist");
		out.println("<h2>Page Belongs to Admin : " + ub.getFirstName() + "</h2><br>");

		if (al.size() == 0) {
			out.println("<h2>No Products Available...</h2><br>");
		} else {
			ProductBean pb = null;
		%>
	</div>
	<table>
		<tr>
			<th>ProductCode</th>
			<th>ProductName</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>
		<%
		Iterator<ProductBean> it = al.iterator();
		while (it.hasNext()) {
			pb = (ProductBean) it.next();
		%>
		<tr>
			<td><%=pb.getCode()%></td>
			<td><%=pb.getName()%></td>
			<td><%=pb.getPrice()%></td>
			<td><%=pb.getQty()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<form action="order" method="post">
		<input type="hidden" name="pcode" value="<%=pb.getCode()%>">
		Enter Required Quantity : <input type="number" name="qty" id="qty"
			placeholder="Enter Required Quantity" required="required"><br>
		<input type="submit" value="Buy Product">
	</form>

	<%
	}
	%>
	<div class="container">
		<a href="logout">Logout</a>
	</div>
</body>
</html>