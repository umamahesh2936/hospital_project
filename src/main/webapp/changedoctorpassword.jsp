
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.hospital.dto.Doctor"%>
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
	background-color: yellow;
	margin-left: 700px;
	margin-top: 200px;
}

#div2:hover {
	box-shadow: 0px 0px 30px black;
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
	color: green;
}

h3 {
	color: red;
	.
}
</style>
</head>
<body>
	<%Doctor d=(Doctor)request.getAttribute("obj");
request.setAttribute("obj", d);
%>
	<div id="div1">
		<div id=div3>
			<nav>
				<a href="doctorhome.jsp">Home</a>
			</nav>
		</div>
		<div id="div2">
			<%
			String s = (String) request.getAttribute("cpass");
			if (s != null) {
				if (s.equals("Successfully Updated")) {
					out.print("<h2>" + s + "</h2>");
				} else if (s.equals("Invalid Password")) {
					out.print("<h3 >" + s + "</h3>");
				}
			}
			%>

			<h1>Doctor Password Change</h1>
			<form action="doctorpass" method="post">
				<label>OLD PASSWORD:&nbsp;</label> <input class="a1"
					required="required" type="text"
					placeholder="enter the old password " name="opass"> <br>
				<br> <label> NEW PASWORD :</label> <input class="a1"
					required="required" type="text"
					placeholder="enter the new password " name="newpass"><br>
				<br> <label>CONFIRM NEW PASSWORD :</label> <input class="a1"
					required="required" type="password"
					placeholder="confirm new password " name="cnewpass"><br>
				<br> <input id="j" type="submit" value="CHANGE">
			</form>
		</div>
	</div>
</body>
</html>