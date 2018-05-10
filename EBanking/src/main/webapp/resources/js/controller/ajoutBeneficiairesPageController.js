app.controller('ajoutBeneficiairesPageController', function($scope, $http, $routeParams) {
	$scope.nombre="10";
	$scope.idClient = $routeParams.idClient;
	$scope.beneficiaires = [];
	$scope.beneficiaireForm = {
		rib : "",
		nom : "",
		prenom : "",
		statut : "",
		codeValidation : "",
		abonne : {idClient : $scope.idClient},
		idBeneficiaire : ""
	};
	$scope.sort = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    }
	function _refreshBeneficiaires() {
		url = 'http://localhost:8080/EBanking/admin/getBeneficiairesByAbonne/'+$scope.idClient;
        $http({
            method : 'GET',
            url : url
        }).then(function successCallback(response) {
            $scope.beneficiaires = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
        $http({
            method : 'GET',
            url : 'http://localhost:8080/EBanking/admin/getBeneficiairesByAbonne/'+$scope.idClient
        }).then(function successCallback(response) {
            $scope.beneficiaires2 = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }
	_refreshBeneficiaires();
	$scope.reset = function(){
		_clearFormData()
	};
	
	$scope.submitRecherche = function() {
		_refreshBeneficiaires();
	}
	
	$scope.submitBeneficiaire = function() {
		var bool=true;
		var method = "";
		var url = "";
		var totalBeneficiaires = $scope.beneficiaires2.length;
		for(var i=0;i<totalBeneficiaires;i++)
		{
			if($scope.beneficiaires2[i].rib==$scope.beneficiaireForm.rib)
			{
				bool=false;
				break;
			}
		}
		if (bool) {
		$scope.beneficiaireForm.codeValidation = "u3rE4kn6EF2";
		method = "POST";
		url = 'http://localhost:8080/EBanking/admin/addBeneficiaire';
		} 
		else {
		$scope.beneficiaireForm.idBeneficiaire = $scope.temp;
		method = "PUT";
		url = 'http://localhost:8080/EBanking/admin/updateBeneficiaire';
		}

        $http({
            method : method,
            url : url,
            data : angular.toJson($scope.beneficiaireForm),
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then( _success, _error );
    };

    $scope.deleteBeneficiaire = function(beneficiaire) {
        $http({
            method : 'DELETE',
            url : 'http://localhost:8080/EBanking/admin/deleteBeneficiaire/'+beneficiaire.idBeneficiaire
        }).then(_success, _error);
    };
    
    $scope.editBeneficiaire = function(beneficiaire) {
    	$scope.beneficiaireForm.rib = beneficiaire.rib;
		$scope.beneficiaireForm.nom = beneficiaire.nom;
		$scope.beneficiaireForm.prenom = beneficiaire.prenom;
		$scope.beneficiaireForm.statut = beneficiaire.statut;
		$scope.temp = beneficiaire.idBeneficiaire;
		$scope.beneficiaireForm.codeValidation = beneficiaire.codeValidation; 
    };
    function _success(response) {
        _refreshBeneficiaires();
        _clearFormData();
    }

    function _error(response) {
        console.log(response.statusText);
    }

    function _clearFormData() {
    	$scope.beneficiaireForm.rib = "";
		$scope.beneficiaireForm.nom = "";
		$scope.beneficiaireForm.prenom = "";
		$scope.beneficiaireForm.statut = "";
		$scope.beneficiaireForm.idBeneficiaire = "";
    };
});