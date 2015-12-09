<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Tag</title>
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

	<jsp:include page="header.jsp" />
	<div class="container-fluid">
		<div class="row content">
			<div class="col-lg-1 col-md-1 hidden-sm hidden-xs sidenav text-center"></div>
			<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12 text-center">
				<jsp:include page="search.jsp" />
				<div class="text-left">
					<form:form action="addtag.do" method="POST"
						commandName="questionTag" class="form">
						<spring:bind path="tagName">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<label for="tagTitle" class="control-label">Tag Title:</label>
								<form:input path="tagName" class="form-control"
									placeholder="Tag Title" id="tagTitle" required="required"
									minlength="4" />
								<form:errors path="tagName" class="control-label" />
							</div>
						</spring:bind>
						<spring:bind path="tagDesciption">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<label for="description" class="control-label">Description:</label>
								<form:textarea path="tagDesciption" class="form-control"
									rows="5" id="description" placeholder="Tag Description"
									required="required" minlength="15" />
								<form:errors path="tagDesciption" class="control-label" />
							</div>
						</spring:bind>
						<div class="text-center" style="margin-top: 10px;">
							<input type="submit" button class="btn btn-success" value="Add"
								name="action">
						</div>
					</form:form>
				</div>
			</div>

			<jsp:include page="frequentQuestionsAndTags.jsp" />
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>
