app.controller('abonnePasswordController', function($scope, $http, $window) {
	$scope.PasswordForm =	{
			oldPassword : "",
			newPassword : "",
			confirmPassword : ""
	}
	
	$scope.submitPassword = function() { 
		if($scope.PasswordForm.newPassword==$scope.PasswordForm.confirmPassword)
		{
			$http({
	            method : 'PUT',
	            url : 'http://localhost:8080/EBanking/abonne/updatePasswordAbonne/'+$scope.PasswordForm.newPassword+'&'+$scope.PasswordForm.oldPassword,
	            data : angular.toJson($scope.PasswordForm),
	            headers : {
	                'Content-Type' : 'application/json'
	            }
	        }).then( _success, _error );
		}
		else
		{
			$scope.class="error";
			$scope.answer= "nouvelle mot de passe et son confirmation doit etre identiques";
		}
    };
    
    function _success(response) {
    	if(response.data)
    	{
    		$scope.class="msg";
    		$scope.answer= "Mise a jour reussie";
    	}
    	else
    	{
    		$scope.class="error";
    		$scope.answer= "Ancienne mot de passe fausse";
    	}
        _refreshForm();
        console.log(response.statusText);
    }

    function _error(response) {
        console.log(response.statusText);
    }
    
    function _refreshForm()
    {
    	$scope.PasswordForm.newPassword="";
        $scope.PasswordForm.oldPassword="";
        $scope.PasswordForm.confirmPassword="";
    }
    
    $scope.reset = function() {
    	_refreshForm();
    };
});