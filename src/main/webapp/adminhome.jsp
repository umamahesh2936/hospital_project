<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.hospital.dto.Admin"%>
<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-image: url("Images/istockphoto-1220059467-612x612.jpg");
	background-size: cover;
	position: fixed;
	font-family: 'Roboto', sans-serif;
	height: 500px;
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
	position: top;
	padding-top: 20px;
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

#pag {
	height: 300px;
	width: inherit;
	overflow: scroll;
	font-size: 18px;
	line-height: 22px;
	margin-top: 20px;
}

img {
	height: 200px;
	width: 350px;
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
	margin-top: 90px;
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

#l {
	background-color: lime;
	height: 40px;
	width: 150px;
}

#t {
	height: 230px;
	margin-top: 30px;
	widht: 100px;
}

#r {
	text-align: left;
	line-height: 50px;
	margin-left: 30px;
}

#s {
	margin-left: 350px;
	margin-top: -150px;
	box-shadow: 0px 0px 15px black;
	width: 400px;
}

#log {
	margin-left: 800px;
}
</style>
</head>
<body>
	<nav>
		<a class="k" id="g" href="addpatient.jsp">Add Patient</a> <a class="k"
			href="getallpatient">Patients</a> <a class="k" href="getall">Available
			Doctors</a><a id="log" class="k" href="LogoutServlet"><input
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
	<div id="ex">
		we are here for you <br>
		<h1>Your Healthy life is Our First Priority</h1>
		<img alt="" src="Images/images.jfif">
		<p>From treating the rarest symptoms to performing the most
			complicated surgeries. We have expertise in your condition</p>
		<a href="addpatient.jsp"> <input id="l" type="button"
			value="GetAppointment">
		</a>

		<div id="t">
			<h1 id="r">
				A personalized <br> approach to creating <br>the Perfect
				Smile
			</h1>
			<img alt="Not found" id="s"
				src="Images/b823e38cc01fdb9278b6f7faa2feda6d.gif">
		</div>
	</div>

	<section></section>
	<div id="div3">
		<video id="v" autoplay muted loop>
			<track src="path_to_subtitle_file.vtt" kind="subtitles" srclang="en"
				label="English Subtitles">
			<source type="video/mp4" src="Images/604924874.mp4">
		</video>
		<div id="pag">
			<h1>Hospital</h1>

			<br>
			<p>
				A hospital is a health care institution providing patient treatment
				with specialized health science and auxiliary healthcare staff and
				medical equipment. The best-known type of hospital is the general
				hospital, which typically has an emergency department to treat
				urgent health problems ranging from fire and accident victims to a
				sudden illness. A district hospital typically is the major health
				care facility in its region, with many beds for intensive care and
				additional beds for patients who need long-term care. <br> <br>
				Specialized hospitals include trauma centers, rehabilitation
				hospitals, children's hospitals, seniors' (geriatric) hospitals, and
				hospitals for dealing with specific medical needs such as
				psychiatric treatment (see psychiatric hospital) and certain disease
				categories. Specialized hospitals can help reduce health care costs
				compared to general hospitals. Hospitals are classified as general,
				specialty, or government depending on the sources of income
				received. A teaching hospital combines assistance to people with
				teaching to health science students and auxiliary healthcare
				students. <br> <br> A health science facility smaller than
				a hospital is generally called a clinic. Hospitals have a range of
				departments (e.g. surgery and urgent care) and specialist units such
				as cardiology. Some hospitals have outpatient departments and some
				have chronic treatment units. Common support units include a
				pharmacy, pathology, and radiology. Hospitals are typically funded
				by public funding, health organisations (for-profit or nonprofit),
				health insurance companies, or charities, including direct
				charitable donations. Historically, hospitals were often founded and
				funded by religious orders, or by charitable individuals and
				leaders. <br> <br> Currently, hospitals are largely
				staffed by professional physicians, surgeons, nurses, and allied
				health practitioners, whereas in the past, this work was usually
				performed by the members of founding religious orders or by
				volunteers. However, there are various Catholic religious orders,
				such as the Alexians and the Bon Secours Sisters that still focus on
				hospital ministry in the late 1990s, as well as several other
				Christian denominations, including the Methodists and Lutherans,
				which run hospitals. In accordance with the original meaning of the
				word, hospitals were original "places of hospitality", and this
				meaning is still preserved in the names of some institutions such as
				the Royal Hospital Chelsea, established in 1681 as a retirement and
				nursing home for veteran soldiers.
			</p>
			<img alt="somethig missed" src="Images/5_clinics.jpg">
		</div>
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