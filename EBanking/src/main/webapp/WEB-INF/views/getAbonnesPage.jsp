<h1>Abonnes</h1>
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
<div class="table-responsive">
	<table class="table table-striped table-bordered">
	<thead>
		<tr>
			<th ng-click="sort('idClient')">Id Client<span class="glyphicon sort-icon" ng-show="sortKey=='idClient'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('codeAbonne')">Code Abonne<span class="glyphicon sort-icon" ng-show="sortKey=='codeAbonne'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('passwordAbonne')">Password<span class="glyphicon sort-icon" ng-show="sortKey=='passwordAbonne'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th ng-click="sort('dateCreation')">Date de creation<span class="glyphicon sort-icon" ng-show="sortKey=='dateCreation'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
			<th colspan=3>Options</th>
		</tr>
	</thead>
	<tbody>
		<tr dir-paginate="abonne in abonnes|orderBy:sortKey:reverse|filter:search|itemsPerPage:10">

			<td>{{ abonne.idClient }}</td>
			<td>{{ abonne.codeAbonne }}</td>
			<td>{{ abonne.passwordAbonne }}</td>
			<td>{{ abonne.dateCreation }}</td>
			<td><button ng-click="editAbonne(abonne)" class="btn btn-success custom-width">E</a></button></td> 
			<td><button ng-click="getBenef(abonne.idClient)" class="btn btn-info custom-width">B</a></button></td>
			<td><button ng-click="deleteAbonne(abonne)" class="btn btn-danger custom-width">S</a></button></td>
		</tr>
	</tbody>
	</table>
	<dir-pagination-controls max-size="10" direction-links="true" boundary-links="true" ></dir-pagination-controls>
</div>
<div class="formcontainer">
	<form ng-submit="submitAbonne()" name="myForm" class="form-horizontal" novalidate>
		<table>
			<tr>
				<td>Id Client</td>
				<td><input type="text" name="idClient" ng-model="abonneForm.idClient" class="form-control" required /></td>
				<td><span ng-show="myForm.$dirty && myForm.idClient.$error.required">idClient ne doit pas etre vide</span></td>
			</tr>
			<tr>
				<td>Code Abonne</td>
				<td><input type="text" name="codeAbonne" ng-model="abonneForm.codeAbonne" class="form-control" required /></td>
				<td><span ng-show="myForm.$dirty && myForm.codeAbonne.$error.required">Code Abonne ne doit pas etre vide</span></td>
			</tr>
			<tr>
				<td>Password (Cryptage auto)</td>
				<td><input type="text" name="passwordAbonne" ng-model="abonneForm.passwordAbonne" class="form-control" required /></td>
				<td><span ng-show="myForm.$dirty && myForm.passwordAbonne.$error.required">Password ne doit pas etre vide</span></td>
			</tr>
			<tr>
				<td>Date de Creation</td>
				<td><input type="text" name="dateCreation" ng-model="abonneForm.dateCreation" placeholder="yyyy-MM-dd" ng-pattern="/^(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))$/" class="form-control" required /></td>
				<td><span ng-show="myForm.$dirty && myForm.dateCreation.$error.pattern">Date de Creation doit etre sous format : yyyy-MM-dd</span>
				<span ng-show="myForm.$dirty && myForm.dateCreation.$error.required">Date de Creation ne doit pas etre vide</span></td>
			</tr>
			<tr><td>&nbsp</td></tr>
			<tr>
				<td colspan="3"><input type="submit" value="Add/Edit" ng-disabled="myForm.$invalid" class="btn btn-primary btn-sm" />
				<button type="button" ng-click="reset()" class="btn btn-warning btn-sm">Réinitialiser</button></td>
			</tr>
		</table>
	</form>
</div>