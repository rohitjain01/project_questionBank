
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Tag View</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/cssCode/styleHome.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/cssCode/tagStyle.css">
</head>
<body>
	<div class="container-fluid text-center"
		style="background-image: url('assets/images/bg.png'); background-color: #b84d45; color: #fff; height: 100px;">
		<div class="text-center col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<form class="form-inline" action="searchtag" role="search">
				<div class="input-group">
					<input type="text" class="form-control" size="50"
						required="required" maxlength="20" placeholder="Search tag"
						name="search">
					<div class="input-group-btn">
						<button class="form-control btn btn-default" type="submit">Search
							Tag</button>
					</div>
				</div>
			</form>
			<div class="text-center">
			<p>${message}</p>
		</div>
		</div>	
	</div>
	<jsp:include page="header.jsp" />
	<div class="container-fluid">
		<div class="row content">
			<div class="col-lg-1 col-md-1 hidden-sm hidden-xs sidenav text-center"></div>
			<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
			
				<div class="row text-center" >
					<div class="col-md-12">
						<h1>
							<strong>Tags</strong>
						</h1>
						<c:choose>
							<c:when test="${role.roleId==3}">
								<a href="/QuestionBankProject/addtag"><button type="submit"
										class="btn btn-success" style="margin-bottom: 10px">Add
										New Tag</button></a>
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
					</div>

				</div>

				<div class="row text-center">
			
					<c:choose>
					<c:when test="${flag==true}">			
					<c:forEach items="${tagList}" var="questionTag"
						varStatus="status">
						<div class="col-sm-4">
							<div class="thumbnail tile  ${tagColor[status.index]}">
								<h3 class="title">${questionTag.tagName}</h3>
								<div id="box">
									<a class="tagView"
										href="/QuestionBankProject/tagInfo/${questionTag.tagId}">${questionTag.tagDesciption}</a>
								</div>
								
							</div>
						</div>
					</c:forEach>
					</c:when>
					<c:otherwise>
						${errormessage}
					</c:otherwise>
					</c:choose>
						
				</div>
			</div>
			<jsp:include page="frequentQuestionsAndTags.jsp" />
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>
