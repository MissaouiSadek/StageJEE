<h1>Virements</h1>
<br/>
<div class="formcontainer">
<form ng-submit="submitRecherche()" name="myForm2" class="form-vertical" novalidate>
<table>
<tr>
<td>Trouver par : </td><td><select class="form-control"  ng-model="recherche">
				<option value="aucun">Aucun</option>
				<option value="date">Date</option>
			</select></td>
<td><input class="form-control" name="date1" ng-show="recherche=='date'" ng-model="date1" placeholder="yyyy-MM-dd" ng-pattern="/^(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))$/" ng-required="recherche=='date'"></td>
<td><input class="form-control" name="date2" ng-show="recherche=='date'" ng-model="date2" placeholder="yyyy-MM-dd" ng-pattern="/^(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))$/" ng-required="recherche=='date'"></td>
<td><input type="submit" value="Submit" ng-disabled="myForm2.$invalid" class="btn btn-primary btn-sm" /></td>
</tr>
</table>
</form>
</div>
<br/>
<br/>
<br/>
<form class="form-inline container">
        <div class="form-group">
            <label>Recherche&nbsp</label>
            <input type="text" ng-model="search" class="form-control" placeholder="Search">
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
			<th ng-click="sort('ribexpediteur')">RIBexpediteur<span class="glyphicon sort-icon" ng-show="sortKey=='ribexpediteur'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('ribdestinataire')">RIBdestinataire<span class="glyphicon sort-icon" ng-show="sortKey=='ribdestinataire'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('montant')">montant<span class="glyphicon sort-icon" ng-show="sortKey=='montant'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('statut')">statut<span class="glyphicon sort-icon" ng-show="sortKey=='statut'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('motif')">motif<span class="glyphicon sort-icon" ng-show="sortKey=='motif'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('nomDestinataire')">nom Destinataire<span class="glyphicon sort-icon" ng-show="sortKey=='nomDestinataire'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('prenomDestinataire')">prenom Destinataire<span class="glyphicon sort-icon" ng-show="sortKey=='prenomDestinataire'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('type')">type<span class="glyphicon sort-icon" ng-show="sortKey=='type'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('dateVirement')">date Virement<span class="glyphicon sort-icon" ng-show="sortKey=='dateVirement'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
		</tr>
	</thead>
	<tbody>
		<tr dir-paginate="virement in virements|orderBy:sortKey:reverse|filter:search|itemsPerPage:nombre">

			<td>{{ virement.ribexpediteur }}</td>
			<td>{{ virement.ribdestinataire }}</td>
			<td>{{ virement.montant }}Dt</td>
			<td>{{ virement.statut }}</td>
			<td>{{ virement.motif }}</td>
			<td>{{ virement.nomDestinataire }}</td>
			<td>{{ virement.prenomDestinataire }}</td>
			<td>{{ virement.typeVirement }}</td>
			<td>{{ virement.dateVirement }}</td>
			<td><button ng-click="confirmerVirement(virement)" ng-show="virement.statut=='non confirme'" class="btn btn-success custom-width"><span class="fa fa-check"></span></button>
			<button ng-click="annulerVirement(virement)" ng-show="virement.statut=='confirme'" class="btn btn-danger custom-width"><span class="fa fa-close"></span></button></td>
		</tr>
	</tbody>
	</table>
	<dir-pagination-controls template-url="paginationTemplate" max-size="10" direction-links="true" boundary-links="true" ></dir-pagination-controls>
</div>