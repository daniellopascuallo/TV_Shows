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
			<div class="col-sm-8">
			<h1>Welcome, ${user.name}</h1>
				<h2>TV Shows</h2>
				<table class="table table-striped">
				    <tr>
				        <th>Show</th>
				        <th>Network</th>
				        <th>Average Rating</th>
				    </tr>
				    <c:forEach items="${allShows}" var="show">
				        <tr>
				            <td><a href="/shows/${show.id}">${show.title}</a></td>
				            <td>${show.network}</td>
				            <td>${show.getAverageRating()}</td>
				        </tr>
				    </c:forEach>    
				</table>
				<a href="/shows/new" class="btn btn-primary">Add Show</a>			
			</div>
		</div>
	</div>
</body>
</html>