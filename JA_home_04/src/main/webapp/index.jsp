<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log in page</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>	
	
	<form action ="LogIn" method="post">
		
		<label for="userName">login</label>
			<input name="userName">			
		<label for="password">password</label>
			<input name="password">
		<input type="submit" value="log in">	
			
	</form>
	
	<br>
	
	<form action ="registration" method="get">	
		<input type="submit" value="registration">
	</form>
	
	<br><br>
	
	<jsp:include page="footer.jsp"></jsp:include>
	
	
	
</body>
</html>