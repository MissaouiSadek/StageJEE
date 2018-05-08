app.controller('setVirementIntraPageController', function($scope, $http, $window, $mdDialog) {
	$scope.pass = "";
	$scope.init = function(idClient) {
        $scope.idClient = idClient;
    }
	$scope.$watch('idClient', function () {
		_refreshRIB();
	});
	
	$scope.VirementForm =	{
			montant : 0
	};
	
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
    }
	
	_refreshRIB();
	
	$scope.submitVirement = function(ev) {
		if($scope.ribexpediteur.rib == $scope.ribdestinataire.rib)
			$scope.reponse = "ribdestinataire doit etre different du ribexpediteur";
		else{
		if($scope.VirementForm.montant <= $scope.ribexpediteur.solde)
		{
			$scope.showPrompt(ev);
		}
		else
			$scope.reponse = "montant doit etre inferieur au solde du ribexpediteur";
		}
	}
	function _success(response) {
		//$window.location.href = '/EBanking/';
		_refreshForm();
		$scope.reponse = "Votre virement a reussi.";
        console.log(response.statusText);
    }

    function _error(response) {
        console.log(response.statusText);
    }
	_refreshForm = function()
	{
		$scope.VirementForm.montant=0;
		$scope.ribexpediteur="";
		$scope.ribdestinataire="";
	}
	$scope.reset = function() {
    	_refreshForm();
    };
    
    $scope.virement = function() 
    {
			$scope.VirementForm.ribexpediteur=$scope.ribexpediteur.rib;
			$scope.VirementForm.ribdestinataire=$scope.ribdestinataire.rib;
			var type="Intra";
			_saveOperationExp();
			_saveOperationDes();
			$http({
	            method : 'POST',
	            url : 'http://localhost:8080/EBanking/abonne/addDemandeVirementBancaire/'+type,
	            data : angular.toJson($scope.VirementForm),
	            headers : {
	                'Content-Type' : 'application/json'
	            }
	        }).then( _success, _error );
    }
	
    function _saveOperationExp()
    {
    	$scope.OperationForm.description = "Virement intraBancaire a "+$scope.ribdestinataire.rib;
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
    function _saveOperationDes()
    {
    	$scope.OperationForm.description = "Virement intraBancaire de "+$scope.ribexpediteur.rib;
    	$scope.OperationForm.valeur = $scope.VirementForm.montant;
    	$scope.OperationForm.compte = $scope.ribdestinataire;
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
    	      controller : 'verifPageController',
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
})
.controller('verifPageController', function(scope, $http, $window, $mdDialog)
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
});