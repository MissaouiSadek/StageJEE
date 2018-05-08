<%@ page isELIgnored="false"%>
<div ng-init="init('${idClient}')"></div>
<h4>Cr�er un virement intrabancaire</h4>
<form ng-submit="submitVirement($event)" name="myForm" class="form-horizontal"
	novalidate>
	<table>
		<tr>
			<td>RIB Exp�diteur</td>
			<td><select name="RIBexpediteur" ng-model="ribexpediteur"
				ng-options="compte.rib for compte in comptes" class="form-control"
				required></select></td>
			<td>Solde :{{ribexpediteur.solde}} DT</td>
		</tr>
		<tr>
			<td>RIBdestinataire</td>
			<td><select name="RIBdestinataire" ng-model="ribdestinataire"
				ng-options="compte.rib for compte in comptes |filter :'!'+ribexpediteur.rib" class="form-control"
				required ng-disabled="+ribexpediteur.rib==''"></select></td>
			<td>Solde :{{ribdestinataire.solde}} DT</td>
		</tr>
		<tr>
			<td>montant</td>
			<td><input type="number" name="montant"
				ng-model="VirementForm.montant" class="form-control"
				inputmode="numeric" ng-min=0 ng-max=ribexpediteur.solde required /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit"
				ng-disabled="myForm.$invalid" class="btn btn-primary btn-sm" />
				<button type="button" ng-click="reset()"
					class="btn btn-warning btn-sm">R�initialiser Form</button></td>
		</tr>
	</table>
	<label ng-bind="reponse"></label>
</form>