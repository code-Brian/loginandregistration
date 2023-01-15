<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/app.js"></script>

<title>Login and Registration</title>
</head>
<body>
	<div class="container">
		<h1>Welcome to Login and Registration!</h1>
		<div class="container d-flex mt-5">
			<div class="container">
				<h2>Register</h2>
				<form:form action="/login/create" method="POST" modelAttribute="user">
					<div>
						<form:label path="userName">Username</form:label>
						<form:input path="userName"/>
						<form:errors path="userName"/>
					</div>
					<div>
						<form:label path="email">Email</form:label>
						<form:input type="email" path="email"/>
						<form:errors path="email"/>
					</div>
					<div>
						<form:label path="password">Password</form:label>
						<form:input type="password" path="password"/>			
						<form:errors path="password"/>
					</div>
					<div>
						<form:label path="confirm">Confirm Password</form:label>
						<form:input type="password" path="confirm"/>			
						<form:errors path="confirm"/>
					</div>
					<button class="btn btn-primary">Create Profile</button>
				</form:form>
			</div>
			<div class="container">
				<h2>Login</h2>
				<form:form action="/login" method="GET" modelAttribute="user">
					<div>
						<form:label path="email">Email</form:label>
						<form:input path="email" type="email"/>
						<form:errors path="email"/>
					</div>
					<div>
						<form:label path="password">Password</form:label>
						<form:input path="password" type="email"/>
						<form:errors path="password"/>
					</div>
					<button class="btn btn-success">Login</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>