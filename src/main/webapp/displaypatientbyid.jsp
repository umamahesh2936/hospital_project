<%@page import="java.sql.ResultSet"%>
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
	ResultSet r = (ResultSet) request.getAttribute("pat");
	%>
	<nav>
		<a href="adminhome.jsp"><input type="button" value="Home">
		</a>
	</nav>
	<div>

		<h1>Patients Details :</h1>
		<table>
			<caption>List of Patients</caption>
			<tr>
				<th>Patient Id</th>
				<th>Patient Name</th>
				<th>Patient Age</th>
				<th>Doctor Id</th>
				<th>Consulting Doctor</th>
				<th>Specialist in</th>
				<th>EDIT</th>
				<th>DELETE</th>
			</tr>
			<%
			if (r != null) {
			%>
			<tr>
				<td><%=r.getInt(1)%></td>
				<td><%=r.getString(2)%></td>
				<td><%=r.getInt(3)%></td>
				<td><%=r.getInt(4)%></td>

				<td><%=r.getString(5)%></td>
				<td><%=r.getString(6)%></td>
				<td><a href="editpat?id=<%=r.getInt(1)%>"> <input
						type="button" value="EDIT">
				</a></td>
				<td><a href="deletepat?id=<%=r.getInt(1)%>"> <input
						type="button" value="DELETE">
				</a></td>
			</tr>
			<%
			}
			%>
		</table>

	</div>
</body>
</html>