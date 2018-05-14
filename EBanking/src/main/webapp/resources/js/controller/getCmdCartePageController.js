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
        $http({
            method : 'GET',
            url : 'http://localhost:8180/EBankingSI/rest/getCmdsCarteByClient/'+$scope.idClient
        }).then(function successCallback(response) {
            $scope.cmdsCarte = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }
	_refreshRIB();
	$scope.submitCmd = function() {
			$scope.cmdCarteForm.statut="en cours d'impression";
			$scope.cmdCarteForm.client=$scope.client;
			$scope.cmdCarteForm.compte=$scope.rib;
			var bool = true;
			var totalCmdsCarte = $scope.cmdsCarte.length;
			for(var i=0;i<totalCmdsCarte;i++)
			{
				if(($scope.cmdsCarte[i].compte.rib==$scope.cmdCarteForm.compte.rib)&&($scope.cmdsCarte[i].statut!="disponible"))
				{
					bool=false;
					break;
				}
			}
			if(bool)
			{
				$http({
		            method : 'POST',
		            url : 'http://localhost:8180/EBankingSI/rest/addCmdCarte',
		            data : angular.toJson($scope.cmdCarteForm),
		            headers : {
		                'Content-Type' : 'application/json'
		            }
		        }).then( _success, _error );
			}
			else
			{
				$scope.reponse = "Cette compte a deja une commande";
				$scope.class="error";
			}
	}
	function _success(response) {
		//$window.location.href = '/EBanking/';
		$scope.reponse="Commande carte ajoutee";
		$scope.class="msg";
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