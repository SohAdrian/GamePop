<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ReviewServlet" method="post">

		Username: <input type="text" name="username"><br> Rate
		the Game: <select type="number" name="rating">
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>
			<option>5</option>

		</select><br> Comments: <input type="text" name="comment"> <input
			type="submit">
	</form>
	<div class="container" c:forEach var="review" items="${listReviews}">
		<div class="card" c:forEach var="gameName == review.gameName">
			<div>
				<p>
					<b>Posted by <c:out value="${review.username}"/></b>
				</p>
			</div>
			<div>
				<p><c:out value="${review.rating}"/></p>
				<p><c:out value="${review.comment}"/></p>
			</div>
			<div>
				<button class="button">Edit</button>
				<button class="button">Delete</button>
			</div>
		</div>
	</div>
</body>
</html>