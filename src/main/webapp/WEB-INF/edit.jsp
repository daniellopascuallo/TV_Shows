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
				<form:form action="/shows/${editShow.id}/update" method="post" modelAttribute="editShow">
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
				    <input type="submit" value="Update" class="btn btn-primary">
				</form:form><br>
				<a href="/shows/${show.id}/delete" class="btn btn-danger">Delete</a>
			</div>
		</div>
	</div>
</body>
</html>