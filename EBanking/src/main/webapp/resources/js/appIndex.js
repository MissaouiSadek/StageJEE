var app = angular.module("myApp", ["ngRoute","angularUtils.directives.dirPagination","ngMaterial", "ngMessages", "material.svgAssetsCache"]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/comptes", {
        templateUrl : "index/abonne/getComptesPage",
        controller : "getComptesPageController"
    })
    .when("/beneficiaires", {
        templateUrl : "index/abonne/getBeneficiairesPage",
        controller : "getBeneficiairesPageController"
    })
    .when("/intra", {
        templateUrl : "index/abonne/setVirementIntraPage",
        controller : "setVirementIntraPageController"
    })
    .when("/inter", {
        templateUrl : "index/abonne/setVirementInterPage",
        controller : "setVirementInterPageController"
    })
    .when("/cmdChequier", {
        templateUrl : "index/abonne/getCmdChequierPage",
        controller : "getCmdChequierPageController"
    })
    .when("/listecmdChequier", {
        templateUrl : "index/abonne/getListeCmdChequierPage",
        controller : "getListeCmdChequierPageController"
    })
    .when("/cmdCarte", {
        templateUrl : "index/abonne/getCmdCartePage",
        controller : "getCmdCartePageController"
    })
    .when("/listecmdCarte", {
        templateUrl : "index/abonne/getListeCmdCartePage",
        controller : "getListeCmdCartePageController"
    })
    .when("/operations/:rib", {
        templateUrl : "index/abonne/getOperationsPage",
        controller : "getOperationsPageController"
    })
    .when("/abonnes", {
        templateUrl : "index/admin/getAbonnesPage",
        controller : "getAbonnesPageController"
    })
    .when("/ajoutBeneficiaire/:idClient", {
        templateUrl : "index/admin/ajoutBeneficiairesPage",
        controller : "ajoutBeneficiairesPageController"
    })
    .when("/virements", {
        templateUrl : "index/admin/getVirementsPage",
        controller : "getVirementsPageController"
    })
    .otherwise({
        templateUrl : "index/introduction"
    });
});