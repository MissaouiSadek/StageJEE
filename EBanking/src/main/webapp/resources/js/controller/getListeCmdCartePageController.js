app.controller('getListeCmdCartePageController', function($scope, $http) {
	$scope.$watch('idClient', function () {
		_refreshCmdsCarte(); 
	});
	$scope.sort = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    }
	$scope.init = function(idClient) {
        $scope.idClient = idClient;
    }
	function _refreshCmdsCarte() {
        $http({
            method : 'GET',
            url : 'http://localhost:8180/EBankingSI/rest/getCmdsCarteByClient/'+$scope.idClient
        }).then(function successCallback(response) {
            $scope.cmdsChequier = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }
	_refreshCmdsCarte();
});