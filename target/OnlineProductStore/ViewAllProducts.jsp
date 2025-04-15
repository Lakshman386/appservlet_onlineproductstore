<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.m.admin.*, com.m.commons.*, java.util.*"%>
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
		AdminBean ab = (AdminBean) session.getAttribute("abean");
		out.println("<h2>Page Belongs to Admin : " + ab.getfName() + "</h2><br>");
		
		ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("alist");

		if (al.size() == 0) {
			out.println("<h2>No Products Available...</h2><br>");
		} else {
		%>
	</div>
	<table>
		<tr>
			<th>Code</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Actions</th>
		</tr>
		<%
		Iterator<ProductBean> it = al.iterator();
		while (it.hasNext()) {
			ProductBean pb = (ProductBean) it.next();
		%>
		<tr>
			<td><%=pb.getCode()%></td>
			<td><%=pb.getName()%></td>
			<td><%=pb.getPrice()%></td>
			<td><%=pb.getQty()%></td>
			<td><a href='edit?pcode=<%=pb.getCode()%>'>Edit</a> <a
				href='delete?pcode=<%=pb.getCode()%>'>Delete</a></td>
		</tr>
		<%
		}
		%>
	</table>

	<%
	}
	%>
	<div class="container">
		<a href="product.html">Add Product</a> <a href="logout">Logout</a>
	</div>

</body>
</html>