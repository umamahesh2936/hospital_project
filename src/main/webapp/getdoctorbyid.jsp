<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<title>Hospital Application Form</title>
<style>
body {
	background-image: url('hospital-background.jpg');
	background-size: cover;
	font-family: Arial, sans-serif;
}

.container {
	max-width: 500px;
	margin: 0 auto;
	background-color: rgba(255, 255, 255, 0.8);
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
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
	<div class="container">
		<%
		String s = (String) session.getAttribute("showmess");
		if (s != null) {
			out.print("<h2>" + s + "</h2>");
		}
		%>
		<h1>Get Doctor By Id</h1>
		<form action="getdocbyid">
			<label for="name">ID:</label> <input type="number" id="name"
				name="id" required> <input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>
