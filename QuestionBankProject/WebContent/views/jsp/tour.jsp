
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css" type="text/css"> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/cssCode/styleHome.css" type="text/css"> 
<script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.3.js"></script> 
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>


<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/reset.css"> <!-- CSS reset -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"> <!-- Resource style -->
	<script src="${pageContext.request.contextPath}/assets/js/modernizr.js"></script> <!-- Modernizr -->
  	<script src="${pageContext.request.contextPath}/assets/js/jquery-2.1.4.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.mobile.min.js"></script> 
	<script src="${pageContext.request.contextPath}/assets/js/main.js"></script> <!-- Resource jQuery -->

<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/images/fav.png" />
</head>
<body>

	<jsp:include page="header.jsp" />
	
	<section><div>
				<div class="cd-nugget-info">
		<h1>The Site Tour</h1>
		<button id="cd-tour-trigger" class="cd-btn">Start tour</button>
	</div>

	<ul class="cd-tour-wrapper">
		<li class="cd-single-step">
			<span>Step 1</span>

			<div class="cd-more-info top">
					<h3 style="color:#000000">Step Number 1</h3>
				<p><h2 style="color:#0066CC">Sign In.</h2></p>
				<p style="color:#660099">Welcome to the amazing world of questions and answers<p>
				<p style="color:#660000">Just sign up and it would be glory to us!<p>
				<img src="${pageContext.request.contextPath}/assets/images/step-1.png" alt="step 1"></div>
		</li> 
		<!-- .cd-single-step -->

		<li class="cd-single-step">
			<span>Step 2</span>

			<div class="cd-more-info top">
				<h3 style="color:#000000">Step Number 2</h3>
				<p><h2 style="color:#0066CC">Ask Question.</h2></p>
				<p style="color:#339966">Click on Ask questions and post your questions<p>
				<p style="color:#336600">Also see the questions and answers what others are posting!<p>
				<img src="${pageContext.request.contextPath}/assets/images/step-2.png" alt="step 2">			</div>
					</li> 
		<!-- .cd-single-step -->

		<li class="cd-single-step">
			<span>Step 3</span>

			<div class="cd-more-info right">
			<h3 style="color:#000000">Step Number 3</h3>
				<p><h2 style="color:#0066CC">Post Answers.</h2></p>
				<p style="color:#009933">Show the talent,resolve issues of others!Help them!!!<p>
				<p style="color:#336600">Help comunity to grow!<p>
				
				<img src="${pageContext.request.contextPath}/assets/images/step-3.png" alt="step 3">			</div>
		</li> 
		<!-- .cd-single-step -->
	</ul> <!-- .cd-tour-wrapper -->

	
	</div></section>
	<footer class="container-fluid text-center navbar-fixed-bottom">
		<p>© 2015 Metacube Software Pvt. Ltd. All rights reserved.</p>
	</footer>

</body>
</html>
