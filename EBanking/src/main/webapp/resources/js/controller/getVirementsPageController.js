app.controller('getVirementsPageController', function($scope, $http) {
	$scope.nombre="10";
	$scope.recherche='aucun';
	$scope.sort = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    }
	$scope.sort("dateVirement");
	$scope.submitRecherche = function() {
		_refreshVirements();
	}
	function _refreshVirements() {
		var url = '';
		if($scope.recherche=='date')
			url = 'http://localhost:8080/EBanking/admin/getDemandesByDate/'+$scope.date1+'&'+$scope.date2;
		else
			url = 'http://localhost:8080/EBanking/admin/getAllDemandeVirementBancaires';
        $http({
            method : 'GET',
            url : url
        }).then(function successCallback(response) {
            $scope.virements = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }
	_refreshVirements();
	
	$scope.confirmerVirement = function(virement){
		$http({
            method : 'PUT',
            url : 'http://localhost:8080/EBanking/admin/updateStatut/'+virement.idDemandeVirementBancaire+'&confirme'
        }).then(_success, _error);
	}
	
	$scope.annulerVirement = function(virement){
		$http({
            method : 'PUT',
            url : 'http://localhost:8080/EBanking/admin/updateStatut/'+virement.idDemandeVirementBancaire+'&non confirme'
        }).then(_success, _error);
	}
	
	function _success(response) {
		_refreshVirements();
        _clearFormData();
    }

    function _error(response) {
        console.log(response.statusText);
    }
});