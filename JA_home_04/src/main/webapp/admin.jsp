<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin page</title>
</head>
<body>

	<h1>Welcome to the cabinet admin</h1>
	
	<h3>${addStatus}</h3>
	
	<form action ="admin" method="post">
		
		<label>Enter new magazine</label>			
			<br><br>
		<label for="name">name</label>
			<input name="name">
			<br><br>
			
		<label for="description">description</label>
		
		<textarea name="description" rows="4" cols="50">
		</textarea>
			
			<br><br>
			
		<label for="price">price</label>
			<input name="price">
			<br><br>
		<label for="isbn">isbn</label>
			<input name="isbn">			
			<br><br>
		<input type="submit" value="add magazine">	
			
	</form>

</body>
</html>