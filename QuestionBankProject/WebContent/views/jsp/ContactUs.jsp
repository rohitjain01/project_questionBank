<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Contact Us</title>
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/dist/css/bootstrap-select.css">
<script
	src="${pageContext.request.contextPath}/assets/dist/js/bootstrap-select.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/jsCode/scriptProfile.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/images/fav.png" />

</head>
<body>
<!-- 	<div class="container-fluid text-center" style="background-image:url('assets/images/bg.png'); background-color:#b84d45;color:#fff;height:80px;"> -->
<%-- 		<jsp:include page="search.jsp" /> --%>
		
<!-- 	</div> -->
	<jsp:include page="header.jsp" />
	<div class="container-fluid">
		<div class="row content">
			<div class="col-lg-1 col-md-1 sm-hidden xs-hidden sidenav text-center"></div>
			<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12 text-left">
					<div class="text-center">
						<img
							src="${pageContext.request.contextPath}/assets/images/contact.jpeg"
							class="img-responsive" alt="Contact Us" width="100%">
					</div>
					<p class="text-left">
						<br> <br>We would be happy to hear from you about any of
						your questions or concerns. Please feel free to reach us through
						the following means.
					</p>
					<div>
						<h4>Office</h4>
						<p>
							<strong>Corporate Headquarter and Offshore Development
								Center</strong> <br>SP-6, Phase IV, (Software Technology Park), <br>EPIP
							Sitapura, Jaipur - 302 022, <br>India. <br>Phone:
							+91-141-2771716, 2771717 <br>Fax: +91-141-2771691
						</p>
					</div>
					<div>
						<br>
						<h4>Key Contacts</h4>
						<p>
							Sales: <a href="mailto:sales@metacube.com">sales@metacube.com</a>
						</p>
						<p>
							Career: <a href="mailto:hrd@metacube.com">hrd@metacube.com</a>
						</p>
						<p>
							General: <a href="mailto:info@metacube.com">info@metacube.com</a>
						</p>

					</div>

			</div>
			<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12 sidenav"></div>
		</div>
	</div>
	<footer class="container-fluid text-center" style="background-color: black; position: absolute;">
		<p>&#169; 2015 Metacube Software Pvt. Ltd. All rights reserved.</p>
	</footer>
</body>
</html>
