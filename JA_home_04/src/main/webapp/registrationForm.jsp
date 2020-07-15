<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RegistrationForm</title>
</head>
<body>
	
	<form action ="registration" method="post">
		
		<label for="userName">login</label>
			<input name="userName">
			<br><br>
		<label for="password">password</label>
			<input name="password">
			<br><br>
		<label for="firstName">first name</label>
			<input name="firstName">
			<br><br>
		<label for="lastName">last name</label>
			<input name="lastName">			
			<br><br>
		<input type="submit" value="submit">	
			
	</form>
	
</body>
</html>