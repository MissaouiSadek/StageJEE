app.controller('getBeneficiairesPageController', function($scope, $http) {
	$scope.nombre="10";
	$scope.sort = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    }
	function _refreshBeneficiaires() {
        $http({
            method : 'GET',
            url : 'http://localhost:8080/EBanking/abonne/getBeneficiairesValidesByAbonne'
        }).then(function successCallback(response) {
            $scope.beneficiaires = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }
	_refreshBeneficiaires();
});