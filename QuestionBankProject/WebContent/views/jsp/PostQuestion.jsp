<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Post Question</title>
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
<script
	src="${pageContext.request.contextPath}/assets/jsCode/scriptProfile.js"></script>
	<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/images/fav.png" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-lg-1 col-md-1 hidden-sm hidden-xs sidenav"></div>
			<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
				<div class="text-left">
					<div class="text-center">
					<p>${message}</p>
					<p>${errormessage}</p>
				</div>
					<form:form action="PostQuestion" method="post"
						commandName="postQuestion">
						<div id="se-login-fields">
							<spring:bind path="questionTitle">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<label class="control-label">Title:</label>
									<form:input path="questionTitle" class="form-control"
										placeholder="Title" id="title" required="required"
										minlength="10" />
									<form:errors path="questionTitle" class="control-label"></form:errors>
								</div>
							</spring:bind>

							<spring:bind path="questionDescription">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<label class="control-label">Description:</label>
									<div id="wmd-editor" class="wmd-panel">
										<div id="wmd-button-bar"></div>
										<form:textarea path="questionDescription" id="wmd-input"
											required="required" minlength="30" />
										<div id="wmd-preview" class="wmd-panel"></div>
										<form:errors path="questionDescription" class="control-label"></form:errors>
									</div>
								</div>
							</spring:bind>

							<div>
								<label class="control-label">Tag:</label>
								<c:choose>
									<c:when test="${tagError==null}">
										<div class="control-group">
											<input type="text" class="form-control" name="questionTag"
												id="myAutocomplete">
										</div>
									</c:when>
									<c:otherwise>
										<div class="has-error has-feedback">
											<div class="control-group">
												<input type="text" class="form-control" name="questionTag"
													id="myAutocomplete" autocomplete="on">
												<p style="color: red">${tagError}</p>
											</div>
										</div>
									</c:otherwise>
								</c:choose>
								<textarea rows="10" cols="10" id="selectedTags"
									name="selectedTags" hidden="hidden"></textarea>
								<input type="hidden" name="questionId"
									value="${postQuestion.questionId}">
								<div class="text-center"
									style="margin-top: 10px; margin-bottom: 10px;">
									<c:choose>
										<c:when test="${postQuestion.questionId == 0}">
											<input class="btn btn-success" type="submit" value="Post"
												name="action" onClick="check();" />
										</c:when>
										<c:otherwise>
											<input class="btn btn-success" type="submit" value="Edit"
												name="action" onClick="check();" />
										</c:otherwise>
									</c:choose>
									<input class="btn btn-danger" type="reset" value="Clear" />
								</div>
							</div>
						</div>
					</form:form>
				</div>
				
			</div>
			<jsp:include page="frequentQuestionsAndTags.jsp" />
		</div>
	</div>
	<jsp:include page="footer.jsp" />

	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/js/jquery.autocomplete.multiselect.js"></script>
	<script>
		var values = ${val}
		$('#myAutocomplete').autocomplete({

			source : values,
			multiselect : true
		});
	</script>
</body>
</html>
