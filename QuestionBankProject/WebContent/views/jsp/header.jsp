<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/jsCode/validNav.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/cssCode/headerPassword.css" />
<nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="197">
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
				<li><a href="/QuestionBankProject/aboutus">About Us</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Questions<span class="caret"></span></a>
					<ul class="dropdown-menu">

						<li><a
							href="/QuestionBankProject/search?search=search&action=1">Frequent</a></li>
						<li><a
							href="/QuestionBankProject/search?search=search&action=2">Unanswered</a></li>
						<li><a
							href="/QuestionBankProject/search?search=search&action=3">Answered</a></li>
						<c:choose>
							<c:when test="${user.userId!=0}">
								<li><a href="/QuestionBankProject/postquestion">Ask
										Question</a></li>
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
					</ul></li>
				<li><a href="/QuestionBankProject/viewTag">Tag</a></li>
				<li><a href="/QuestionBankProject/contactus">Contact Us</a></li>
				<li><a href="/QuestionBankProject/tour">Take a Tour</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${user.userId==0}">
						<li><a data-toggle="modal" data-target="#signupModal"><span
								class="glyphicon glyphicon-user"></span> Sign Up</a></li>

						<li><a data-toggle="modal" data-target="#loginModal"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="profile"><span
								class="glyphicon glyphicon-user"></span>${user.name}</a></li>

						<li><a href="logout"><span
								class="glyphicon glyphicon-log-out"></span> Logout</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>
<!-- Modal (Log in)-->
<div class="modal fade" id="loginModal" role="dialog" style="z-index: 3000">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Login</h4>
			</div>
			<div class="modal-body">
				<div id="login">
					<div id="login-page">
						<div id="formContainer">
							<div id="openid-buttons">
								<a class="googleplus"
									href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/QuestionBankProject/Oauth2CallBack&response_type=code&client_id=149774065229-rm1alg2dqvn37mec2fnqlb4crh0lv93r.apps.googleusercontent.com&approval_prompt=force">
									<img
									src="${pageContext.request.contextPath}/assets/images/google_signin.png"
									class="img-rounded" alt="Cinque Terre" width="200" height="100">
								</a>
							</div>
							<div class="or-container">
								<hr class="or-hr">
								<div id="or">or</div>
							</div>
							<form:form action="/QuestionBankProject/login" method="POST" commandName="user">
								<div id="se-login-fields">
									<spring:bind path="emailId">
										<div class="form-group ${status.error ? 'has-error' : ''}">
											<label class="control-label">Email</label>
											<form:input path="emailId" class="form-control" id="email"
												placeholder="Enter your email" type="email"
												required="required" />
											<form:errors path="emailId" class="control-label" />
										</div>
									</spring:bind>
									<spring:bind path="password">
										<div class="form-group ${status.error ? 'has-error' : ''}">
											<label class="control-label">Password</label>
											<form:password path="password" class="form-control"
												id="password" placeholder="*********" required="required" />
											<form:errors path="password" class="control-label" />
										</div>
									</spring:bind>

									<br> <input type="submit" class="btn btn-primary"
										id="submit-button" name="action" value="Sign In">

								</div>
							</form:form>
						</div>
					</div>

				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>
<!-- Modal(Sign Up) -->
<div class="modal fade" id="signupModal" role="dialog" style="z-index: 3000">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Sign up</h4>
			</div>
			<div class="modal-body">
				<div id="signup">
					<div id="signup-page">
						<div id="formContainer">
							<div id="openid-buttons">
								<a class="googleplus"
									href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/QuestionBankProject/Oauth2CallBack&response_type=code&client_id=149774065229-rm1alg2dqvn37mec2fnqlb4crh0lv93r.apps.googleusercontent.com&approval_prompt=force">
									<img
									src="${pageContext.request.contextPath}/assets/images/google_signin.png"
									class="img-rounded" alt="Cinque Terre" width="200" height="100">
								</a>
							</div>
							<div class="or-container">
								<hr class="or-hr">
								<div id="or">or</div>
							</div>
							<form:form action="/QuestionBankProject/user.do" method="POST"
								onSubmit="return check();" commandName="user" name="form"
								id="form">


								<div id="se-login-fields">

									<spring:bind path="name">
										<div class="form-group ${status.error ? 'has-error' : ''}">
											<label class="control-label">Name</label>
											<form:input path="name" class="form-control" id="name"
												placeholder="Enter your name" required="required"
												maxlength="20" />
											<form:errors path="name" class="control-label" />
										</div>
									</spring:bind>
									<spring:bind path="emailId">
										<div class="form-group ${status.error ? 'has-error' : ''}">
											<label class="control-label">Email</label>
											<form:input path="emailId" class="form-control" id="email"
												placeholder="Enter your email" type="email"
												required="required" />
											<form:errors path="emailId" class="control-label" />
										</div>
									</spring:bind>
									<spring:bind path="password">
										<div class="form-group ${status.error ? 'has-error' : ''}">
											<label class="control-label">Password</label>
											<form:password path="password" class="form-control"
												id="passwordf" placeholder="*********" required="required"
												name="password" onkeyup="passwordStrength(this.value);" />
											<label for="passwordStrength">Password strength</label>
											<div id="passwordDescription">Password not entered</div>
											<div id="passwordStrength" class="strength0"></div>
											<form:errors path="password" class="control-label" />
										</div>

									</spring:bind>
									<spring:bind path="confirmPassword">
										<div class="form-group ${status.error ? 'has-error' : ''}">
											<label class="control-label">Confirm Password</label>
											<form:password path="confirmPassword" class="form-control"
												id="confirmPassword" placeholder="*********"
												required="required" name="confirmPassword" />
											<span id="strength"></span> 
											<form:errors path="confirmPassword" class="control-label" />
										</div>
									</spring:bind>
									<input type="submit" class="btn btn-primary" id="submit-button"
										name="action" value="Sign Up">

								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>