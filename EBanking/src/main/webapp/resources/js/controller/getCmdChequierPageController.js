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
        $http({
            method : 'GET',
            url : 'http://localhost:8180/EBankingSI/rest/getCmdsChequierByClient/'+$scope.idClient
        }).then(function successCallback(response) {
            $scope.cmdsChequier = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }
	_refreshRIB();
	$scope.submitCmd = function() {
			$scope.cmdChequierForm.statut="en cours d'impression";
			$scope.cmdChequierForm.client=$scope.client;
			$scope.cmdChequierForm.compte=$scope.rib;
			var bool = true;
			var totalCmdsChequier = $scope.cmdsChequier.length;
			for(var i=0;i<totalCmdsChequier;i++)
			{
				if(($scope.cmdsChequier[i].compte.rib==$scope.cmdChequierForm.compte.rib)&&($scope.cmdsChequier[i].statut!="disponible"))
				{
					bool=false;
					break;
				}
			}
			if(bool)
			{
				$http({
		            method : 'POST',
		            url : 'http://localhost:8180/EBankingSI/rest/addCmdChequier',
		            data : angular.toJson($scope.cmdChequierForm),
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
		$scope.class="msg";
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