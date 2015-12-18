<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/cssCode/styleHome.css"
	type="text/css" />
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/images/fav.png" />
</head>
<body>
	<nav class="navbar navbar-inverse text-center">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/QuestionBankProject/">Question
					Bank</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/QuestionBankProject/">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container-fluid text-center">
		<div class="text-center">
			<h1><strong>OOPS!!! ERROR ${errMsg}</strong></h1>
			<p>We are really sorry but page you are requested cannot be found.</p>
			<img class="img-responsive-center" src="${pageContext.request.contextPath}/assets/images/404.jpg" alt="Chania" width="460" height="345"> 
		</div>
	</div>
	<footer class="container-fluid text-center navbar-fixed-bottom" style="background-color: black">
		<p>© 2015 Metacube Software Pvt. Ltd. All rights reserved.</p>
	</footer>

</body>
</html>
