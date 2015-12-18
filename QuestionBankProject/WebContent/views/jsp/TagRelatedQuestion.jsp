<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Tag Info</title>
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
<script src="${pageContext.request.contextPath}/assets/jsCode/scriptProfile.js"></script> 
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/images/fav.png" />
</head>
<body>

	<div class="container-fluid text-center" style="background-image: url('../assets/images/bg.png'); background-color: #b84d45; color: #fff; height: 100px;">
			<jsp:include page="search.jsp" />
	</div>
	
	<jsp:include page="header.jsp" />
	<div class="container-fluid">
		<div class="row content">
			<div class="col-lg-1 col-md-1 hidden-sm hidden-xs sidenav text-center"></div>
			<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12 text-center">
				
				<div class="col-sm-6 col-lg-12">
					<div class="col-lg-12">
						<h1 class="text-center">${tagNew.tagName}</h1>
						<p>${tagNew.tagDesciption}</p>
						<hr  id="divider">
						<h3 class="text-center">Questions</h3>
					</div>

					<c:forEach items="${tagQuestion}" var="question">
						<div class="row text-left col-lg-12" id="questionView">
							<a href="/QuestionBankProject/question?questionId=${question.questionId}"><h3><strong>${question.questionTitle}</strong></h3></a>
							<p>${question.questionDescription}</p>
							<div class="col-lg-6">
								Related Tags:
								<br>
								<c:forEach items="${question.tags}" var="tagQuestions">
									<a href="/QuestionBankProject/tagInfo/${tagQuestions.tagId}"><button id="tag" type="submit" class="btn btn-default">${tagQuestions.tagName}</button></a>
								
								</c:forEach>
							</div>
							<div class="col-lg-6 text-right">
								<p>Created Date: ${question.postedTime}</p>
								<p>Created By: ${question.userId.name}</p>
							</div>
						</div>
					</c:forEach>
				</div>
				<div id="frequent" class="tab-pane fade in active text-center">
					<%--For displaying Previous link except for the 1st page --%>
					<ul class="pagination">

						<c:if test="${current != 1}">
							<li><a href="${myurl}${current - 1}">Previous</a></li>
						</c:if>

						<c:forEach var="i" begin="${page}" end="${noOfPages}">
							<c:choose>
								<c:when test="${current eq i}">
									<li class="active"><a id="newLink" href="#">${i}</a></li>
								</c:when>
								<c:otherwise>
									<li><a id="newLink" href="${myurl}<c:out value="${i}"/>">
											${i}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>


						<%--For displaying Next link --%>
						<c:if test="${current lt noOfPages}">
							<li><a href="${myurl}${current + 1}">Next</a></li>
						</c:if>
					</ul>
				</div>
			</div>

			<jsp:include page="frequentQuestionsAndTags.jsp" />
		</div>
	</div>
	
		<jsp:include page="footer.jsp" />
</body>
</html>