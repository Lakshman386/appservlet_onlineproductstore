<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.m.admin.*, com.m.commons.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EditProduct</title>
<link rel="stylesheet" href="css/OnlineStoreStyles.css">
</head>
<body>
	<div class="container">
		<%
		AdminBean ab = (AdminBean) session.getAttribute("abean");
		out.println("<h2>Page Belongs to Admin : " + ab.getfName() + "</h2><br>");
		String pCode = request.getParameter("pcode");
		ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("alist");

		Iterator<ProductBean> it = al.iterator();

		while (it.hasNext()) {
			ProductBean pb = (ProductBean) it.next();

			if (pCode.equals(pb.getCode())) {
		%>

		<form action="update" method="post">
			<h2>Update Product Details</h2>
			<p>Update the Product Details Below</p>
			<div class="container">
					<input type="hidden" name="pcode" value=<%=pb.getCode()%>> 
				<label for="price">ProductPrice:</label> 
					<input type="text" id="price" name="price" value=<%=pb.getPrice()%>> 
				<label for="qty">ProductQuantity:</label>
					<input type="text" id="qty" name="qty" value=<%=pb.getQty()%>>
			</div>
			<input type="submit" value="Update Product">
		</form>

		<%
		break;
		}
		}
		%>
	</div>
</body>
</html>