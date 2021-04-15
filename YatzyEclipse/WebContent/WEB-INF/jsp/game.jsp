<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<style>
	<%@include file="../css/game.css"%>
</style>
<title>YATZY!</title>
</head>
<body>

	<!-- Yatzy brettet -->
	<h2>YATZYYYYY!</h2>
	<div class="container">

		<div class="item brett">
			<table>
				<tr>
					<th></th>
					<c:forEach items="${runde.spillere}" var="s">
						<th>${s.brukernavn}</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Enere</th>
					<c:forEach items="${runde.resultat}" var="r">
						<th>${r.enere}</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Toere</th>
					<c:forEach items="${runde.resultat}" var="r">
						<th>${r.toere}</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Treere</th>
					<c:forEach items="${runde.resultat}" var="r">
						<th>${r.treere}</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Firere</th>
					<c:forEach items="${runde.resultat}" var="r">
						<th>${r.firere}</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Femmere</th>
					<c:forEach items="${runde.resultat}" var="r">
						<th>${r.femere}</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Seksere</th>
					<c:forEach items="${runde.resultat}" var="r">
						<th>${r.seksere}</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Sum</th>
					<c:forEach items="${runde.resultat}" var="r">
						<th>${r.sum1}</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Bonus</th>
					<c:forEach items="${runde.resultat}" var="r">
						<th>${r.bonus}</th>
					</c:forEach>
				</tr>
				<tr>
					<th>1 par</th>
					<c:forEach items="${runde.resultat}" var="r">
						<th>${r.etPar}</th>
					</c:forEach>
				</tr>
				<tr>
					<th>2 par</th>
					<c:forEach items="${runde.resultat}" var="r">
						<th>${r.toPar}</th>
					</c:forEach>
				</tr>
				<tr>
					<th>3 like</th>
					<c:forEach items="${runde.resultat}" var="r">
						<th>${r.treLike}</th>
					</c:forEach>
				</tr>
				<tr>
					<th>4 like</th>
					<c:forEach items="${runde.resultat}" var="r">
						<th>${r.fireLike}</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Liten straight</th>
					<c:forEach items="${runde.resultat}" var="r">
						<th>${r.litenStraight}</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Stor straight</th>
					<c:forEach items="${runde.resultat}" var="r">
						<th>${r.storStraight}</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Hus</th>
					<c:forEach items="${runde.resultat}" var="r">
						<th>${r.hus}</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Sjanse</th>
					<c:forEach items="${runde.resultat}" var="r">
						<th>${r.sjanse}</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Yatzy</th>
					<c:forEach items="${runde.resultat}" var="r">
						<th>${r.yatzy}</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Totalsum</th>
					<c:forEach items="${runde.resultat}" var="r">
						<th>${r.totalSum}</th>
					</c:forEach>
				</tr>
			</table>
		</div>

		<!-- Spiller X sin tur -->
		<div class="item spillertur">
			<p>${runde.currPlayer.brukernavn} sin tur!</p>
		</div>



		<c:choose>
			<c:when test="${vinner eq null}">
				<!-- Terningene -->
				<div class="item terningTrill">
					<form action="YatzySpill" method="post">
						<div class="item terninger">
							<c:forEach var="t" items="${runde.terninger}" varStatus="count">
								<div>
								<input type="checkbox" name="${count.index}"/>${t.tall}
								</div>
							</c:forEach>
						</div>

						<!-- Trill knapp -->
						<div class="item trillTerning">
							<input type="submit" value="Trill" />
						</div>
					</form>
				</div>

				<!-- Du har x trill igjen -->
				<div class="item trill">
					<p>Du har ${3 - runde.tc} trill igjen!</p>
				</div>

				<!-- Marker terningene du vil beholder -->
				<div class="item marker">
					<p>Marker terningene du vil beholde!</p>
				</div>

			</c:when>
			<c:otherwise>
				<!-- Vinnertekst -->
				<div class="item vinnertekst">
					<p>GRATULERER TIL VÅR VINNER ${runde.vinner.brukernavn}</p>
				</div>

				<!-- Nytt spill knappen -->
				<div class="item nyttSpill">
					<input type="submit" value="nyttspill" name="Nytt Spill"/>
				</div>
			</c:otherwise>
		</c:choose>

	</div>
</body>
</html>