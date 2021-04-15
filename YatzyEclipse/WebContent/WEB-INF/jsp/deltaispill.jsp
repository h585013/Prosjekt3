<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delta i Spill</title>
</head>
<body>
	<form action="DeltaISpill" method="post">
		<fieldset>
			<legend>Finn et spill og delta</legend>
			<c:forEach items="${ledigeSpill}" var="s">
				<div><input type="radio" name="${s.spillID}" /> ${s.spillNavn}</div> 
			</c:forEach>
			<input type="submit" value="Delta!"/>
		</fieldset>
	</form>
</body>
</html>