
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-image: url("Images/digital-stethoscopes-1.jpg");
	background-size: cover;
	background-attachment: fixed;
	height: 730px;
}

.a {
	margin-top: 500px;
}

div {
	margin-top: 400px;
	margin-left: 600px;
	width: 650px;
	height: 200px;
	background-color: rgba(100, 200, 200, 0.6);
	border-radius: 50px;
}

div:hover {
	background-color: blue;
	border-radius: 50px;
	color: white;
}

#i1 {
	height: 50px;
	width: 150px;
	margin-left: 100px;
	box-shadow: 0px 0px 10px black;
}

#i1:hover {
	height: 40px;
	width: 150px;
	border-radius: 20px;
}

#i2 {
	height: 50px;
	width: 150px;
	margin-left: 100px;
	box-shadow: 0px 0px 10px black;
}

#i2:hover {
	height: 40px;
	width: 150px;
	border-radius: 20px;
}

h1 {
	font-size: 50px;
	margin-left: 20px;
}

h1:hover {
	color: white;
}
</style>
</head>
<body>
	<nav></nav>
	<div>
		<h1>Welcome To Hospital World</h1>
		<a class="a" href="adminlogin.jsp"> <input id="i1" type="button"
			value="LOGIN AS ADMIN">
		</a> <a class="a" href="doctorlogin.jsp"> <input id="i2" type="button"
			value="LOGIN AS DOCTOR">
		</a>
	</div>
</body>
</html>