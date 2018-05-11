<%@ page isELIgnored="false"%>
<div ng-init="init('${idClient}')"></div>
<h4>Comptes</h4>
<form class="form-inline">
        <div class="form-group">
            <label >Recherche</label>
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
			<th ng-click="sort('type')">Type<span class="glyphicon sort-icon" ng-show="sortKey=='type'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('solde')">Solde<span class="glyphicon sort-icon" ng-show="sortKey=='solde'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('dateCreation')">DateCreation<span class="glyphicon sort-icon" ng-show="sortKey=='dateCreation'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
		</tr>
	</thead>
	<tbody>
		<tr dir-paginate="compte in comptes|orderBy:sortKey:reverse|filter:search|itemsPerPage:nombre">

			<td> <a ng-href="#!/operations/{{compte.rib}}"> {{ compte.rib }}</a></td>
			<td>{{ compte.type }}</td>
			<td>{{ compte.solde }}Dt</td>
			<td>{{ compte.dateCreation }}</td>
		</tr>
	</tbody>
	</table>
	<dir-pagination-controls template-url="paginationTemplate" max-size="10" direction-links="true" boundary-links="true" ></dir-pagination-controls>
</div>