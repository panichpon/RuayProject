<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h2>LOGIN FORM1</h2>
	<jsp:include page="/include/menu.jsp"></jsp:include>
	
	<form action="${pageContext.request.contextPath}/login_auth" method="POST">
		<label for="username">Username:</label><br>
	  	<input type="text" name="username" value=""><br>
	  	<label for="passwords">Password:</label><br>
	  	<input type="password" name="password" value=""><br>
	  	<br>
	  	<input type="submit" value="Submit">
	</form> 
	<hr />
</body>
</html>