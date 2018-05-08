<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@page session="true"%>
<html ng-app="myApp">
<head>
<title>Abonne</title>
<meta http-equiv="content-type" content="text/html" charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="resources/js/angular.min.js"></script>
<script src="resources/js/angular-animate.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/dirPagination.js"></script>
<link rel="stylesheet" href="resources/css/bootstrap.min.css"></link>
<link rel="stylesheet" href="resources/css/style.css"></link>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="resources/js/app.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-route.js"></script>
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
<body>
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

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<sec:authorize access="hasRole('ROLE_USER')">
					<h4>Opérations</h4>
					<ul class="nav nav-pills nav-stacked">
						<li><a href="#!updateClientPage">Mise à jour client</a></li>
						<li><a href="#!updatePasswordPage">Mise à jour mot de
								passe</a></li>
					</ul>
				</sec:authorize>
			</div>
			<div class="col-sm-8 text-left">
				<h1>Bonjour</h1>
				<c:url value="/logout" var="logoutUrl" />
				<form action="${logoutUrl}" method="post" id="logoutForm">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
				<script>
					function formSubmit() {
						document.getElementById("logoutForm").submit();
					}
				</script>

				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<h2>
						${pageContext.request.userPrincipal.name} | <a
							href="javascript:formSubmit()"> Logout</a>
					</h2>
				</c:if>
				<hr>
				<div ng-view></div>
				<script src="resources/js/controller/abonnePasswordController.js"></script>
				<script src="resources/js/controller/clientUpdateController.js"></script>
			</div>
			<div class="col-sm-2 sidenav">
				<div class="well">
					<p>ADS</p>
				</div>
				<div class="well">
					<p>ADS</p>
				</div>
			</div>
		</div>
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