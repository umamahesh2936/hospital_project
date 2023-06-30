<%@page import="java.io.PrintWriter"%>
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
	height: 400px;
	width: 450px;
	background-color: rgba(150, 250, 200, 0.6);
	background-size: cover;
	margin-left: 600px;
	box-shadow: 0px 0px 30px white;
	margin-top: 250px;
}

#div2:hover {
	border-radius: 50px;
	box-shadow: 0px 0px 30px black;
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
	text-align: center;
}

#s {
	height: 30px;
	width: 70px;
	margin-left: 150px;
}

#s:hover {
	background-color: green;
	border-radius: 15px;
	'
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
	font-size: 30px;
	color: red;
	text-align: center;
	margin-top: 100px;
	margin-left: -150px;
}
</style>
</head>
<body>
	<div id="div1">
		<nav>
			<a href="home.jsp">Home</a> <a
				href="https://health.economictimes.indiatimes.com/news/hospitals">News</a>
			<a href="">Contact</a> <a href="abouthospital.jsp">About</a>

		</nav>
		<%
			String me = (String) request.getAttribute("wrong");
			if (me != null) {
				out.print("<h2>" + me + "</h2>");
			}%>
		<div id=div2>
			<form action="login" method="post">
				<h1 id="a">Doctor Login</h1>
				<h3>Email :</h3>
				<input type="text" placeholder="enter the email" class="i1" id="k"
					name="email"> <br> <br>
				<h3>Password :</h3>
				<input type="password" placeholder="enter the password" class="i1"
					name="pass"> <br> <br> <a id="b"
					href="registerdoctor.jsp"> <input id="r" type="button"
					value="SIGNUP"></a> <input id="s" type="submit" value="LOGIN">
			</form>
		</div>
	</div>
</body>
</html>