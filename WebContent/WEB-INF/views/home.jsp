<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ruay Home page</title>
</head>
<body>
	<h2>Welcome to Ruay Project</h2>
	<hr />
	<a href="${pageContext.request.contextPath}/">Home</a> |
	<a href="${pageContext.request.contextPath}/about">About</a>
	<hr />
	<h1>FORM1</h1>
	<form action="${pageContext.request.contextPath}/register" method="POST">
		<label for="fname">First name:</label><br>
	  	<input type="text" id="fname" name="fname" value=""><br>
	  	<label for="lname">Last name:</label><br>
	  	<input type="text" id="lname" name="lname" value=""><br>
	  	<label for="lname">Sex:</label><br>
	  	<input type="radio" id="male" name="gender" value="M">
	  	<label for="male">Male</label><br>
	  	<input type="radio" id="female" name="gender" value="F">
	  	<label for="female">Female</label><br>
	  	<input type="radio" id="other" name="gender" value="O">
	  	<label for="other">Other</label><br>
	  	<br>
	  	<input type="submit" value="Submit">
	</form> 
	
	<hr />
	<h1>FORM2</h1>
	<form action="${pageContext.request.contextPath}/register2" method="POST">
		<label for="fname">First name:</label><br>
	  	<input type="text" id="fname" name="fname" value=""><br>
	  	<label for="lname">Last name:</label><br>
	  	<input type="text" id="lname" name="lname" value=""><br>
	  	<label for="lname">N name:</label><br>
	  	<input type="text" id="nname" name="nname" value=""><br>
	  	<label for="lname">Sex:</label><br>
	  	<input type="radio" id="male" name="gender" value="M">
	  	<label for="male">Male</label><br>
	  	<input type="radio" id="female" name="gender" value="F">
	  	<label for="female">Female</label><br>
	  	<input type="radio" id="other" name="gender" value="O">
	  	<label for="other">Other</label><br>
	  	<br>
	  	<input type="submit" value="Submit">
	</form> 
</body>
</html>