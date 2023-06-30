<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.hospital.dto.Doctor"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.k {
	color: black;
	text-decoration: none;
	font-size: 30px;
	margin-left: 50px;
}

#g {
	padding-left: 50px;
}

#b {
	margin-left: 1050px;
}

nav {
	background-color: white;
	height: 60px;
	width: 100%;
	margin-top: 0%;
	position: top;
	padding-top: 20px;
}

#f {
	height: 30px;
	width: 100px;
}

@import
	url('https://fonts.googleapis.com/css?family=Roboto:300,400,400i,500');

* {
	padding: 0;
	margin: 0;
	list-style: none;
	text-decoration: none;
}

.sidebar {
	position: fixed;
	left: -300px;
	width: 300px;
	height: 84%;
	background: #042331;
	transition: all .5s ease;
}

.sidebar header {
	font-size: 22px;
	color: white;
	line-height: 70px;
	text-align: center;
	background: #063146;
	user-select: none;
}

.sidebar ul a {
	display: block;
	height: 100%;
	width: 100%;
	line-height: 65px;
	font-size: 20px;
	color: white;
	padding-left: 40px;
	box-sizing: border-box;
	border-bottom: 1px solid black;
	border-top: 1px solid rgba(255, 255, 255, .1);
	transition: .4s;
}

ul li:hover a {
	padding-left: 50px;
}

.sidebar ul a i {
	margin-right: 16px;
}

#check {
	display: none;
}

label #btn, label #cancel {
	position: absolute;
	background: #042331;
	border-radius: 3px;
	cursor: pointer;
}

label #btn {
	left: 40px;
	top: 25px;
	font-size: 35px;
	color: white;
	padding: 6px 12px;
	transition: all .5s;
}

label #cancel {
	z-index: 1111;
	left: -195px;
	top: 17px;
	font-size: 30px;
	color: #0a5275;
	padding: 4px 9px;
	transition: all .5s ease;
}

#check:checked ~ .sidebar {
	left: 0;
}

#check:checked ~ label #btn {
	left: 250px;
	opacity: 0;
	pointer-events: none;
}

#check:checked ~ label #cancel {
	left: 195px;
}

#check:checked ~ section {
	margin-left: 250px;
}

section {
	background: url(bg.jpeg) no-repeat;
	background-position: center;
	background-size: cover;
	height: 100vh;
	transition: all .5s;
}

#div2 {
	height: 540px;
	width: 350px;
	background-color: rgba(255, 255, 0, 0.5);
	margin-left: 600px;
	margin-top: -750px;
}

.a1 {
	height: 25px;
	width: 270px;
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
	height: 600px;
	width: 400px;
	margin-left: 1400px;
	margin-top: -1560px;
	border: 1px solid;
	background-color: white;
	box-shadow: 0px 0px 20px black;
}

#v {
	height: 230px;
	width: 400px;
	background-attachment: fixed;
	margin-top: 0px;
}

h1 {
	text-align: center;
	background-position: inherit;
	margin-top: 10px;
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

#log {
	margin-left: 800px;
}

body {
	height: 800px;
	background-image:
		url("Images/pngtree-health-care-abstract-light-effect-icon-decoration-image_906585.png");
	background-size: cover;
	font-family: Arial, sans-serif;
}

table {
	border: solid;
	border-collapse: collapse;
	height: 300px;
	width: 700px;
	font-size: 25px;
	text-align: center;
	margin-left: 500px;
	box-shadow: 0px 0px 15px black;
}

h1 {
	margin-top: 60px;
	font-size: 30px;
}

tr {
	border: solid 1px;
}

tr:hover {
	background-color: yellow;
}

td {
	border: solid 1px;;
}

td:hover {
	background-color: silver;
}

th {
	background-color: green;
	border: solid 2px;
}

th:hover {
	background-color: background;
}

.container {
	max-width: 450px;
	margin: 0 auto;
	background-color: rgba(255, 255, 255, 0.8);
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
	height: 200px;
	margin-top: 300px;
}

.container h1 {
	text-align: center;
}

.container label {
	display: block;
	font-weight: bold;
	margin-top: 10px;
}

.container input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	padding: 10px 15px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	margin-top: 10px;
	font-size: 16px;
}

h2 {
	color: red;
}
</style>
</head>
<body>
	<nav>
		<a class="k" id="g" href="adminhome.jsp">Home</a> <a class="k"
			href="addpatient.jsp">Add Patient</a> <a class="k"
			href="getallpatient">Patients</a> <a class="k" href="getall">Available
			Doctors</a><a id="log" class="k" href="LogoutServlet"><input id="f"
			type="button" value="Logout"></a>
	</nav>
	<input type="checkbox" id="check">
	<label for="check"> <i class="fas fa-bars" id="btn"></i> <i
		class="fas fa-times" id="cancel"></i>
	</label>
	<div class="sidebar">
		<header id="he">Menu</header>
		<ul>
			<li><a href="editpatient.jsp"><i class="fas fa-qrcode"></i>Update
					Patient</a></li>
			<li><a href="deletepatient.jsp"><i class="fas fa-link"></i>Delete
					Patient</a></li>
			<li><a href="#home" onclick="location.href='getpatientbyid.jsp'"><i
					class="fas fa-stream"></i>Patient By Id</a></li>
			<li><a href="changepassword.jsp"><i
					class="fas fa-calendar-week"></i>Change Password</a></li>
			<li><a href="abouthospital.jsp"><i
					class="far fa-question-circle"></i>About</a></li>
			<li><a href="abouthospital.jsp"><i class="far fa-envelope"></i>Contact</a></li>
		</ul>
	</div>
	<div class="container">
		<%
		String s = (String) request.getAttribute("inid");
		if (s != null) {
			out.print("<h2>" + s + "</h2>");
		}
		%>
		<h1>Enter Patient Id to Delete</h1>
		<form action="editpat">
			<label for="name">ID:</label> <input type="number" id="name"
				name="id" required> <input type="submit" value="Submit">
		</form>
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