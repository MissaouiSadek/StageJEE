app.controller('getCmdCartePageController', function($scope, $http, $window) {
	$scope.init = function(idClient) {
        $scope.idClient = idClient;
    }
	$scope.$watch('idClient', function () {
		_refreshRIB(); 
	});
	function _refreshRIB() {
        $http({
            method : 'GET',
            url : 'http://localhost:8180/EBankingSI/rest/getComptesByIdClient/'+$scope.idClient
        }).then(function successCallback(response) {
            $scope.comptes = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
        $http({
            method : 'GET',
            url : 'http://localhost:8180/EBankingSI/rest/getClient/'+$scope.idClient
        }).then(function successCallback(response) {
            $scope.client = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }
	_refreshRIB();
	$scope.submitCmd = function() {
			$scope.cmdCarteForm.statut="en cours d'impression";
			$scope.cmdCarteForm.client=$scope.client;
			$scope.cmdCarteForm.compte=$scope.rib;
			$http({
	            method : 'POST',
	            url : 'http://localhost:8180/EBankingSI/rest/addCmdCarte',
	            data : angular.toJson($scope.cmdCarteForm),
	            headers : {
	                'Content-Type' : 'application/json'
	            }
	        }).then( _success, _error );
	}
	function _success(response) {
		//$window.location.href = '/EBanking/';
		$scope.reponse="Commande carte ajoutee";
    	_refreshForm();
        console.log(response.statusText);
    }

    function _error(response) {
        console.log(response.statusText);
    }
	_refreshForm = function()
	{
		$scope.cmdCarteForm.type="";
		$scope.rib="";
	}
	$scope.reset = function() {
    	_refreshForm();
    };
	
});