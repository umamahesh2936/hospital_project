<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hospital.dto.Doctor"%>
<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	height: 800px;
	background-image:
		url("Images/pngtree-health-care-abstract-light-effect-icon-decoration-image_906585.png");
	background-size: cover;
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
	margin-left: 500px;
	margin-top: 280px;
	font-size: 40px;
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

nav {
	height: 40px;
	width: 100%;
	background-color: black;
}
</style>
</head>
<body>
	<%
	Doctor d = (Doctor) request.getAttribute("getwithid");
	Doctor doctor = (Doctor) session.getAttribute("obj");
	session.setAttribute("obj", doctor);
	%>
	<nav>
		<a href="doctorhome.jsp"><input type="button" value="Home">
		</a>
	</nav>
	<div>

		<h1>Doctor Details :</h1>
		<table>
			<caption></caption>
			<tr>
				<th>Doctor Id</th>
				<th>Doctor Name</th>
				<th>Doctor Age</th>
				<th>Doctor Specialization</th>
				<th>Doctor Email</th>
				<th>Patient Count</th>
			</tr>
			<%
			if (d != null) {
			%>
			<tr>
				<td><%=d.getId()%></td>
				<td><%=d.getName()%></td>
				<td><%=d.getAge()%></td>
				<td><%=d.getSpecialist()%></td>
				<td><%=d.getEmail()%></td>
				<td><%=d.getPatientCount()%></td>
			</tr>
			<%
			}
			%>
		</table>

	</div>
</body>
</html>