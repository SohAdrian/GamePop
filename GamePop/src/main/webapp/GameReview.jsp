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
	
		Username: <input type="text" name="username"><br>
		
		Rate the Game:
		
		<select name="rating">
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>
			<option>5</option>
			
		</select><br>
		
		Comments: <input type="text" name="comment">
		
		<input type="submit">
	</form>
</body>
</html>