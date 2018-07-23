<%@page import="com.cart.entity.ItemDetails"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="assets/css/main.css" />
<title>Shopping Cart</title>
<script type="text/javascript">
</script>
</head>
<body>
<div class = "container">
	<div class = "col">
		<p> Your shopping cart! </p>
	</div>
	<div class = "col">
	<a href = "index.jsp"><input type = "button" value = "Home"></a>
	</div>
	<div class = "col">
	<a href= "login.jsp"><input type = "button" value = "Login"></a>
	</div>
	<div class = "col">
	<form action = "LoginServlet?ACTION=LOGOUT" method = "post">
		<a href= ><input type = "submit" value = "Logout"></a>
	</form>
	</div>
</div>
<%Vector<String> items = (Vector<String>) session.getAttribute("ITEMS"); %>

<% 
Vector<ItemDetails> it = new Vector<ItemDetails>();
int total = 0;
if(items != null) {
for(String s : items) {
	if(s.equals("Oneplus"))
	{
		it.add( new ItemDetails("Oneplus 6",300));
	}
	else if(s.equals("Bose"))
	{
		it.add( new ItemDetails("Bose Headphone", 200));
	}
	else if(s.equals("Alienware"))
	{
		it.add( new ItemDetails("Alienware 17", 700));
	}
}
session.setAttribute("ITEM_OBJ", it);}%>
<p>Items in your cart: </p>
<table class="table">
	<thead>
	  <tr>	
		<td>Product Name</td>
		<td>Price</td>
		<td>Total</td>
	  </tr>
	</thead>
	<% if(it != null) {
	for(ItemDetails id : it) {%>
		<tr>
			<td><%= id.getName() %></td>
			<td><%= id.getPrice() %></td>
			<%total += id.getPrice(); %>
		</tr>
	<%} }%>
	<tr>
		<td></td>
		<td></td>
		<td><%=total %></td>
	</tr>
</table>
<form action = "LoginServlet?ACTION=CHECKOUT" method = "post">
	<input type="submit" class = "button" value = "Checkout">
</form>
</body>
</html>