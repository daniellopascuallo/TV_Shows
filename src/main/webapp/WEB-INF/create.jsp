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
				<h1>Create a New Show</h1>
				<form:form action="/shows/new" method="post" modelAttribute="newShow">
				    <div class="form-group">
				        <form:label path="title">Title</form:label>
				        <form:input path="title" class="form-control" />
				        <form:errors path="title" class="text-danger"/>
				    </div>
				    <div class="form-group">
				        <form:label path="network">Network</form:label>
				        <form:input path="network" class="form-control" />
				        <form:errors path="network" class="text-danger"/>
				    </div>
				    <input type="submit" value="Create" class="btn btn-primary">
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>