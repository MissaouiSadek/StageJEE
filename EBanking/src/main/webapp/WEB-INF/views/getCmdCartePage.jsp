<%@ page isELIgnored="false"%>
<div ng-init="init('${idClient}')"></div>
<h4>Créer commande carte</h4>
<form ng-submit="submitCmd()" name="myForm" class="form-horizontal" novalidate>
	<table>
			<tr>
				<td>Compte</td>
				<td><select name="rib" ng-model="rib" ng-options="compte.rib for compte in comptes" class="form-control" required></select></td>
			</tr>
			<tr>
				<td>type</td>
				<td><select ng-model="cmdCarteForm.type" name="type" class="form-control" required>
					<option value="Gold">Gold</option>
					<option value="Platinum">Platinum</option>
					<option value="Premier">Premier</option>
				</select></td>
			</tr>
	</table>
	<input type="submit" value="Submit" ng-disabled="myForm.$invalid" class="btn btn-primary btn-sm" />
	<button type="button" ng-click="reset()" class="btn btn-warning btn-sm">Réinitialiser Form</button>
</form>
<br/>
<label ng-show="reponse=='Commande carte ajoutee'" class="msg" ng-bind="reponse"></label>