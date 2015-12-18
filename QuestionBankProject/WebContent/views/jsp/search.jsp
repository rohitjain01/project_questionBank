<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="text-center col-lg-12 col-md-12 col-sm-12 col-xs-12" style="z-index: 2000">
	<form class="form-inline" action="/QuestionBankProject/search"
		role="search" name="form">
		<div class="input-group col-lg-9">
		
							<c:choose>
							<c:when test="${search==null || search=='search'}">
								<input type="text" class="form-control col-lg-9" size="50"
				placeholder="Search the site" name="search" required="required" 
				maxlength="60">
							</c:when>
				<c:otherwise>
					<input type="text" class="form-control col-lg-9" size="50"
						placeholder="Search the site" name="search" required="required"
						maxlength="60" value="${search}">
					
				</c:otherwise>
			</c:choose>
			<div class="input-group-btn btn-xs">
						<select name="relatedTag" id="relatedTag"
							class="form-control selectpicker" multiple>
							<c:forEach items="${listOfTag}" var="tag">
								<option>${tag.tagName}</option>
							</c:forEach>
						</select>
					</div>
			<div class="input-group-btn">
				<button class="form-control btn btn-default" onclick="show();"
					type="submit">Search</button>
			</div>
		</div>
	</form>
</div>
<div class="text-center">
	<p><strong>${message}</strong></p>
	
	<p><strong>${errormessage}</strong></p>
</div>