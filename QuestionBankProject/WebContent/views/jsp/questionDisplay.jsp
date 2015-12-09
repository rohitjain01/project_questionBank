<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
	<div class="col-lg-12">

		<h3 class="text-center">Questions</h3>

		<c:forEach items="${searchQuestions}" var="question">
			<div class="row text-left col-lg-12 col-sm-12 col-md-12 col-xs-12"
				id="questionView">
				<a
					href="/QuestionBankProject/question?questionId=${question.questionId}"><h3>
						<strong>${question.questionTitle}</strong>
					</h3></a>
				<p>${question.questionDescription}</p>
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
					Related Tags: <br>
					<c:forEach items="${question.tags}" var="tagQuestions">
						<a href="/QuestionBankProject/tagInfo/${tagQuestions.tagId}"><button
								id="tag" type="submit" class="btn btn-default">${tagQuestions.tagName}</button></a>
					</c:forEach>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 text-right">
					<p>Created Date: ${question.postedTime}</p>
					<p>Created By: ${question.userId.name}</p>
				</div>

			</div>
		</c:forEach>
	</div>


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