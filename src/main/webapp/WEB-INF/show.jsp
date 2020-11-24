<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>TV Shows</title>
	<link rel="stylesheet"
		href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
	<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
	<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row mt-5">
			<div class="col-sm-6">
				<h1>${show.title}</h1>
				<h3>Network: ${show.network}</h3>
				<a href="/shows/${show.id}/edit" class="btn btn-primary">Edit Show</a>
			<h1>Users who rated this show</h1>
			<table class="table table-striped">
			    <tr>
			        <th>Name</th>
			        <th>Rating</th>
			    </tr>
			    <c:forEach items="${show.reviews}" var="review">
			        <tr>
			            <td>${review.user.name}</td>
			            <td>${review.rating}</td>
			        </tr>
			    </c:forEach>    
			</table>
			</div>
		</div>
		<div class="row mt-4">
			<div class="col-sm-6">
				<form:form action="/shows/${show.id}" method="post" modelAttribute="newReview">
					<div class="form-group">
				        <form:label path="rating"><h2>Leave a Rating</h2></form:label>
				        <form:input type="number" path="rating" class="form-control" step="0.1"></form:input>
				        <form:errors path="rating" class="text-danger"></form:errors><br>						
					</div>
					<input type="submit" value="Rate ${show.title}" class="btn btn-primary">
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>