<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="sidenav col-lg-2 col-md-2 col-sm-12 col-xs-12">
	<div class="well col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<h4>Frequent Questions</h4>
		<c:forEach items="${questionList}" var="question">
			<hr>
			<a href='/QuestionBankProject/question?questionId=${question.questionId}'>${question.questionTitle}</a>
		</c:forEach>
	</div>
	<div class="well col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<h4>Frequent Tags</h4>
		<c:forEach items="${tagList}" var="tag">
			<hr>
			<a href="/QuestionBankProject/tagInfo/${tag.tagId}">${tag.tagName}</a>

		</c:forEach>
	</div>
</div>