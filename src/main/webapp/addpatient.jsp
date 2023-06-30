<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
a {
	color: white;
	text-decoration: none;
	font-size: 30px;
	margin-left: 50px;
}

#b {
	margin-left: 1050px;
}

nav {
	background-color: black;
	height: 70px;
	width: 100%;
	margin-top: -10px
}

#div1 {
	background-image: url("Images/Hospital-Management-System.jpg");
	height: 950px;
	width: 100%;
	background-size: cover;
	background-attachment: fixed;
}

#div2 {
	height: 500px;
	width: 350px;
	background-color: rgba(255, 255, 0, 0.5);
	margin-left: 700px;
	margin-top: 200px;
}

.a1 {
	height: 25px;
	width: 250px;
	margin-left: 60px;
	background-color: aqua;
}

.a1:hover {
	background-color: window;
	height: 30px;
	width: 300px;
	border-top-right-radius: 20px;
	border-bottom-left-radius: 20px;
}

#div3 {
	height: 40px;
}

#j {
	height: 30px;
	width: 80px;
	margin-left: 220px;
}

#j:hover {
	border-radius: 10px;
	background-color: orange;
}

h2 {
	color: red;
}
footer {
	background-color: #f5f5f5;
	padding: 20px 0;
	text-align: center;
	width: 100%;
	padding: 20px;
	position: fixed;
	margin-top: 250px;
}

.footer-content {
	max-width: 100%;
	margin: 0 auto;
}

.footer-content p {
	margin-bottom: 20px;
}

.footer-links li {
	display: inline-block;
	margin: 0 10px;
}

.footer-links a {
	color: #333;
	text-decoration: none;
}

.footer-links a:hover {
	text-decoration: underline;
}

</style>
</head>
<body>
	<div id="div1">
		<div id=div3>
			<nav>
				<a href="adminhome.jsp">Home</a> <a
					href="https://health.economictimes.indiatimes.com/news/hospitals">News</a>
				<a href="abouthospital.jsp">Contact</a> <a href="abouthospital.jsp">About</a>
				<a id="b"> <input type="button" value="LOGOUT">
				</a>
			</nav>
		</div>
		<div id="div2">
			<%
			String s = (String) session.getAttribute("message");
			if ("Please enter valid details".equals(s)) {
				PrintWriter writer = response.getWriter();
				out.print("<h2>" + s + "</h2>");
			}
			%>

			<h1>Patient Register Form</h1>
			<form action="savepatient" method="post">
				<label> ID :&nbsp;</label> <input class="a1" required="required"
					type="number" placeholder="enter the id " name="id"> <br>
				<br> <label> NAME :</label> <input class="a1"
					required="required" type="text" placeholder="enter the name "
					name="name"> <br> <br> <label>AGE :</label> <input
					class="a1" required="required" type="number"
					placeholder="enter the age " name="age"> <br> <br>
				<label> Doctor Id :</label> <input class="a1" required="required"
					type="number" placeholder="enter the consulting doctor id "
					name="did"> <br> <br> <input id="j" type="submit"
					value="register">
			</form>
		</div>
	</div>
	<footer>
		<div id="a2" class="footer-content">
			<p>© 2023 Your Hospital. All rights reserved.</p>
			<ul class="footer-links">
				<li><a href="#">Privacy Policy</a></li>
				<li><a href="#">Terms of Service</a></li>
				<li><a href="#">Contact Us</a></li>
			</ul>
		</div>
	</footer>
</body>
</html>
