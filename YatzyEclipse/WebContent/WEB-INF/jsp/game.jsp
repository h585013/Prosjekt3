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
<!-- @include file="css/game.css" -->
<!-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/game.css" />-->
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
						<th>${s.navn}</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Enere</th>
					<c:forEach items="${runde.spillere}" var="s">
						<th>0</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Toere</th>
					<c:forEach items="${runde.spillere}" var="s">
						<th>0</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Treere</th>
					<c:forEach items="${runde.spillere}" var="s">
						<th>0</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Firere</th>
					<c:forEach items="${runde.spillere}" var="s">
						<th>0</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Femmere</th>
					<c:forEach items="${runde.spillere}" var="s">
						<th>0</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Seksere</th>
					<c:forEach items="${runde.spillere}" var="s">
						<th>0</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Sum</th>
					<c:forEach items="${runde.spillere}" var="s">
						<th>0</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Bonus</th>
					<c:forEach items="${runde.spillere}" var="s">
						<th>0</th>
					</c:forEach>
				</tr>
				<tr>
					<th>1 par</th>
					<c:forEach items="${runde.spillere}" var="s">
						<th>0</th>
					</c:forEach>
				</tr>
				<tr>
					<th>2 par</th>
					<c:forEach items="${runde.spillere}" var="s">
						<th>0</th>
					</c:forEach>
				</tr>
				<tr>
					<th>3 like</th>
					<c:forEach items="${runde.spillere}" var="s">
						<th>0</th>
					</c:forEach>
				</tr>
				<tr>
					<th>4 like</th>
					<c:forEach items="${runde.spillere}" var="s">
						<th>0</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Liten straight</th>
					<c:forEach items="${runde.spillere}" var="s">
						<th>0</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Stor straight</th>
					<c:forEach items="${runde.spillere}" var="s">
						<th>0</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Hus</th>
					<c:forEach items="${runde.spillere}" var="s">
						<th>0</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Sjanse</th>
					<c:forEach items="${runde.spillere}" var="s">
						<th>0</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Yatzy</th>
					<c:forEach items="${runde.spillere}" var="s">
						<th>0</th>
					</c:forEach>
				</tr>
				<tr>
					<th>Totalsum</th>
					<c:forEach items="${runde.spillere}" var="s">
						<th>0</th>
					</c:forEach>
				</tr>
			</table>
		</div>

		<!-- Spiller X sin tur -->
		<div class="item spillertur">
			<p>${runde.currPlayer.navn} sin tur!</p>
		</div>



		<c:choose>
			<c:when test="${vinner eq null}">
				<!-- Terningene -->
				<div class="item terningTrill">
					<form action="game" method="post">
						<div class="item terninger">
							<c:choose>
							<c:when test="${runde.terninger eq null}">
								<c:forEach var="i" begin="1" end="5">
									<div>
									<input type="checkbox" name="${t}"/>
									<img src="https://upload.wikimedia.org/wikipedia/commons/c/c5/Dice-0.png" height="50" width="50" />
									</div>
								</c:forEach>
							</c:when>
							<c:otherwise>
							<c:forEach var="t" items="${runde.terninger}" varStatus="count">
								<div>
								<input type="checkbox" name="${count.index}"/>${t.tall}
								<!-- <img src="t${t.tall}.png" height="50" width="50" /> -->
								<!-- <input type="checkbox" class="check_box" id="checkbox1" /> -->
								<!-- <label for="checkbox1"/> -->
								</div>
							</c:forEach>
							</c:otherwise>
							</c:choose>
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
				<div class="item vinnertekst"></div>

				<!-- Nytt spill knappen -->
				<div class="item nyttSpill"></div>
			</c:otherwise>
		</c:choose>

	</div>
</body>
</html>