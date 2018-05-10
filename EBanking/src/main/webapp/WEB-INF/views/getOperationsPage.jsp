<h1>Operations</h1>
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
			<th ng-click="sort('description')">Description<span class="glyphicon sort-icon" ng-show="sortKey=='description'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('valeur')">Valeur<span class="glyphicon sort-icon" ng-show="sortKey=='valeur'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('dateOperation')">Date<span class="glyphicon sort-icon" ng-show="sortKey=='dateOperation'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
		</tr>
	</thead>
	<tbody>
		<tr dir-paginate="operation in operations|orderBy:sortKey:reverse|filter:search|itemsPerPage:nombre">
			<td>{{ operation.description }}</td>
			<td ng-style="(operation.valeur < 0 && {'color':'red'})||(operation.valeur > 0 && {'color':'green'})">{{ operation.valeur }}Dt</td>
			<td>{{ operation.dateOperation }}</td>
		</tr>
	</tbody>
	</table>
	<dir-pagination-controls template-url="paginationTemplate" max-size="10" direction-links="true" boundary-links="true" ></dir-pagination-controls>
</div>