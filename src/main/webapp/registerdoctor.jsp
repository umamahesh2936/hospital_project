<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#div1 {
	background-image:
		url("https://www.appletechsoft.com/wp-content/uploads/2020/06/Hospital-Management-System.jpg");
	height: 950px;
	width: 100%;
	background-size: cover;
	background-attachment: fixed;
}

#div2 {
	height: 630px;
	width: 350px;
	background-color: rgba(255, 255, 0, 0.5);
	margin-left: 700px;
	margin-top: 200px;
	border-radius: 10px;
}

#div2:hover {
	box-shadow: 0px 0px 20px black;
}

.a1 {
	height: 25px;
	width: 250px;
	margin-left: 60px;
	background-color: aqua;
}

.a1:hover {
	border-radius: 20px;
	background-color: pink;
	height: 30px;
	width: 300px;
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

label {
	font-size: 20px;
}

h2 {
	color: red;
}

b {
	color: green;
	font-size: 30px;
}

#loginb {
	height: 35px;
	width: 90px;
	margin-left: 10px;
	background-color: green;
}
</style>
</head>
<body>
	<div id="div1">
		<div id=div3>
			<nav>
				<a href="home.jsp">Home</a> <a
					href="https://health.economictimes.indiatimes.com/news/hospitals">News</a>
				<a href="abouthospital.jsp">Contact</a> <a href="abouthospital.jsp">About</a>
				<a id="b"> <input type="button" value="LOGOUT">
				</a>

			</nav>
		</div>
		<div id="div2">

			<%
			String s = (String) session.getAttribute("saved");
			if ("Data Saved Successfully".equals(s)) {
				out.print("<b >" + s + "</b>");
			} else if ("Invalid Data".equals(s)) {
				out.print("<h2>" + s + "</h2>");
			}
			%>
			<h1>Doctor Register Form</h1>
			<form action="save" method="post">
				<label> ID :</label> <input class="a1" required="required"
					type="number" placeholder="enter the id " name="id"> <br>
				<br> <label> NAME :</label> <input class="a1"
					required="required" type="text" placeholder="enter the name "
					name="name"><br>
				<br> <label> AGE :</label> <input class="a1"
					required="required" type="number" placeholder="enter the age "
					name="age"> <br>
				<br> <label> SPECIALIZATION :</label> <input class="a1"
					required="required" type="text"
					placeholder="enter the specialization " name="spi"><br>
				<br> <label>EMAIL :</label> <input class="a1"
					required="required" type="email" placeholder="enter the email "
					name="email"><br>
				<br> <label>PASSWORD :</label> <input class="a1"
					required="required" type="password"
					placeholder="enter the password " name="pass"><br>
				<br> <a href="doctorlogin.jsp"> <input id="loginb"
					type="button" value="Login">
				</a> <input id="j" type="submit" value="register">
			</form>
		</div>
	</div>
</body>
</html>