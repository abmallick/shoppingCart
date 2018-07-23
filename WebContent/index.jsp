<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Shopping</title>
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body>
<h2>Product Catalog</h2>
<div class = "container">
<div align = "left">
	<a href= "login.jsp"><input type = "button" value = "Login"></a>
	</div>
	<div align = "center">
	<a href = "cart.jsp"><input type = "button" value = "Cart"></a>
	</div>
	<div align = "right">
	<form action = "LoginServlet?ACTION=LOGOUT" method = "post">
		<input type = "submit" value = "Logout"></a>
	</form>
		
	</div>
</div>
	<div id="main">
            <div class="inner">
               <section class="tiles">
                  <article class="style1">
                     <span class="image">
                     <img src="images/oneplus.png" />
                     </span>
                     <a href="CartServlet?ITEM=Oneplus">
                        <h2>Oneplus 6</h2>
                        <div class="content">
                           <input type = "button" value = "Add to Cart">
                        </div>
                     </a>
                  </article>
                  <article class="style2">
                     <span class="image">
                     <img src="images/bose.jpg" />
                     </span>
                     <a href="CartServlet?ITEM=Bose">
                        <h2>Bose Headphone</h2>
                        <div class="content">
                           <input type = "button" value = "Add to Cart">
                        </div>
                     </a>
                  </article>
                  <article class="style5">
                     <span class="image">
                     <img src="images/alienware.png" />
                     </span>
                     <a href="CartServlet?ITEM=Alienware">
                        <h2>Alienware 17</h2>
                        <div class="content">
                           <input type = "button" value = "Add to Cart">
                        </div>
                     </a>
                  </article>
				</section>
			</div>
		</div>
</body>
</html>