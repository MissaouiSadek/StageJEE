<h4>Mise à jour mot de passe du client</h4>
<form ng-submit="submitPassword()" name="myForm" class="form-horizontal container" novalidate>
	<table>
		<tr>
			<td>Ancienne Mot de passe</td>
			<td><input type="password" pattern="[0-9]*" inputmode="numeric" name="oldPassword" ng-model="PasswordForm.oldPassword" class="form-control col1" required /></td>
		</tr>
		<tr>
			<td>&nbsp</td>
			<td><span ng-show="myForm.$dirty && myForm.oldPassword.$error.pattern" class="cont">*Ancienne Mot de passe doit être numerique</span>
			<span ng-show="myForm.$dirty && myForm.oldPassword.$error.required" class="cont">*Ancienne Mot de passe ne doit pas être vide</span></td>
		</tr>
		<tr>
			<td>Nouvelle Mot de passe</td>
			<td><input type="password" pattern="[0-9]*" inputmode="numeric" name="newPassword" ng-model="PasswordForm.newPassword" class="form-control col1" required /></td>
		</tr>
		<tr>
			<td>&nbsp</td>
			<td><span ng-show="myForm.$dirty && myForm.newPassword.$error.pattern" class="cont">*Nouvelle Mot de passe doit être numerique</span>
			<span ng-show="myForm.$dirty && myForm.newPassword.$error.required" class="cont">*Nouvelle Mot de passe ne doit pas être vide</span></td>
		</tr>
		<tr>
			<td>Confirmer Mot de passe</td>
			<td><input type="password" pattern="[0-9]*" inputmode="numeric" name="confirmPassword" ng-model="PasswordForm.confirmPassword" class="form-control col1" required /></td>
		</tr>
		<tr>
			<td>&nbsp</td>
			<td><span ng-show="myForm.$dirty && myForm.confirmPassword.$error.pattern" class="cont">*Confirmer Nouvelle Mot de passe doit être numerique</span>
			<span ng-show="myForm.$dirty && myForm.confirmPassword.$error.required" class="cont">*Confirmer Nouvelle Mot de passe ne doit pas être vide</span></td>
		</tr>
	</table>
	<input type="submit" value="Submit" ng-disabled="myForm.$invalid" class="btn btn-primary btn-sm" />
	<button type="button" ng-click="reset()" class="btn btn-warning btn-sm">Réinitialiser</button>
</form>
<br/>
<label ng-class="class" ng-bind="answer"></label>