<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login And Registration</title>
	<link rel="stylesheet"
		href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
	<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
	<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Welcome to TV Shows</h1>
		</div>
		<c:if test="${user != null}">				
			<div class="alert alert-info">Welcome back ${user.name}!</div>
		</c:if>
		<div class="row mt-5">
			<div class=col-sm-8>
				<h3>Register</h3>
				<form:form action="/register" method="post" modelAttribute="registerUser">
				    <div class="form-group">
				        <form:label path="name">Name</form:label>
				        <form:input path="name" class="form-control" />
				        <form:errors path="name" class="text-danger"/>
				    </div>
				    <div class="form-group">
				        <form:label path="email">Email</form:label>
				        <form:input type="email" path="email" class="form-control" />
				        <form:errors path="email" class="text-danger"/>
				    </div>
				  	<div class="form-group">
				        <form:label path="password">Password</form:label>
				        <form:input type="password" path="password" class="form-control" />
				        <form:errors path="password" class="text-danger"/>
				    </div>
				    <div class="form-group">
				        <form:label path="confirm">Confirm Password</form:label>
				        <form:input type="password" path="confirm" class="form-control" />
				        <form:errors path="confirm" class="text-danger"/>
				    </div>
				    <input type="submit" value="Register" class="btn btn-primary">
				</form:form>
			</div>
			<div class=col-sm-4>
				<h3>Login</h3>
				<form:form action="/login" method="post" modelAttribute="loginUser">
				    <div class="form-group">
				        <form:label path="email">Email</form:label>
				        <form:input type="email" path="email" class="form-control" />
				        <form:errors path="email" class="text-danger"/>
				    </div>
				  	<div class="form-group">
				        <form:label path="password">Password</form:label>
				        <form:input type="password" path="password" class="form-control" />
				        <form:errors path="password" class="text-danger"/>
				    </div>
				    <input type="submit" value="Login" class="btn btn-primary">
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>