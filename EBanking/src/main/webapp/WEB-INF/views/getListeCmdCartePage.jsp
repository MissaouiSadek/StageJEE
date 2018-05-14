<%@ page isELIgnored="false"%>
<h1>Liste Commandes Carte</h1>
<div ng-init="init('${idClient}')"></div>
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
			<th ng-click="sort('rib')">RIB<span class="glyphicon sort-icon" ng-show="sortKey=='rib'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('statut')">statut<span class="glyphicon sort-icon" ng-show="sortKey=='statut'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('type')">type<span class="glyphicon sort-icon" ng-show="sortKey=='type'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
		</tr>
	</thead>
	<tbody>
		<tr dir-paginate="cmdCarte in cmdsChequier |orderBy:sortKey:reverse|filter:search|itemsPerPage:nombre">

			<td>{{ cmdCarte.compte.rib }}</td>
			<td>{{ cmdCarte.statut }}</td>
			<td>{{ cmdCarte.type }}</td>
		</tr>
	</tbody>
	</table>
	<dir-pagination-controls template-url="paginationTemplate" max-size="10" direction-links="true" boundary-links="true" ></dir-pagination-controls>
</div>