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
	<div class="contaioner">
		<h1>Welcome to Login and Registration!</h1>
		<p>Hello, <c:out value="${user.userName}"/>!</p>
		<p class="btn btn-warning"><a class="text-decoration-none text-light" href="/logout">Logout</a></p>
	</div>
</body>
</html>