var app = angular.module("myApp", ["ngRoute",,'angularUtils.directives.dirPagination']);
app.config(function($routeProvider) {
    $routeProvider
    .when("/updateClientPage", {
        templateUrl : "abonne/updateClientPage",
        controller : "clientUpdateController"
    })
    .when("/updatePasswordPage", {
        templateUrl : "abonne/updatePasswordPage",
        controller : "abonnePasswordController"
    })
    .otherwise({
        template : "<h1>C'est votre profil</h1><p>Vous pouvez mettre a jour votre mot de passe ou changer vos informations personelles</p>"
    });
});