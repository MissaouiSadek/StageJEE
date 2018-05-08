<%@ page isELIgnored="false"%>
<h4>Créer un virement interbancaire</h4>
<div ng-init="init('${idClient}')"></div>
<form ng-submit="submitVirement($event)" name="myForm" class="form-horizontal" novalidate>
	<table>
			<tr>
				<td>RIB Expéditeur</td>
				<td><select name="RIBexpediteur" ng-model="ribexpediteur" ng-options="compte.rib for compte in comptes" class="form-control" required ></select></td>
				<td>Solde :{{ribexpediteur.solde}} DT</td>
			</tr>
			<tr>
				<td>RIB Destinataire(Beneficiaire)</td>
				<td><select name="ribdestinataire" ng-model="ribdestinataire" ng-options="beneficiaire.rib for beneficiaire in beneficiaires" class="form-control" required ></select></td>
			</tr>
			<tr>
				<td>nom destinataire</td>
				<td><input type="text" name="nom" ng-model="ribdestinataire.nom" class="form-control" readonly required ></td>
			</tr>
			<tr>
				<td>prenom destinataire</td>
				<td><input type="text" name="prenom" ng-model="ribdestinataire.prenom" class="form-control" readonly required /></td>
			</tr>
			<tr>
				<td>montant</td>
				<td><input type="number" name="montant" ng-model="VirementForm.montant" class="form-control" inputmode="numeric" ng-min=0 ng-max=ribexpediteur.solde required /></td>
			</tr>
			<tr>
				<td>motif</td>
				<td><input type="text" name="motif" ng-model="VirementForm.motif" class="form-control" required /></td>
			</tr>
			<tr>
			<td><input type="submit" value="Submit" ng-disabled="myForm.$invalid" class="btn btn-primary btn-sm" />
			<button type="button" ng-click="reset()" class="btn btn-warning btn-sm">Réinitialiser Form</button></td>
		</tr>
	</table>
	<label ng-bind="reponse"></label>
</form>