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
	<nav id="header" class="navbar navbar-expand-sm ">
		<div class="container-fluid">
			<div class="navbar-header">
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse1">
					<ul class="nav navbar-nav">
						<li><a>Games Review</a></li>
						<li><a>Guides</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>

	<h1>GamePop Home Page</h1>
	<div class="row center" style="float: none; margin: 0 auto;">
		<div class="card" c:forEach var="game" items="${listGames}">
			<a href="#"> <img class="img-fluid img-thumbnail"
				src='c:out value="${game.gamePicture}"' />
			</a>
			<div>
				<p>c:out value="${game.gameName}"</p>
				<br>
				<button class="button" href="<%=request.getContextPath()%>/GameReview.jsp">SeeReview</button>
			</div>
		</div>
	</div>
</body>
</html>