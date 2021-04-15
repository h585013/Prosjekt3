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
	<br>
	<br>
	<br>
	<form action="registrer" method="post">
		<fieldset>
			<legend>Registrering</legend>



			<label for="brukernavn">Brukernavn:</label><br> <input
				type="text" id="brukernavn" name="brukernavn"><br> <label
				for="epost">Epost:</label><br> <input type="text" id="epost"
				name="epost"> <label for="passord">Passord:</label><br>
			<input type="password" id="passord" name="passord"><br>

			<label for="passwordRepeat">Repeter passord:</label><br> <input
				type="password" id="passwordRepeat" name="passwordRepeat">


			<p>
				<input type="submit" value="Registrer" />
			</p>
		</fieldset>
	</form>


	<br>
	<br>
	<br>
	<br>
	<br>
	<form action="login" method="get">
		<input type="submit" value="Jeg har allerede en bruker!">
	</form>
</body>
</html>