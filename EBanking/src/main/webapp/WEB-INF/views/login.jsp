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
  <title>Login</title>
  <script src="resources/js/jquery.min.js"></script>
  <link rel="stylesheet" href="resources/css/bootstrap.min.css"></link>
  <!-- Custom fonts for this template-->
  <link href="resources/css/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="resources/css/sb-admin.min.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src='resources/js/jquery.plugin.min.js'></script>
<script src='resources/js/jquery.keypad.js'></script>
<link rel='stylesheet' href='resources/css/jquery.keypad.css'></link>
<link rel='stylesheet' href='resources/css/style.css'></link>
<script src="resources/js/angular.min.js"></script>
<script src="resources/js/ui-bootstrap-tpls-2.5.0.min.js"></script>
<script src="resources/js/dirPagination.js"></script>
<script src="resources/js/angular-animate.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-route.js"></script>
<script src="https://cdn.gitcdn.link/cdn/angular/bower-material/v1.1.9/angular-material.js"></script>
<script src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/t-114/svg-assets-cache.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-messages.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-animate.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-aria.min.js"></script>
<link rel='stylesheet' href='resources/css/angular-material.css'></link>
<script>
$(function() {
	$('#defaultKeypad').keypad();
});
function formSubmit() {
	document.getElementById("logoutForm").submit();
}
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
</style>
</head>
<body class="bg-dark">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Login</div>
      <div class="card-body">
      	<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
        <form name='loginForm' action="<c:url value='/login' />" method='POST'>
          <div class="form-group">
            <label for="exampleInputEmail1">User</label>
            <input name='username' class="form-control" id="exampleInputEmail1" type="text" aria-describedby="textHelp" placeholder="Enter Nom utilisateur">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type='password' name='password' pattern="[0-9]*"	class="form-control" id="defaultKeypad" />
          </div>
          <input type="submit" value='Login' name="submit" class="btn btn-primary btn-block">
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
        <div class="text-center">
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
</body>

</html>
