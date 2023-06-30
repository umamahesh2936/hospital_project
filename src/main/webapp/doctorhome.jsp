<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.hospital.dto.Doctor"%>
<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-image: url("Images/istockphoto-1220059467-612x612.jpg");
	background-size: cover;
	background-attachment: fixed;
	font-family: 'Roboto', sans-serif;
	height: 700px;
}

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
	background-attachment: fixed;
	padding-top: 20px;
}

div {
	height: 730px;
	width: 100%;
}

input {
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
	height: 250px;
	width: 500px;
	margin-left: 1400px;
	margin-top: -500px;
	border: 5px solid;
}

#v {
	height: inherit;
	width: inherit;
}

#j {
	margin-left: 220px;
	margin-top: 30px;
	background-color: buttonface;
	border-radius: 10px;
	box-shadow: 0px opx 10px black;
}

#h1 {
	color: navy;
	margin-left: 800px;
	font-size: 30px;
	text-align: center;
	margin-top: -20px;
}

#ex {
	height: 600px;
	width: 900px;
	margin-left: 400px;
	background-color: rgba(255, 255, 255, 0.7);
	border-radius: 50px;
	margin-top: 100px;
	text-align: center;
	box-shadow: 0px 0px 20px black;
}

#t {
	height: 230px;
	margin-top: 30px;
	widht: 100px;
}

#r {
	margin-left: 30px;
	line-height: 50px;
	float: left;
	color: green;
}

#s {
	margin-left: 350px;
	height: 250px;
	width: 400px;
	margin-top: -150px;
	box-shadow: 0px 0px 15px black;
}

#button {
	margin-left: 1700px;
}

input {
	margin-top: -20px;
	background-color: yellow;
}

h2 {
	color: red;
}
</style>
</head>
<body>
	<%
	Doctor d = (Doctor) request.getAttribute("doc2");
	if (d == null) {
		d = (Doctor) session.getAttribute("obj");
	}
	session.setAttribute("obj", d);
	%>
	<nav>
		<a class="k" id="g" href="getall">Specialists</a> <a class="k"
			href="getall">Doctors</a> <a class="k" href="abouthospital.jsp">About</a>
		<h1 id="h1">
			Welcome Doctor
			<%=d.getName().substring(0, 1).toUpperCase() + "" + d.getName().substring(1)%>......
		</h1>
		<a id="button" href="doclogout"> <input type="button"
			value="Logout">
		</a>
	</nav>
	<input type="checkbox" id="check">
	<label for="check"> <i class="fas fa-bars" id="btn"></i> <i
		class="fas fa-times" id="cancel"></i>
	</label>
	<div class="sidebar">
		<header id="he">Menu</header>
		<ul>
			<li><a href="edit?id=<%=d.getId()%>"><i
					class="fas fa-qrcode"></i>Update Doctor</a></li>
			<li><a href="delete?id=<%=d.getId()%>"><i
					class="fas fa-link"></i>Delete Doctor</a></li>
			<li><a href="getdoctorbyid.jsp"><i class="fas fa-stream"></i>Doctor
					By Id</a></li>
			<li><a href="mypatient?id=<%=d.getId()%>"><i
					class="far fa-question-circle"></i>My Patients</a></li>
			<li><a href="changedoctorpassword.jsp"><i
					class="fas fa-calendar-week"></i>Change Password</a></li>
		</ul>
	</div>
	<div id="ex">
		we are here for you <br>
		<h1>Your Healthy life is Our First Priority</h1>
		<img alt="" src="Images/images.jfif">
		<p>From treating the rarest symptoms to performing the most
			complicated surgeries. We have expertise in your condition</p>


		<div id="t">
			<h1 id="r">
				A personalized <br> approach to creating <br>the Perfect
				Smile
			</h1>

			<img alt="" id="s" src="Images/hospital.gif">
		</div>
		<br>
		<%
		String s = (String) session.getAttribute("np");
		if (s != null) {
			out.print("<h2>" + "No Patients are Found" + "</h2>");
		}
		%>
	</div>
	<section></section>
</body>
</html>