<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>

	<h1>Login</h1>

	<br>
	<br>
	<form action="login" method="post">
		<fieldset>
			<legend>Login</legend>

			<label for="brukernavn">Brukernavn:</label><br> <input
				type="text" id="brukernavn" name="brukernavn"><br> <label
				for="passord">Passord:</label><br> <input type="password"
				id="passord" name="passord"><br>

			<p>
				<input type="submit" value="Login" />
			</p>
		</fieldset>
	</form>
	
	<br>
	<br>
	<form action="registrer" method="get">
		<input type="submit" value="Registrer deg!">
	</form>
</body>
</html>