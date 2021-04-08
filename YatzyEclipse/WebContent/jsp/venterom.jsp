<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<header>
    <title>Venterom</title>
   <script src="js/venterom.js"></script>
    <link rel="stylesheet" type="text/css" href="css/venterom.css">
</header>
<body>
   <!-- <script>window.setInterval('refresh()', 3000); </script>   -->
    <div class="navbar">
        <a class="active" href="#">EXIT</a>
        <a class="active" href="#" onclick="location.reload();" style="z-index: 3;">REFRESH</a>
    </div>
    <div class="terning">
        <img style="width: 5%; height: auto; left: 33%; position: absolute; top: 12px; z-index: 1" src="css/vippng.com-white-dice-png-986406.png">
        <img style="width: 5%; height: auto; right: 34%; position: absolute; top: 12px; z-index: 1;" src="css/vippng.com-white-dice-png-986406.png">
    </div>
    <div class="myDiv">
        <h1>Y  A  T  Z  Y</h1>
    </div>
    <div class="animasjon">
        <h3>Waiting for players</h3>
    </div>
    <div class="grid-container">
    <c:forEach items="${spillerListe}" var="s">
    	<div>${s.brukernavn}</div>
    </c:forEach>
</div>
    <form>
</form> 
<button class="button" value="START">START</button>
</body>
</html> 