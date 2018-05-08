<%@ page isELIgnored="false"%>
<div ng-init="init('${idClient}')"></div>
<h4>Mise à jour du client</h4>
<form ng-submit="submitClient()" name="myForm" class="form-horizontal" novalidate>
	<table>
			<tr>
				<td><input type="text" ng-model="clientForm.id" readonly class="form-control" style="display:none" /></td>
			</tr>
			<tr>
				<td>Sexe</td>
				<td><select name="sexe" ng-model="clientForm.sexe" class="form-control" required >
					<option value="M">M</option>
					<option value="F">F</option>
				</select></td>
				<td><span ng-show="myForm.$dirty && myForm.sexe.$error.required">Sexe ne doit pas etre vide</span></td>
			</tr>
			<tr>
				<td>Nom</td>
				<td><input type="text" name="nom" ng-model="clientForm.nom" class="form-control" required /></td>
				<td><span ng-show="myForm.$dirty && myForm.nom.$error.required">Nom ne doit pas etre vide</span></td>
			</tr>
			<tr>
				<td>Prenom</td>
				<td><input type="text" name="prenom" ng-model="clientForm.prenom" class="form-control" required /></td>
				<td><span ng-show="myForm.$dirty && myForm.prenom.$error.required">Prenom ne doit pas etre vide</span></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" ng-model="clientForm.email" class="form-control" name="email" required /></td>              
				<td><span ng-show="myForm.$dirty && myForm.email.$error.required">Email ne doit pas etre vide</span></td>
			</tr>
			<tr>
				<td>DateDeNaissance</td>
				<td><input type="text" name="dateDeNaissance" ng-model="clientForm.dateDeNaissance" placeholder="yyyy-MM-dd" ng-pattern="/^(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))$/" class="form-control" required /></td>
				<td><span ng-show="myForm.$dirty && myForm.dateDeNaissance.$error.pattern">Date de Naissance doit etre sous format : yyyy-MM-dd</span>
				<span ng-show="myForm.$dirty && myForm.dateDeNaissance.$error.required">Date de naissance ne doit pas etre vide</span></td>
			</tr>
			<tr>
				<td>Telephone</td>
				<td><input type="text" name="telephone" ng-model="clientForm.telephone" class="form-control" required /></td>
				<td><span ng-show="myForm.$dirty && myForm.telephone.$error.required">Telephone ne doit pas etre vide</span></td>
			</tr>
		<tr>
			<td><input type="submit" value="Submit" ng-disabled="myForm.$invalid" class="btn btn-primary btn-sm" />
			<button type="button" ng-click="reset()" class="btn btn-warning btn-sm">Réinitialiser</button></td>
		</tr>
	</table>
</form>