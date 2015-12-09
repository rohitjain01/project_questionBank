<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Post Answer</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/cssCode/main.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/cssCode/styleHome.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/cssCode/wmd.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/jsCode/showdown.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/jsCode/wmd.js"></script>

<link rel="stylesheet" type="text/css"
	href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/dist/css/bootstrap-select.css">
<script
	src="${pageContext.request.contextPath}/assets/dist/js/bootstrap-select.js"></script>
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/assets/images/fav.png" />
<script
	src="${pageContext.request.contextPath}/assets/jsCode/scriptProfile.js"></script>

<script>
	function getLikeOnQuestion(id,questionId,islike,onlike){
		$.ajax({
			type: "GET",
			url: "/QuestionBankProject/like?userId="+id+"&questionAnswerId="+questionId+"&isLike="+islike+"&onLike="+onlike,
			datatype:"json",
			    success: function(data){
			    	setLikeOrDislike(data);
			    },error: function(data) {
		            alert("error   "+data);
		        }
		});
		function setLikeOrDislike(list){
				var likes = list[0];
				document.getElementById("likes").innerHTML=likes;
				var dislikes = list[1];
				document.getElementById("dislikes").innerHTML=dislikes;
		}
	}
	</script>


<script>
	function getLikeOnAnswer(id,questionId,answerId,islike,onlike){
		$.ajax({
			type: "GET",
			url: "/QuestionBankProject/like?userId="+id+"&questionId="+questionId+"&questionAnswerId="+answerId+"&isLike="+islike+"&onLike="+onlike,
			datatype:"json",
			    success: function(data){
			    	setLikeOrDislikeOnAnswer(data);
			    },error: function(data) {
		            alert("error   "+data);
		        }
		});
		function setLikeOrDislikeOnAnswer(list){
			for (j = 0; j < list.length/2; j++) {	
				var likes = list[j];
				var a="likeOnAnswer"+j;
				document.getElementById(a).innerHTML=likes;
				var dislikes = list[j+1];
				var b="dislikeOnAnswer"+j;
				document.getElementById(b).innerHTML=dislikes;
			}
		}
	}
	</script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-2 sidenav text-center"></div>
			<div class="col-sm-8 text-center">
				<div>
					<div
						class="sidenavinner container-fluid col-lg-2 col-md-2 col-sm-12 col-xs-12 text-left">
						<span class="badge" id="likes">${likes}</span>&nbsp;<span
							class="glyphicon glyphicon-thumbs-up"></span>
						<c:choose>
							<c:when test="${user.name != null}">
								<a href="#"
									onclick="getLikeOnQuestion(${user.userId},${question.questionId},${true},${true})">Like</a>
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
						<br> <span class="badge" id="dislikes">${dislike}</span>&nbsp;<span
							class="glyphicon glyphicon-thumbs-down"></span>
						<c:choose>
							<c:when test="${user.name != null}">
								<a href="#"
									onclick="getLikeOnQuestion(${user.userId},${question.questionId},${false},${true})">Dislike</a>
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
						<br> <span class="badge">${noOfViews}</span>&nbsp;Number Of
						Views<br>
						<c:choose>
							<c:when test="${user.userId==1 && question.openQuestion == true}">
								<br>
								<a
									href="/QuestionBankProject/close?questionId=${question.questionId}"><span
									class="glyphicon glyphicon-remove"></span> Closed</a>
							</c:when>
						</c:choose>
						<br>
						<c:choose>
							<c:when
								test="${(user.userId == question.userId.userId) && (question.openQuestion) && (noOfAnswers == 0)}">
								<a
									href="/QuestionBankProject/editquestion?questionId=${question.questionId}"><span
									class="glyphicon glyphicon-edit"></span> Edit</a>
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</div>
					<div class="container-fluid col-lg-10" id="questionBlock">
						<div class="row text-left col-lg-12">
							<a
								href="/QuestionBankProject/question?questionId=${question.questionId}"><strong>${question.questionTitle}</strong></a>
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
								<p>Created By: ${question.userId.name}</p>
							</div>
							<div class="col-lg-12">
								<hr id="questionDivider">
							</div>
						</div>
					</div>
					<div>
						<c:forEach items="${answerList}" var="answer" varStatus="status">
							<div class="col-lg-12 col-md-12">
							<div
								class="sidenavinner container-fluid col-lg-2 col-md-2 col-sm-12 col-xs-12 text-left">
								<span class="badge" id="likeOnAnswer${status.index}">${answerLikes[status.index]}</span>&nbsp;<span
									class="glyphicon glyphicon-thumbs-up"></span>
								<c:choose>
									<c:when test="${user.name != null}">
										<a href="#"
											onclick="getLikeOnAnswer(${user.userId},${question.questionId},${answer.answerId},${true},${false})">Like</a>
									</c:when>
									<c:otherwise></c:otherwise>
								</c:choose>
								<br> <span class="badge"
									id="dislikeOnAnswer${status.index}">${answerDislikes[status.index]}</span>&nbsp;<span
									class="glyphicon glyphicon-thumbs-down"></span>
								<c:choose>
									<c:when test="${user.name != null}">
										<a href="#"
											onclick="getLikeOnAnswer(${user.userId},${question.questionId},${answer.answerId},${false},${false})">Dislike</a>
									</c:when>
									<c:otherwise></c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${user.userId==1 && !(answer.verifyAnswer)}">
										<br>
										<a
											href="/QuestionBankProject/verify?questionId=${question.questionId}&answerId=${answer.answerId}"><span
											class="glyphicon glyphicon-ok"></span> Verify</a>
									</c:when>
								</c:choose>
								<c:choose>
									<c:when test="${answer.verifyAnswer}">
										<br>
										<span class="glyphicon glyphicon-ok"></span> Verified
							</c:when>
								</c:choose>
							</div>
							<div class="container-fluid col-lg-10" id="answersBlock">
								<div class="row text-left col-lg-12">
									<p>${answer.description}</p>
									<div class="col-lg-6"></div>
									<div class="col-lg-6 text-right">
										<p>Created Date: ${answer.postedTime}</p>
										<p>Created By: ${answer.userId.name}</p>
									</div>
									<div class="col-lg-12">
										<hr id="questionDivider">
									</div>
								</div>
							</div>
							</div>
						</c:forEach>
					</div>
					<div>
					<c:choose>
						<c:when test="${question.openQuestion}">
							<form:form
								action="/QuestionBankProject/postanswer/${question.questionId}"
								method="post" commandName="answerpost">
								<spring:bind path="description">
									<div
										class="form-group text-left ${status.error ? 'has-error' : ''}">

										<label class="control-label" for="comment">Your
											Answer:</label>
										<div id="wmd-editor" class="wmd-panel">
											<div id="wmd-button-bar"></div>
											<form:textarea path="description" name="description"
												id="wmd-input" required="required" minlength="30" />
											<div id="wmd-preview" class="wmd-panel"></div>
											<form:errors path="description" class="control-label" />

										</div>
									</div>
								</spring:bind>
								<c:choose>
									<c:when test="${user.name == null}">
										<div id="se-login-fields">
											<div class="form-group text-left">
												<label for="name">Name</label> <input type="text"
													class="form-control" id="name" name="name"
													placeholder="Akshat Mathur">
											</div>
											${errorname}
											<div class="form-group text-left">
												<label for="email">Email</label> <input type="email"
													class="form-control" id="email" name="email"
													placeholder="mathur@gmail.com">
											</div>
											${erroremail}
										</div>
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose>
								<div class="form-group text-left">
									<c:choose>
										<c:when test="${user.name != null}">
											<input type="submit" class="btn btn-success" id="post"
												style="margin-top: 10px" value="Post Answer" name="action">
										</c:when>
										<c:otherwise>
											<input type="submit" class="btn btn-success" id="post"
												style="margin-top: 10px" value="Post Answer(as a guest)"
												name="action">
										</c:otherwise>
									</c:choose>
								</div>
							</form:form>
						</c:when>
					</c:choose>
					</div>
				</div>
			</div>
			<jsp:include page="frequentQuestionsAndTags.jsp" />
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
