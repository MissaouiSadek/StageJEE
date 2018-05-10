app.controller('getAbonnesPageController', function($scope, $http, $window) {
	$scope.nombre="10";
	$scope.recherche='aucun';
	$scope.abonnes = [];
	$scope.abonneForm = {
		idClient : "BFI00000",
		codeAbonne : "",
		passwordAbonne : "",
		dateCreation : ""
	};
	$scope.sort = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    }
	function _refreshAbonnes() {
		var url = '';
		if($scope.recherche=='date')
			url = 'http://localhost:8080/EBanking/admin/getAbonnesByDateCreation/'+$scope.date1+'&'+$scope.date2;
		else
			url = 'http://localhost:8080/EBanking/admin/getAllAbonnes/';
        $http({
            method : 'GET',
            url : url
        }).then(function successCallback(response) {
            $scope.abonnes = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
        $http({
            method : 'GET',
            url : 'http://localhost:8080/EBanking/admin/getAllAbonnes/'
        }).then(function successCallback(response) {
            $scope.abonnes2 = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }
	_refreshAbonnes();
	$scope.reset = function(){
		_clearFormData()
	};
	
	$scope.submitRecherche = function() {
		_refreshAbonnes();
	}
	
	$scope.submitAbonne = function() {
		var bool=true;
		var method = "";
		var url = "";
		var totalAbonnes = $scope.abonnes2.length;
		for(var i=0;i<totalAbonnes;i++)
		{
			if($scope.abonnes2[i].idClient==$scope.abonneForm.idClient)
			{
				bool=false;
				break;
			}
		}
		if (bool) {
		method = "POST";
		url = 'http://localhost:8080/EBanking/admin/addAbonne';
		} 
		else {
		method = "PUT";
		url = 'http://localhost:8080/EBanking/admin/updateAbonne';
		}

        $http({
            method : method,
            url : url,
            data : angular.toJson($scope.abonneForm),
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then( _success, _error );
    };

    $scope.deleteAbonne = function(abonne) {
        $http({
            method : 'DELETE',
            url : 'http://localhost:8080/EBanking/admin/deleteAbonne/'+abonne.idClient
        }).then(_success, _error);
    };
    
    $scope.editAbonne = function(abonne) {
    	$scope.abonneForm.idClient = abonne.idClient;
		$scope.abonneForm.codeAbonne = abonne.codeAbonne;
		$scope.abonneForm.passwordAbonne = abonne.passwordAbonne;
		$scope.abonneForm.dateCreation = abonne.dateCreation;
    };
    $scope.getBenef = function(idClient) {
    	$window.location.href ="#!/ajoutBeneficiaire/"+idClient;
    }
    function _success(response) {
        _refreshAbonnes();
        _clearFormData();
    }

    function _error(response) {
        console.log(response.statusText);
    }

    function _clearFormData() {
		$scope.abonneForm.idClient = "BFI00000";
		$scope.abonneForm.codeAbonne = "";
		$scope.abonneForm.passwordAbonne = "";
		$scope.abonneForm.dateCreation = "";
    
    };
});