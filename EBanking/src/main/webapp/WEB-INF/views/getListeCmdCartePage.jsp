<%@ page isELIgnored="false"%>
<h1>Liste Commandes Ch�quier</h1>
<div ng-init="init('${idClient}')"></div>
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
			<th ng-click="sort('statut')">statut<span class="glyphicon sort-icon" ng-show="sortKey=='statut'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('type')">type<span class="glyphicon sort-icon" ng-show="sortKey=='type'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
		</tr>
	</thead>
	<tbody>
		<tr dir-paginate="cmdCarte in cmdsChequier |orderBy:sortKey:reverse|filter:search|itemsPerPage:10">

			<td>{{ cmdCarte.compte.rib }}</td>
			<td>{{ cmdCarte.statut }}</td>
			<td>{{ cmdCarte.type }}</td>
		</tr>
	</tbody>
	</table>
	<dir-pagination-controls max-size="10" direction-links="true" boundary-links="true" ></dir-pagination-controls>
</div>