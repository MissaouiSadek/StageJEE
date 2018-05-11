<h4>Mise à jour mot de passe du client</h4>
<form ng-submit="submitPassword()" name="myForm" class="form-horizontal" novalidate>
	<table>
		<tr>
			<td>Ancienne Mot de passe</td>
			<td><input type="password" pattern="[0-9]*" inputmode="numeric" name="oldPassword" ng-model="PasswordForm.oldPassword" class="form-control" required /></td>
		</tr>
		<tr>
			<td>Nouvelle Mot de passe</td>
			<td><input type="password" pattern="[0-9]*" inputmode="numeric" name="newPassword" ng-model="PasswordForm.newPassword" class="form-control" required /></td>
		</tr>
		<tr>
			<td>Confirmer Nouvelle Mot de passe</td>
			<td><input type="password" pattern="[0-9]*" inputmode="numeric" name="confirmPassword" ng-model="PasswordForm.confirmPassword" class="form-control" required /></td>
		</tr>
	</table>
	<input type="submit" value="Submit" ng-disabled="myForm.$invalid" class="btn btn-primary btn-sm" />
	<button type="button" ng-click="reset()" class="btn btn-warning btn-sm">Réinitialiser</button>
</form>
<br/>
<label ng-class="class" ng-bind="answer"></label>