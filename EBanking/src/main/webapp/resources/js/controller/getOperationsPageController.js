app.controller('getOperationsPageController', function($scope, $http, $routeParams) {
	$scope.nombre="10";
	$scope.rib = $routeParams.rib;
	$scope.recherche='aucun';
	$scope.sortKey = "dateOperation";
	$scope.reverse = !$scope.reverse;
	$scope.sort = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    }
	function _refreshOperations() {
		var url = '';
		if($scope.recherche=='date')
			url = 'http://localhost:8180/EBankingSI/rest/getOperationsByDate/'+$scope.rib+'/'+$scope.date1+'&'+$scope.date2;
		else
			url = 'http://localhost:8180/EBankingSI/rest/getOperationsByNumeroCompte/'+$scope.rib;
        $http({
            method : 'GET',
            url : url
        }).then(function successCallback(response) {
            $scope.operations = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }
	_refreshOperations();
	$scope.submitRecherche = function() {
		_refreshOperations();
	}
});