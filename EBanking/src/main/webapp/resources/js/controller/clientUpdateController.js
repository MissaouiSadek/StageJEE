app.controller('clientUpdateController', function($scope, $http, $window) {
	$scope.init = function(idClient) {
        $scope.idClient = idClient;
    }
	$scope.$watch('idClient', function () {
		_refreshClients(); 
	});
	function _refreshClients() {
        $http({
            method : 'GET',
            url : 'http://localhost:8180/EBankingSI/rest/getClient/'+$scope.idClient
        }).then(function successCallback(response) {
            $scope.clientForm = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }
	_refreshClients();
	
	$scope.submitClient = function() {
		$http({
            method : 'PUT',
            url : 'http://localhost:8180/EBankingSI/rest/updateClient/',
            data : angular.toJson($scope.clientForm),
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then( _success, _error );
	}
    
    $scope.reset = function() {
    	_refreshClients();
    };
    
    function _success(response) {
        _refreshClients();
        $window.location.href = '/EBanking/abonne';
    }

    function _error(response) {
        console.log(response.statusText);
    }
});