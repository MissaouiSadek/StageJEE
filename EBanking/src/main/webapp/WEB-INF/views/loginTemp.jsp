<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>
<meta http-equiv="content-type" content="text/html" charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="resources/js/angular.min.js"></script>
<script src="resources/js/angular-animate.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/css/style.css"></link>
<link rel="stylesheet" href="resources/css/jquery.keypad.css"></link>
<link rel="stylesheet" href="resources/css/bootstrap.min.css"></link>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="resources/js/jquery.plugin.min.js"></script>
<script src="resources/js/jquery.keypad.js"></script>
<script>
	$(function() {
		$('#defaultKeypad').keypad();
	});
</script>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 500px;
	padding: 30px;
	margin: 100px auto;
	background: lightblue;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}
/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}
</style>
</head>
<body onload='document.loginForm.username.focus();'>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" style="padding: 0" href="/EBanking/"><img alt="" src="resources/images/bfilogo.jpg" class="img-responsive margin-bottom-20" style="height: 50px"></a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="nav- item"><a class="nav-link"
						href="/EBanking">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="about">About</a></li>
					<li class="nav-item"><a class="nav-link" href="projets">Projets</a></li>
					<li class="nav-item"><a class="nav-link" href="contact">Contact</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<h1>EBanking Login Form</h1>

	<div id="login-box">

		<h3>Login avec Username and Password</h3>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm' action="<c:url value='/login' />" method='POST'
			class="form-horizontal">

			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' name='username' class="form-control"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' pattern="[0-9]*"
						class="form-control" id="defaultKeypad" /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="submit" class="btn btn-primary btn-sm" /></td>
				</tr>
			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
	</div>
	<footer class="container-fluid text-center">
		<p>Footer Text</p>
		<div class="row">
			<div class="col-sm-5">
				<p>
					© 2016 Banque BFI <br> 2. Boulevard Qualité de la Vie 2015 le
					Kram - Tunisie <br> Pour toute information contactez nous sur
					: <br /> contact@banquebfi.com | Tél. : 81 10 55 55
				</p>
			</div>
			<div class="col-sm-5">
				<ul class="nav top_menu pull-right">
					<li><a
						href="http://www.banquezitouna.com/Fr/sms-banking_11_134"
						target="_blank">SMS</a></li>
					<li><a
						href=" http://www.banquezitouna.com/Fr/mobile-banking_11_135"
						target="_blank">Mobile </a></li>
					<li><a href="mailto:contact@banquezitouna.com">Centre de
							Relations Clients</a></li>
				</ul>
			</div>
		</div>

	</footer>
</body>
</html>