<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.hospital.dto.Patient"%>
<%@ page errorPage="errorpage.jsp"%>
<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#div1 {
	background-image: url("Images/Hospital-Management-System.jpg");
	height: 950px;
	width: 100%;
	background-size: cover;
	background-attachment: fixed;
}

#div2 {
	height: 500px;
	width: 300px;
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
</style>
</head>
<body>
	<%
	ResultSet patient = (ResultSet) request.getAttribute("pat1");
	%>
	<div id="div1">
		<div id=div3>
			<nav>
				<a href="adminhome.jsp">Home</a> <a href="">News</a> <a
					href="abouthospital.jsp">About</a> <a id="b"> <input
					type="button" value="LOGOUT">
				</a>
			</nav>
		</div>
		<div id="div2">

			<h1>Patient Update Form</h1>
			<form action="updatepat" method="post">
				<label> ID :</label> <input class="a1" type="number"
					readonly="readonly" value="<%=patient.getInt(1)%>" name="id">
				<br> <br> <label> NAME :</label> <input class="a1"
					type="text" value="<%=patient.getString(2)%>" name="name"><br>
				<br> <label> AGE :</label> <input class="a1" type="number"
					value="<%=patient.getInt(3)%>" name="age"> <br> <br>
				<label>DOCTOR ID :</label> <input class="a1" type="text"
					readonly="readonly" value="<%=patient.getInt(4)%>" name="did"><br>
				<br> <input id="j" type="submit" value="UPDATE">
			</form>
		</div>
	</div>
</body>
</html>