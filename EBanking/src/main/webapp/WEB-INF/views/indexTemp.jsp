<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="fr" ng-app="myApp">
<head>
<title>Index</title>
<meta http-equiv="content-type" content="text/html" charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src='resources/js/jquery.plugin.min.js'></script>
<script src='resources/js/jquery.keypad.js'></script>
<link rel='stylesheet' href='resources/css/jquery.keypad.css'></link>
<link rel='stylesheet' href='resources/css/style.css'></link>
<script src="resources/js/angular.min.js"></script>
<script src="resources/js/appIndex.js"></script>
<script src="resources/js/ui-bootstrap-tpls-2.5.0.min.js"></script>
<script src="resources/js/dirPagination.js"></script>
<script src="resources/js/angular-animate.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/css/bootstrap.min.css"></link>
<link rel="stylesheet" href="resources/css/style.css"></link>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.9/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-route.js"></script>
<script src="https://cdn.gitcdn.link/cdn/angular/bower-material/v1.1.9/angular-material.js"></script>
<script src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/t-114/svg-assets-cache.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-messages.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-animate.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-aria.min.js"></script>
<link rel="stylesheet" href="https://cdn.gitcdn.link/cdn/angular/bower-material/v1.1.9/angular-material.css">
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}
/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 900px;
}
</style>
</head>
<body>

	<nav class="navbar navbar-dark navbar-inverse bg-inverse">
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
					<li class="nav- item active"><a class="nav-link"
						href="/EBanking">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="about">About</a></li>
					<li class="nav-item"><a class="nav-link" href="projets">Projets</a></li>
					<li class="nav-item"><a class="nav-link" href="contact">Contact</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<sec:authorize
						access="!(hasRole('ROLE_ADMIN')||hasRole('ROLE_USER'))">
						<li><a href="/EBanking/login"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href="/EBanking/admin"><span
								class="glyphicon glyphicon-user"></span>
								${pageContext.request.userPrincipal.name}</a></li>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_USER')">
						<li><a href="/EBanking/abonne"><span
								class="glyphicon glyphicon-user"></span>
								${pageContext.request.userPrincipal.name}</a></li>
					</sec:authorize>
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
						<li class="nav-item"><a class="nav-link" href="#!comptes">Comptes</a></li>
						<li class="nav-item"><a class="nav-link" href="#!beneficiaires">Bénéficiaires</a></li>
						<li data-toggle="collapse" data-target="#coll">
							<a href="">Virements(Inter + Intra)<span class="caret"></span></a>
							<ul class="collapse" style="list-style-type: none;" id="coll">
								<li class="nav-item"><a class="nav-link" href="#!intra">Virement Intrabancaire</a></li>
								<li class="nav-item"><a class="nav-link" href="#!inter">Virement Interbancaire</a></li>
							</ul>
						</li>
						<li data-toggle="collapse" data-target="#coll2">
							<a href="">Commande Chéquier<span class="caret"></span></a>
							<ul class="collapse" style="list-style-type: none;" id="coll2">
								<li class="nav-item"><a class="nav-link" href="#!cmdChequier">Créer Commande</a></li>
								<li class="nav-item"><a class="nav-link" href="#!listecmdChequier">Liste Des Commandes</a></li>
							</ul>
						</li>
						<li data-toggle="collapse" data-target="#coll3">
							<a href="">Commande Carte<span class="caret"></span></a>
							<ul class="collapse" style="list-style-type: none;" id="coll3">
								<li class="nav-item"><a class="nav-link" href="#!cmdCarte">Créer Commande</a></li>
								<li class="nav-item"><a class="nav-link" href="#!listecmdCarte">Liste Des Commandes</a></li>
							</ul>
						</li>
					</ul>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<h4>Opérations</h4>
					<ul class="nav nav-pills nav-stacked">
						<li class="nav-item"><a class="nav-link" href="#!abonnes">Liste des abonnes</a></li>
					</ul>
				</sec:authorize>
			</div>
			<div class="col-sm-8 text-left">
				<div ng-view></div>
				<script src="resources/js/controller/getAbonnesPageController.js"></script>
				<script src="resources/js/controller/getComptesPageController.js"></script>
				<script src="resources/js/controller/getBeneficiairesPageController.js"></script>
				<script src="resources/js/controller/setVirementIntraPageController.js"></script>
				<script src="resources/js/controller/setVirementInterPageController.js"></script>
				<script src="resources/js/controller/getOperationsPageController.js"></script>
				<script src="resources/js/controller/getCmdChequierPageController.js"></script>
				<script src="resources/js/controller/getListeCmdChequierPageController.js"></script>
				<script src="resources/js/controller/getCmdCartePageController.js"></script>
				<script src="resources/js/controller/getListeCmdCartePageController.js"></script>
				<script src="resources/js/controller/ajoutBeneficiairesPageController.js"></script>
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
