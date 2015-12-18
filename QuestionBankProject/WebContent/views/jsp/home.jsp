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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/dist/css/bootstrap-select.css">
<script
	src="${pageContext.request.contextPath}/assets/dist/js/bootstrap-select.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/jsCode/scriptProfile.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/images/fav.png" />
</head>
<body>
	<div class="container-fluid text-center" style="background-image:url('assets/images/bg.png'); background-color:#b84d45;color:#fff;height:200px;">
		<h1>Question Bank</h1>
		<jsp:include page="search.jsp" />
	</div>

	<jsp:include page="header.jsp" />
	<div class="container-fluid">
		<div class="row content">
		<div class="col-lg-1 col-md-1 hidden-sm hidden-xs sidenav text-center"></div> 
			<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">

				
				<div class="text-left col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<h3>Questions</h3>
					<ul class="nav nav-tabs">
						<c:choose>
							<c:when test="${search==null}">
								<li class="active"><a
									href="/QuestionBankProject/search?search=search&action=1">Frequent</a></li>
								<li><a
									href="/QuestionBankProject/search?search=search&action=2">Unanswered</a></li>
								<li><a
									href="/QuestionBankProject/search?search=search&action=3">Answered</a></li>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${action==null||action==1}">
										<c:choose>
											<c:when test="${relatedTag==null}">
												<li class="active"><a
													href="/QuestionBankProject/search?search=${search}&action=1">Frequent</a></li>
												<li><a
													href="/QuestionBankProject/search?search=${search}&action=2">Unanswered</a></li>
												<li><a
													href="/QuestionBankProject/search?search=${search}&action=3">Answered</a></li>
											</c:when>
											<c:otherwise>
												<li class="active"><a
													href="/QuestionBankProject/search?search=${search}&action=1&relatedTag=${relatedTag}">Frequent</a></li>
												<li><a
													href="/QuestionBankProject/search?search=${search}&action=2&relatedTag=${relatedTag}">Unanswered</a></li>
												<li><a
													href="/QuestionBankProject/search?search=${search}&action=3&relatedTag=${relatedTag}">Answered</a></li>
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:when test="${action==2}">
										<c:choose>
											<c:when test="${relatedTag==null}">
												<li><a
													href="/QuestionBankProject/search?search=${search}&action=1">Frequent</a></li>
												<li class="active"><a
													href="/QuestionBankProject/search?search=${search}&action=2">Unanswered</a></li>
												<li><a
													href="/QuestionBankProject/search?search=${search}&action=3">Answered</a></li>
											</c:when>
											<c:otherwise>
												<li><a
													href="/QuestionBankProject/search?search=${search}&action=1&relatedTag=${relatedTag}">Frequent</a></li>
												<li class="active"><a
													href="/QuestionBankProject/search?search=${search}&action=2&relatedTag=${relatedTag}">Unanswered</a></li>
												<li><a
													href="/QuestionBankProject/search?search=${search}&action=3&relatedTag=${relatedTag}">Answered</a></li>
											</c:otherwise>
										</c:choose>


									</c:when>
									<c:when test="${action==3}">
											<c:choose>
											<c:when test="${relatedTag==null}">
												<li><a
													href="/QuestionBankProject/search?search=${search}&action=1">Frequent</a></li>
												<li><a
													href="/QuestionBankProject/search?search=${search}&action=2">Unanswered</a></li>
												<li class="active"><a
													href="/QuestionBankProject/search?search=${search}&action=3">Answered</a></li>
											</c:when>
											<c:otherwise>
												<li><a
													href="/QuestionBankProject/search?search=${search}&action=1&relatedTag=${relatedTag}">Frequent</a></li>
												<li><a
													href="/QuestionBankProject/search?search=${search}&action=2&relatedTag=${relatedTag}">Unanswered</a></li>
												<li class="active"><a
													href="/QuestionBankProject/search?search=${search}&action=3&relatedTag=${relatedTag}">Answered</a></li>
											</c:otherwise>
										</c:choose>
									</c:when>
								</c:choose>

							</c:otherwise>
						</c:choose>
					</ul>
					<div class="tab-content">
						<div id="frequent"
							class="active tab-pane fade in active text-center">

							<jsp:include page="questionDisplay.jsp" />
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
