<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<h1>Testing Homepage</h1>
	<div class="row center" style="float: none; margin: 0 auto;">
		<div class="flip-container" c:forEach var="game" items="${listGames}">
			<div class="flipper">
				<div class="front">
					<a href="#"> <img class="img-fluid img-thumbnail"
						src='{{game.gamePicture}}' />
					</a>
				</div>
				<div class="back">
					<div class="bg-dark mystyle text-center py-3">
						<span>{{game.gameName}}</span><br>
						<button href="#" class="button">See More</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>