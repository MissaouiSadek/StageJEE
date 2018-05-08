<h1>Beneficiaires</h1>
<form class="form-inline">
        <div class="form-group">
            <label >Recherche</label>
            <input type="text" ng-model="search" class="form-control" placeholder="Search">
        </div>
</form>
<br/>
<div class="table-responsive">
	<table class="table table-striped table-bordered">
	<thead>
		<tr>
			<th ng-click="sort('rib')">RIB<span class="glyphicon sort-icon" ng-show="sortKey=='rib'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('nom')">nom<span class="glyphicon sort-icon" ng-show="sortKey=='nom'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('prenom')">prenom<span class="glyphicon sort-icon" ng-show="sortKey=='prenom'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
		</tr>
	</thead>
	<tbody>
		<tr dir-paginate="beneficiaire in beneficiaires|orderBy:sortKey:reverse|filter:search|itemsPerPage:10">

			<td>{{ beneficiaire.rib }}</td>
			<td>{{ beneficiaire.nom }}</td>
			<td>{{ beneficiaire.prenom }}</td>
		</tr>
	</tbody>
	</table>
	<dir-pagination-controls max-size="10" direction-links="true" boundary-links="true" ></dir-pagination-controls>
</div>