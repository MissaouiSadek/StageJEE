app.controller('getCmdChequierPageController', function($scope, $http, $window) {
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
			$scope.cmdChequierForm.statut="en cours d'impression";
			$scope.cmdChequierForm.client=$scope.client;
			$scope.cmdChequierForm.compte=$scope.rib;
			$http({
	            method : 'POST',
	            url : 'http://localhost:8180/EBankingSI/rest/addCmdChequier',
	            data : angular.toJson($scope.cmdChequierForm),
	            headers : {
	                'Content-Type' : 'application/json'
	            }
	        }).then( _success, _error );
	}
	function _success(response) {
		//$window.location.href = '/EBanking/';
		$scope.reponse="Commande chequier ajoutee";
    	_refreshForm();
        console.log(response.statusText);
    }

    function _error(response) {
        console.log(response.statusText);
    }
	_refreshForm = function()
	{
		$scope.cmdChequierForm.nombre="";
		$scope.rib="";
	}
	$scope.reset = function() {
    	_refreshForm();
    };
	
});