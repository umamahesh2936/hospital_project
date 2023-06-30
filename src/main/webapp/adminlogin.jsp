<%@ page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
nav {
	background-color: black;
	height: 70px;
	width: 100%;
	margin-top: -10px
}

#div1 {
	height: 950px;
	width: 100%;
	background-image: url("Images/Hospital-Management-System.jpg");
	background-size: cover;
}

em {
	color: white;
}

#h1 {
	size: 40px;
}

#div2 {
	height: 300px;
	width: 550px;
	margin-top: 200px;
	background-image: url("");
	background-size: cover;
	margin-left: 600px;
}

.i1 {
	height: 30px;
	width: 300px;
	border-radius: 30px;
	margin-left: 30px;
}

#k {
	
}

#a {
	font-size: 60px;
}

#s {
	height: 30px;
	width: 70px;
	margin-left: 150px;
}

#s:hover {
	background-color: green;
	border-radius: 15px;
}

a {
	color: white;
	text-decoration: none;
	font-size: 30px;
	margin-left: 50px;
}

#b {
	margin-left: 50px;
}

#r {
	height: 30px;
	width: 100px;
	background-color: teal;
	border-radius: 15px;
}

h2 {
	color: red;
}
</style>
</head>
<body>
	<div id="div1">
		<nav>
			<a href="home.jsp">Home</a> <a
				href="https://health.economictimes.indiatimes.com/news/hospitals">News</a>
			<a href="abouthospital.jsp">Contact</a> <a href="abouthospital.jsp">About</a>
		</nav>

		<div id="div2">
			<%
			String s = (String) session.getAttribute("mess");
			if (s != null) {
				out.print("<h2>" + s + "</h2>");
			}
			%>
			<form action="loginadm" method="post">
				<h1 id="a">Admin Login</h1>
				<h3>Email :</h3>
				<input type="text" placeholder="enter the email" class="i1" id="k"
					name="email" required="required"> <br> <br>
				<h3>Password :</h3>
				<input type="password" placeholder="enter the password" class="i1"
					name="pass" required="required"> <br> <br> <input
					id="s" type="submit" value="LOGIN">
			</form>
		</div>
	</div>
</body>
</html>
