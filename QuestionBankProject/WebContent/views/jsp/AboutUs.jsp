<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>About Us</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/images/fav.png" />
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
<script src="${pageContext.request.contextPath}/assets/jsCode/scriptProfile.js"></script> 


</head>
<body>
<%-- <div class="container-fluid text-center" style="background-image:url('assets/images/bg.png'); background-color:#b84d45;color:#fff;height:80px;">
		<jsp:include page="search.jsp" />
		<p>${errormessage}</p>
	</div> --%>

<jsp:include page="header.jsp" />
	<div class="container-fluid">
		<div class="row content">
			<div class="col-lg-1 col-md-1 hidden-sm hidden-xs sidenav text-center"></div>
			<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12 text-center">
				<div class="text-left">
					<div>
						<h1>About Us</h1>
						<p class="text-justify">Metacube is a software engineering
							services company that has deep experience in developing
							enterprise level products and applications for a wide spectrum of
							domains including global trade management, supply chain
							analytics, manufacturing analytics, business continuity planning,
							CRM, publishing and eCommerce. These applications have been
							developed on a variety of platforms. The common denominator in
							all our services has been our total customer focus, ensuring that
							each engagement is a success and provides the desired value to
							the customer. Metacube core competency is in working closely
							with software product companies to translate their ideas into
							products using a repeatable process. We bring in successful
							working experience with several product companies that have been
							financed by leading venture capital funds. These have been very
							demanding engagements challenging Metacube to deliver solutions
							that are generic, extensible, user friendly, and robust. With
							Metacube product companies can tap into a dedicated resource pool
							that is talented, scalable and economical. Metacube product
							engineers use agile approach for software development and are
							adept at the art of distributed development. We offer services at
							all stages of product life cycle including developing proof of
							concept, product realization, product reengineering, product
							migration, product maintenance and enhancement, product
							implementation, and customer support. Metacube product
							engineering services enables the clients to focus on their core
							business activities including market research, product road map
							development, product management, marketing and sales. Metacube
							has not only been actively watching the convergence of path
							breaking developments in cloud computing, mobile networks and
							hand held devices; but has been actively engaged with several
							customers in creating products and services that leverage these
							converging technologies. These developments have created a
							powerful new paradigm for the way products and services are going
							to be constructed, deployed, delivered and supported in future
							for both enterprises and consumers. Metacube has gained rich
							experience in building and implementing on demand applications
							and plans to leverage this early mover advantage to help more
							organizations build new software products and services based on
							the SaaS model, migrate existing products to the cloud and
							implement custom cloud based solutions. We are also building web
							as well as native mobile interfaces for several applications to
							extend their reach to a cross section of mobile platforms.</p>
					</div>

				</div>
			</div>
			<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12 sidenav">
				<div class="well">
					<strong>Customer Speak</strong>
					<hr>
					<p class="text-justify">I've been long overdue in sending you
						and the team at Metacube a note of thanks and appreciation for all
						your hard work and dedication. My team reminds me on a very
						regular basis regarding how responsive, professional and thorough
						your group has been and that they are a pleasure to work with. You
						have been exceeding our expectations from the very beginning and
						we will continue to grow and scale the business with you based on
						your excellent service to us and our customers.</p>
				</div>
			</div>
		</div>
	</div>

	<footer class="container-fluid text-center" style="background-color: black; position: absolute;">
		<p>&#169; 2015 Metacube Software Pvt. Ltd. All rights reserved.</p>
	</footer>
</body>
</html>
