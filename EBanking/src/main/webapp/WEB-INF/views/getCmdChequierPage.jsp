<%@ page isELIgnored="false"%>
<div ng-init="init('${idClient}')"></div>
<h4>Cr�er une commande Ch�quier</h4>
<form ng-submit="submitCmd()" name="myForm" class="form-horizontal" novalidate>
	<table>
			<tr>
				<td>Compte</td>
				<td><select name="rib" ng-model="rib" ng-options="compte.rib for compte in comptes" class="form-control" required></select></td>
			</tr>
			<tr>
				<td>nombre</td>
				<td><select ng-model="cmdChequierForm.nombre" name="nombre" class="form-control" required>
					<option value=25>25</option>
					<option value=50>50</option>
					<option value=100>100</option>
				</select></td>
			</tr>
		<tr>
			<td><input type="submit" value="Submit" ng-disabled="myForm.$invalid" class="btn btn-primary btn-sm" />
			<button type="button" ng-click="reset()" class="btn btn-warning btn-sm">R�initialiser Form</button></td>
		</tr>
	</table>
</form>