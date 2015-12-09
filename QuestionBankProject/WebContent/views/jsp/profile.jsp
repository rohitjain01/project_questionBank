
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Profile</title>
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/cssCode/styleProfile.css"
	type="text/css" />
<script
	src="${pageContext.request.contextPath}/assets/jsCode/scriptProfile.js"></script>
	
	
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/jsCode/validNav.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/cssCode/headerPassword.css" />
	<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/images/fav.png" />
<script type="text/javascript">
	$(document).ready(
			function() {
				$('ul.nav.navbar-nav').find(
						'a[href="' + location.pathname + '"]').closest('li')
						.addClass('active');
			});

	//$('#update-button').hide();	
</script>

</head>
<body>
	<!-- Menu Navbar-->
	<nav class="navbar navbar-inverse">
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
							<li><a href="/QuestionBankProject/search?search=search&action=1">Frequent</a></li>
							<li><a href="/QuestionBankProject/search?search=search&action=2">Unanswered</a></li>
							<li><a href="/QuestionBankProject/search?search=search&action=3">Answered</a></li>
							<li><a href="/QuestionBankProject/postquestion">Ask
									Question</a></li>
						</ul></li>
					<li><a href="/QuestionBankProject/viewTag">Tag</a></li>
					<li><a href="/QuestionBankProject/contactus">Contact Us</a></li>
					<li><a href="/QuestionBankProject/tour">Take a Tour</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${user.password!=null}">
							<li><a data-toggle="modal" data-target="#ResetModal"><span
									class="glyphicon glyphicon-user"></span> Reset Password</a></li>
						</c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>
					<li><a href="/QuestionBankProject/logout"><span
							class="glyphicon glyphicon-log-out"></span> Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="modal fade" id="ResetModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">ResetPassword</h4>
				</div>
				<div class="modal-body">
					<div id="login">
						<h3>Reset Password</h3>
						<div id="login-page">
							<div id="formContainer">


								<form:form action="reset" method="POST" commandName="user" onSubmit="return check();">
									<div id="se-login-fields">

										<form:hidden path="userId" value="${user.userId}" />

										<spring:bind path="currentPassword">
											<div class="form-group ${status.error ? 'has-error' : ''}">
												<label class="control-label">Current Password</label>
												<form:password path="currentPassword" class="form-control"
													id="password" placeholder="*********" required="required"/>
												<form:errors path="currentPassword" class="control-label" />
											</div>
										</spring:bind>
										<spring:bind path="password">
											<div class="form-group ${status.error ? 'has-error' : ''}">
												<label class="control-label">Password</label>
												<form:password path="password" class="form-control"
													id="passwordf" placeholder="*********" required="required" onkeyup="passwordStrength(this.value);" />
													<label for="passwordStrength">Password strength</label>
											<div id="passwordDescription">Password not entered</div>
											<div id="passwordStrength" class="strength0"></div>
												<form:errors path="password" required="required" class="control-label" />
											</div>
										</spring:bind>
										<spring:bind path="confirmPassword">
											<div class="form-group ${status.error ? 'has-error' : ''}">
												<label class="control-label">Confirm Password</label>
												<form:password path="confirmPassword" class="form-control"
													id="confirmPassword" placeholder="*********" required="required" />
													<span id="strength"></span>
												<form:errors path="confirmPassword" required="required" class="control-label" />
											</div>
										</spring:bind>
										<br> <input type="submit" class="btn btn-primary"
											id="submit-button" name="submit-button"
											value="Reset Password">

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



	<div class="container-fluid text-center">
		<div class="row content">
			<div class=" col-lg-1 col-md-1 hidden-sm hidden-xs sidenav"></div>
			<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
				<div class="text-left col-lg-8 col-md-8 col-sm-8 col-xs-12">
					<h3>My Profile</h3>


					<form:form action="updateuser" method="POST"
						enctype="multipart/form-data" commandName="user">


						<div class="row form-group">
							<div class=" col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<label>Profile Photo</label>
							</div>

						</div>

						<div class="row-form-group">
							<div class=" col-lg-6 col-md-6 col-sm-12 col-xs-12">
								<c:choose>
									<c:when test="${user.image==null}">
										<img
											src="${pageContext.request.contextPath}/assets/images/user_image.png"
											id="blah" alt="No Image here" width="150" height="200">
									</c:when>
									<c:otherwise>
										<img src="${user.image}" id="blah" alt="Profile Pic"
											width="150" height="200">
									</c:otherwise>
								</c:choose>
								<input type="file" class="file " id="test-upload" name="image"
									disabled onchange="readURL(this);">
								${errorimage}

							</div>

							<div class=" col-lg-6 col-md-6 col-sm-12 col-xs-12">

								<div class="form-group">
									<form:hidden path="userId" class="form-control" id="userId"
										name="userId" value="${user.userId}" />
								</div>
								<div class="form-group">
									<label for="name">Name</label> <input type="text"
										class="form-control" id="name" name="name"
										value="${user.name}" placeholder="Your name" disabled>
									${errorname}
								</div>
								<div class="form-group">
									<label for="email">Email</label>
									<p>${user.emailId}</p>
								</div>
								<div class="form-group">
									<label for="account_creation_date">Account_Creation_Date
										:</label>
									<p>${user.accountCreationDate}</p>
								</div>
								<div class="form-group">
									<label for="Last Login">Last_login_date :</label>
									<p>${user.lastlogin}</p>
								</div>

								<!-- button to perform task-->
								<div class="form-group">
									<input type="button" class="btn btn-primary " id="edit-button"
										name="edit-button" value="Edit" onclick="edit()" />
										 <input
										type="hidden" class="btn btn-primary " id="update-button"
										name="action" value="update"/>
										
										<c:choose>
										<c:when test="${user.userId != 1}">
										<input type="submit" class="btn btn-primary"
										id="delete-button"  class="btn btn-danger" name="action" value="delete">
										</c:when>
										<c:otherwise></c:otherwise>
										</c:choose>
								</div>
							</div>
						</div>
					</form:form>
				</div>
				<div
					class="text-center container col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<ul class="nav nav-pills">
						<li class="active"><a data-toggle="pill" href="#home">Questions</a></li>
						<li><a data-toggle="pill" href="#menu1">Answers</a></li>
					</ul>
					<div class="tab-content" style="padding-top:10px;">
						<div id="home" class="tab-pane fade in active">
							<c:forEach items="${userQuestionList}" var="question">
								<div class="row text-left col-lg-12" id="UserQuestionView">
									<div class="row text-left col-lg-12">
										<a
											href="/QuestionBankProject/question?questionId=${question.questionId}">
											<strong>${question.questionTitle}</strong>
										</a>
									</div>
									<p>${question.questionDescription}</p>
									<div class="col-lg-6">
										Related Tags: <br>
										<c:forEach items="${question.tags}" var="tagQuestions">
											<a href="/QuestionBankProject/tagInfo/${tagQuestions.tagId}"><button
													id="tag" type="submit" class="btn btn-default">${tagQuestions.tagName}</button></a>
										</c:forEach>
									</div>
									<div class="col-lg-6 text-right">
										<p>Created Date: ${question.postedTime}</p>
									</div>
									<br>
								</div>
							</c:forEach>
						</div>
						<div id="menu1" class="tab-pane fade">
							<c:forEach items="${userAnswerList}" var="answer" varStatus="status">
								<div id="UserAnswerView">
									<div class="row text-left col-lg-12">
										<div class="col-lg-12">
											<a
												href="/QuestionBankProject/question?questionId=${answer.questionId.questionId}">
												<h3>
													<strong>${answer.questionId.questionTitle}</strong>
												</h3>
											</a>
										</div>
										<div class="col-lg-12 text-right">
											<p>Created Date: ${answer.questionId.postedTime}</p>
											<p>Created By: ${answer.questionId.userId.name}</p>
										</div>
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"><hr></div>
									</div>
									<div class="col-lg-12">
										<div class="container-fluid col-lg-12" id="answersBlock">
											${answer.description}
											<div class="row text-left col-lg-12">
												<div class="col-lg-6"></div>
												<div class="col-lg-6 text-right">
													<p>Created Date: ${answer.postedTime}</p>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>

					</div>
				</div>
			</div>
		<jsp:include page="frequentQuestionsAndTags.jsp" />
	</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
