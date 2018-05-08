<!DOCTYPE html>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@page session="true"%>
<html lang="fr"  ng-app="myApp">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Index</title>
  <!-- <link rel="stylesheet" href="https://cdn.gitcdn.link/cdn/angular/bower-material/v1.1.9/angular-material.css">  -->
  <link rel="stylesheet" href="resources/css/bootstrap.min.css"></link>
  <!-- Custom fonts for this template-->
  <link href="resources/css/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="resources/css/sb-admin.min.css" rel="stylesheet">
  <script src="resources/js/jquery.min.js"></script>
<script src='resources/js/jquery.plugin.min.js'></script>
<script src='resources/js/jquery.keypad.js'></script>
<link rel='stylesheet' href='resources/css/jquery.keypad.css'></link>
<link rel='stylesheet' href='resources/css/style.css'></link>
<script src="resources/js/angular.min.js"></script>
<script src="resources/js/appIndex.js"></script>
<script src="resources/js/ui-bootstrap-tpls-2.5.0.min.js"></script>
<script src="resources/js/dirPagination.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-route.js"></script>
<script src="https://cdn.gitcdn.link/cdn/angular/bower-material/v1.1.9/angular-material.js"></script>
<script src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/t-114/svg-assets-cache.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-messages.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-animate.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-aria.min.js"></script>
<link rel='stylesheet' href='resources/css/angular-material.css'></link>
<script>
function formSubmit() {
	document.getElementById("logoutForm").submit();
}
</script>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="/EBanking/">E-Banking</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
      	<sec:authorize access="hasRole('ROLE_ADMIN')">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Liste des abonnes">
          <a class="nav-link" href="#!abonnes">
            <i class="fa fa-fw fa-table"></i>
            <span class="nav-link-text">Liste des abonnes</span>
          </a>
        </li>
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_USER')">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Comptes">
          <a class="nav-link" href="#!comptes">
            <i class="fa fa-fw fa-dashboard"></i>
            <span class="nav-link-text">Comptes</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Bénéficiaires">
          <a class="nav-link" href="#!beneficiaires">
            <i class="fa fa-fw fa-area-chart"></i>
            <span class="nav-link-text">Bénéficiaires</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Virements">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseComponents" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-wrench"></i>
            <span class="nav-link-text">Virements</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseComponents">
            <li>
              <a href="#!intra">Virement Intrabancaire</a>
            </li>
            <li>
              <a href="#!inter">Virement Interbancaire</a>
            </li>
          </ul>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Commande Chéquier">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseExamplePages" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-file"></i>
            <span class="nav-link-text">Commande Chéquier</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseExamplePages">
            <li>
              <a href="#!cmdChequier">Créer commande</a>
            </li>
            <li>
              <a href="#!listecmdChequier">Liste des commandes</a>
            </li>
          </ul>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Commande Carte">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseExamplePages2" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-sitemap"></i>
            <span class="nav-link-text">Commande Carte</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseExamplePages2">
            <li>
              <a href="#!cmdCarte">Créer commande</a>
            </li>
            <li>
              <a href="#!listecmdCarte">Liste des commandes</a>
            </li>
          </ul>
        </li>
        </sec:authorize>
      </ul>
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <form class="form-inline my-2 my-lg-0 mr-lg-2">
            <div class="input-group">
              <input class="form-control" type="text" placeholder="Rechercher...">
              <span class="input-group-append">
                <button class="btn btn-primary" type="button">
                  <i class="fa fa-search"></i>
                </button>
              </span>
            </div>
          </form>
        </li>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
		<li class="nav-item">
			<a class="nav-link" href="/EBanking/admin">
				<i class="fa fa-fw fa-user"></i>
				${pageContext.request.userPrincipal.name}
			</a>
		</li>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_USER')">
		<li class="nav-item">
			<a class="nav-link" href="/EBanking/abonne">
				<i class="fa fa-fw fa-user"></i>
				${pageContext.request.userPrincipal.name}
			</a>
		</li>
		</sec:authorize>
		<sec:authorize access="(hasRole('ROLE_ADMIN')||hasRole('ROLE_USER'))">
        <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
        </li>
        </sec:authorize>
        <sec:authorize access="!(hasRole('ROLE_ADMIN')||hasRole('ROLE_USER'))">
			<li class="nav-item">
				<a class="nav-link" href="/EBanking/login">
					<i class="fa fa-fw fa-sign-in"></i>
					Login
				</a>
			</li>
		</sec:authorize>
      </ul>
    </div>
  </nav>
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="/EBanking/">Index</a>
        </li>
        <li class="breadcrumb-item active"></li>
      </ol>
      <div class="row">
        <div class="col-12" ng-view>
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
      </div>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright&#9400; BFI E-Banking 2018</small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Prêt à partir ?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">—</span>
            </button>
          </div>
          <div class="modal-body">Sélectionnez "Déconnexion" ci-dessous si vous êtes prêt à terminer votre session en cours.</div>
          <div class="modal-footer">
          	<c:url value="/logout" var="logoutUrl" />
          	<form action="${logoutUrl}" method="post" id="logoutForm">
          	<c:if test="${pageContext.request.userPrincipal.name != null}">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Annuler</button>
            <a class="btn btn-primary" href="javascript:formSubmit()">Déconnexion</a>
            </c:if>
            </form>
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="resources/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="resources/js/jquery.easing.min.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="resources/js/sb-admin.min.js"></script>
  </div>
</body>

</html>
