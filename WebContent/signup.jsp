<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="assets/css/main.css" />
<title>Signup Page</title>
</head>
<body>
<h2>Signup Page</h2>
<div align = "center">
	<form class = "form" action = "LoginServlet?ACTION=SIGNUP" method = "post">
		<input type="text" class = "input" name = "userID" value = "userID">
		<input type="password" class = "text" name = "password" value = "password">
		<input type="submit" class = "button" value = "Signup">
	</form>
</div>
</body>
</html>