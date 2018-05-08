app.controller('setVirementInterPageController', function($scope, $http, $window, $mdDialog) {
	$scope.init = function(idClient) {
        $scope.idClient = idClient;
    }
	$scope.$watch('idClient', function () {
		_refreshRIB(); 
	});
	$scope.email="";
	$scope.VirementForm =	{
			montant : 0,
			nomDestinataire : "",
			prenomDestinataire : "",
			motif : ""
	}
	$scope.OperationForm = {
			valeur : 0,
			description : "",
			rib : ""
		};
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
            $scope.email = response.data.email;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }
	_refreshRIB();
	function _refreshBen() {
        $http({
            method : 'GET',
            url : 'http://localhost:8080/EBanking/abonne/getBeneficiairesValidesByAbonne/'
        }).then(function successCallback(response) {
            $scope.beneficiaires = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }
	_refreshBen();
	$scope.submitVirement = function(ev) {
		if($scope.VirementForm.montant < $scope.ribexpediteur.solde)
		{
					$scope.showPrompt(ev);
		}
		else
			$scope.reponse = "montant doit etre inferieur au solde du ribexpediteur";
	}
	
	$scope.verifCode = function()
	{
		$scope.codeEnvoyee="";
		var string = $scope.email;
		var array = string.split('@');
		var array2 = array[1].split('.');
		$http({
            method : 'POST',
            url : 'http://localhost:8080/EBanking/abonne/setCodeValidation/'+$scope.ribdestinataire.idBeneficiaire+'&'+array[0]+'/'+array2[0]+'&'+array2[1],
        }).then(function successCallback(response) {
        	console.log(response.statusText);
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
	}
	
	$scope.virement2 = function()
	{
		_saveOperationExp();
		$http({
            method : 'POST',
            url : 'http://localhost:8080/EBanking/abonne/addDemandeVirementBancaire/Inter',
            data : angular.toJson($scope.VirementForm),
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then( _success, _error );
	}
	
	$scope.virement = function() {
				$scope.VirementForm.ribexpediteur=$scope.ribexpediteur.rib;
				$scope.VirementForm.ribdestinataire=$scope.ribdestinataire.rib;
				$scope.VirementForm.beneficiaire=$scope.ribdestinataire;
				$scope.VirementForm.nomDestinataire=$scope.ribdestinataire.nom;
				$scope.VirementForm.prenomDestinataire=$scope.ribdestinataire.prenom;
				$scope.verifCode();
				$scope.showPrompt2();
	}
	function _success(response) {
		//$window.location.href = '/EBanking/';
		$scope.reponse = "Votre virement a reussi.";
		_refreshForm();
        console.log(response.statusText);
    }

    function _error(response) {
        console.log(response.statusText);
    }
	_refreshForm = function()
	{
		$scope.VirementForm.montant=0;
		$scope.VirementForm.nomDestinataire="";
		$scope.VirementForm.prenomDestinataire="";
		$scope.VirementForm.motif="";
		$scope.ribexpediteur="";
		$scope.ribdestinataire="";
	}
	$scope.reset = function() {
    	_refreshForm();
    };
	
    function _saveOperationExp()
    {
    	$scope.OperationForm.description = "Virement interBancaire a "+$scope.ribdestinataire.rib;
    	$scope.OperationForm.valeur = 0-$scope.VirementForm.montant;
    	$scope.OperationForm.compte = $scope.ribexpediteur;
    	$http({
            method : 'POST',
            url : 'http://localhost:8180/EBankingSI/rest/addOperation',
            data : angular.toJson($scope.OperationForm),
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then(function successCallback(response) {
        	console.log(response.statusText);
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }
    $scope.showPrompt = function(ev) {
   	 $mdDialog.show({
   	      templateUrl: 'verif',
   	      controller : 'verifInterPageController',
   	      parent: angular.element(document.body),
   	      targetEvent: ev,
   	      //scope : $scope,
   		  //template : "<br/><form class='form-inline' ng-submit='submitPassword()' name='myForm2'><div class='form-group'><label>Mot de passe</label><input ng-model='pass' type='password' name='password' pattern='[0-9]*'	class='form-control' id='defaultKeypad' required /></div><div class='form-group'><input type='submit' value='submit' class='btn btn-primary btn-sm' ng-disabled='myForm2.$invalid' /></div></form><br/>",
   	      clickOutsideToClose:true,
   	      fullscreen: $scope.customFullscreen,
   	    }).then(function() {
   	        $scope.virement();
   	    }, function() {
   	      $scope.reponse = "Vous avez besoin d'entrer le mot de passe.";
   	    });
   };
   
   $scope.showPrompt2 = function(ev) {
	   	 $mdDialog.show({
	   	      templateUrl: 'verifCode',
	   	      controller : 'verifCodeInterPageController',
	   	      parent: angular.element(document.body),
	   	      targetEvent: ev,
	   	      //scope : { codeEnvoyee : $scope.codeEnvoyee},
	   		  //template : "<br/><form class='form-inline' ng-submit='submitPassword()' name='myForm2'><div class='form-group'><label>Mot de passe</label><input ng-model='pass' type='password' name='password' pattern='[0-9]*'	class='form-control' id='defaultKeypad' required /></div><div class='form-group'><input type='submit' value='submit' class='btn btn-primary btn-sm' ng-disabled='myForm2.$invalid' /></div></form><br/>",
	   	      clickOutsideToClose:true,
	   	      fullscreen: $scope.customFullscreen,
	   	    }).then(function() {
	   	        $scope.virement2();
	   	    }, function() {
	   	      $scope.reponse = "Vous avez besoin d'entrer la code de validation.";
	   	    });
	   };
})
.controller('verifInterPageController', function(scope, $http, $window, $mdDialog)
{
	scope.submitPassword = function()
    {
		scope.pass = $('#defaultKeypad').val();
    	$http({
            method : 'GET',
            url : 'http://localhost:8080/EBanking/abonne/verifPassword/'+scope.pass,
        }).then(function successCallback(response) {
        	if(response.data)
        	{
        		scope.closeDialog();
                //scope.virement();
        	}
        	else
        	{
        		scope.reponse2="Mot de passe incorrecte";
        		//$mdDialog.hide();
        	}
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }
	scope.closeDialog = function() {
		$mdDialog.hide();
	}
})
.controller('verifCodeInterPageController', function(scope, $http, $window, $mdDialog)
{
	scope.submitCode = function()
    {
		$http({
            method : 'GET',
            url : 'http://localhost:8080/EBanking/abonne/verifCodeValidation/'+scope.code,
		}).then(function successCallback(response) {
        	if(response.data)
        	{
        		scope.closeDialog();
        	}
        	else
        	{
        		scope.reponse3="Code Validation incorrecte";
        	}
		}, function errorCallback(response) {
            console.log(response.statusText);
        });
    }
	scope.closeDialog = function() {
		$mdDialog.hide();
	}
});