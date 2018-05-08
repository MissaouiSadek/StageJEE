<%@ page isELIgnored="false"%>
<script src='resources/js/jquery.plugin.min.js'></script>
<script src='resources/js/jquery.keypad.js'></script>
<link rel='stylesheet' href='resources/css/jquery.keypad.css'></link>
<script>
	$(function() {
		$('#defaultKeypad').keypad();
	});
</script>
<md-dialog><md-dialog-content>
<br/>
<form class='form-inline' ng-submit='submitPassword()' name='myForm2'>
        <div class='form-group'>
            <label>Mot de passe</label>
            <input type='password' name='password' pattern='[0-9]*'	class='form-control' id='defaultKeypad' required />
        </div>
        <br/>
        <div class='form-group'>
			<input type='submit' value='submit' class='btn btn-primary btn-sm'  />
		</div>
</form>
<label ng-bind="reponse2"></label>
<br/>
</md-dialog-content></md-dialog>