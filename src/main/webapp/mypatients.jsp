<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hospital.dto.Patient"%>
<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-image:
		url("Images/depositphotos_59244661-stock-photo-doctor-working-with-operating-room.jpg");
	background-size: cover;
	height: 750px;
}

table {
	border: 5px medium solid;
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
</style>
</head>
<body>
	<%
	List<Patient> list = (List<Patient>) request.getAttribute("mypat");
	%>
	<div>
		<h1>My patients in the Hospital :</h1>
		<table>
			<caption></caption>
			<tr>
				<th>Patient Id</th>
				<th>Patient Name</th>
				<th>Patient Age</th>
			</tr>
			<%
			for (Patient p : list) {
			%>
			<tr>
				<td><%=p.getId()%></td>
				<td><%=p.getName()%></td>
				<td><%=p.getAge()%></td>
			</tr>
			<%
			}
			%>
		</table>

	</div>
</body>
</html>