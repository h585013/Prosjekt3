<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>

	<h1>Registrasjon</h1>

	<br>
	<br>
	<form action="registrer" method="post">
		<fieldset>
			<legend>Registrering</legend>
			
			<label for="brukernavn">Brukernavn:</label><br> 
			<input type="text" id="brukernavn" name="brukernavn"><br> 
			<label for="epost">Epost:</label><br> <input type="text" id="epost" name="epost"><br> 
			<label for="passord">Passord:</label><br>
			<input type="password" id="passord" name="passord"><br>

			<label for="passordRepeat">Repeter passord:</label><br> 
			<input type="password" id="passordRepeat" name="passordRepeat">
			<p>
				<input type="submit" value="Registrer" />
			</p>
		</fieldset>
	</form>


	<br>
	<br>
	<form action="login" method="get">
		<input type="submit" value="Jeg har allerede en bruker!">
	</form>
</body>
</html>