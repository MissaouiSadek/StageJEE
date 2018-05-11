<%@ page isELIgnored="false"%>
<br/>
<form class='form-inline' ng-submit='submitCode()' name='myForm3'>
        <div class='form-group'>
            <label>Code Validation</label>
            <input ng-model="code" type='password' name='password'	class='form-control' required />
        </div>
        <br/>
        <div class='form-group'>
			<input type='submit' value='submit' class='btn btn-primary btn-sm'  />
		</div>
</form>
<label style="color : red" ng-bind="reponse3"></label>
<br/>