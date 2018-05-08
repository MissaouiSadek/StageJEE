var app = angular.module("myApp", ["ngRoute",'angularUtils.directives.dirPagination']);
app.config(function($routeProvider) {
    $routeProvider
    .when("/updatePasswordAdminPage", {
        templateUrl : "admin/updatePasswordAdminPage",
        controller : "adminPasswordController"
    })
    .otherwise({
        template : "<h1>C'est votre profil</h1><p>Vous pouvez mettre a jour votre mot de passe</p>"
    });
});