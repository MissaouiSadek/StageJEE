<h1>Beneficiaires</h1>
<br/>
<br/>
<br/>
<form class="form-inline">
        <div class="form-group">
            <label >Recherche</label>
            <input type="text" ng-model="search" class="form-control" placeholder="Rechercher">
        </div>
</form>
<br/>
<select ng-model="nombre">
	<option value=5>5</option>
	<option value=10>10</option>
	<option value=20>20</option>
	<option value=50>50</option>
	<option value=100>100</option>
</select>
<div class="table-responsive">
	<table class="table table-striped table-bordered">
	<thead>
		<tr>
			<th ng-click="sort('rib')">RIB<span class="glyphicon sort-icon" ng-show="sortKey=='rib'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('nom')">Code Beneficiaire<span class="glyphicon sort-icon" ng-show="sortKey=='nom'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('prenom')">Password<span class="glyphicon sort-icon" ng-show="sortKey=='prenom'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('statut')">Date de creation<span class="glyphicon sort-icon" ng-show="sortKey=='statut'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th colspan=2>Options</th>
		</tr>
	</thead>
	<tbody>
		<tr dir-paginate="beneficiaire in beneficiaires|orderBy:sortKey:reverse|filter:search|itemsPerPage:nombre">

			<td>{{ beneficiaire.rib }}</td>
			<td>{{ beneficiaire.nom }}</td>
			<td>{{ beneficiaire.prenom }}</td>
			<td>{{ beneficiaire.statut }}</td>
			<td><button ng-click="editBeneficiaire(beneficiaire)" class="btn btn-success custom-width"><span class="fa fa-pencil"></span></button></td> 
			<td><button ng-click="deleteBeneficiaire(beneficiaire)" class="btn btn-danger custom-width"><span class="fa fa-trash"></span></button></td>
		</tr>
	</tbody>
	</table>
	<dir-pagination-controls template-url="paginationTemplate" max-size="10" direction-links="true" boundary-links="true" ></dir-pagination-controls>
</div>
<br/>
<div class="formcontainer">
	<form ng-submit="submitBeneficiaire()" name="myForm" class="form-horizontal" novalidate>
		<table>
			<tr>
				<td>RIB</td>
				<td><input type="text" name="rib" ng-model="beneficiaireForm.rib" class="form-control" required /></td>
				<td><span ng-show="myForm.$dirty && myForm.rib.$error.required">RIB ne doit pas etre vide</span></td>
			</tr>
			<tr>
				<td>Nom</td>
				<td><input type="text" name="nom" ng-model="beneficiaireForm.nom" class="form-control" required /></td>
				<td><span ng-show="myForm.$dirty && myForm.nom.$error.required">Nom ne doit pas etre vide</span></td>
			</tr>
			<tr>
				<td>Prenom</td>
				<td><input type="text" name="prenom" ng-model="beneficiaireForm.prenom" class="form-control" required /></td>
				<td><span ng-show="myForm.$dirty && myForm.prenom.$error.required">Prenom ne doit pas etre vide</span></td>
			</tr>
			<tr>
				<td>Statut</td>
				<td><select name="statut" ng-model="beneficiaireForm.statut" class="form-control" required >
					<option value="Valide">Valide</option>
					<option value="Invalide">Invalide</option>
				</select></td>
				<td><span ng-show="myForm.$dirty && myForm.statut.$error.required">Statut ne doit pas etre vide</span></td>
			</tr>
			<tr><td>&nbsp</td></tr>
			<tr>
				<td><input type="submit" value="Add/Edit" ng-disabled="myForm.$invalid" class="btn btn-primary btn-sm" />
				<button type="button" ng-click="reset()" class="btn btn-warning btn-sm">Réinitialiser</button></td>
			</tr>
		</table>
	</form>
</div>