app.controller('getListeCmdChequierPageController', function($scope, $http) {
	$scope.$watch('idClient', function () {
		_refreshCmdsChequier(); 
	});
	$scope.sort = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    }
	$scope.init = function(idClient) {
        $scope.idClient = idClient;
    }
	function _refreshCmdsChequier() {
        $http({
            method : 'GET',
            url : 'http://localhost:8180/EBankingSI/rest/getCmdsChequierByClient/'+$scope.idClient
        }).then(function successCallback(response) {
            $scope.cmdsChequier = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }
	_refreshCmdsChequier();
});