<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<form action="Forside" method="post">
  <fieldset>
    <legend>Velg handling</legend>
 <input type="radio"  name="handling" value="lagSpill" checked>
<label for="lagSpill">Lag Spill</label><br>
<input type="radio"  name="handling" value="deltaSpill">
<label for="deltaSpill">Delta i Spill</label><br>

<p><input type="submit" value="Registrer" /></p>
  </fieldset>
</form>
</body>
</html>
