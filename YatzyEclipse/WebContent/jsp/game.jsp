<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YATZY!</title>
</head>
<body>

<!-- Yatzy brettet -->
<h2>YATZYYYYY!</h2>
<table>
	<tr>
		<th></th>
		<c:forEach items="{$spillere}" var="s">
			<th>${s.navn}</th>
		</c:forEach>
	</tr>
	<tr>
		<th>Enere</th>
	</tr>
	<tr>
		<th>Toere</th>
	</tr>
	<tr>
		<th>Treere</th>
	</tr>
	<tr>
		<th>Firere</th>
	</tr>
	<tr>
		<th>Femmere</th>
	</tr>
	<tr>
		<th>Seksere</th>
	</tr>
	<tr>
		<th>Sum</th>
	</tr>
	<tr>
		<th>Bonus</th>
	</tr>
	<tr>
		<th>1 par</th>
	</tr>
	<tr>
		<th>2 par</th>
	</tr>
	<tr>
		<th>3 like</th>
	</tr>
	<tr>
		<th>4 like</th>
	</tr>
	<tr>
		<th>Liten straight</th>
	</tr>
	<tr>
		<th>Stor straight</th>
	</tr>
	<tr>
		<th>Hus</th>
	</tr>
	<tr>
		<th>Sjanse</th>
	</tr>
	<tr>
		<th>Yatzy</th>
	</tr>
	<tr>
		<th>Totalsum</th>
	</tr>
</table>

<!-- Spiller X sin tur -->
<p> ${currPlayer} sin tur! </p>

<!-- Terningene -->


<!-- Du har x trill igjen -->
<p> Du har ${3 - trillCount} trill igjen!</p>

<!-- Marker terningene du vil beholder -->
<p> Marker terningene du vil beholde! </p>


<c:choose>
	<c:when test="${vinner eq null}"> 
		<!-- Trill knapp -->
		
	</c:when>
	<c:otherwise>
		<!-- Vinnertekst -->

		<!-- Nytt spill knappen -->
	</c:otherwise>
</c:choose>

</body>
</html>