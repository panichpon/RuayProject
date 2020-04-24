<%@page import="ruay.model.TbMemberModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Member</title>
<%
TbMemberModel tbmModel = (TbMemberModel)request.getAttribute("tbmModel");
%>
</head>
<body>
	<h2>Welcome to Ruay Project [Update Member]</h2>
	<hr />
	<a href="${pageContext.request.contextPath}/">Home</a> |
	<a href="${pageContext.request.contextPath}/about">About</a>
	<hr />
	<h2>FORM1 UPDATE</h2>
	<form action="${pageContext.request.contextPath}/update" method="POST">
		<label for="fname">First name:</label><br>
	  	<input type="text" id="fname" name="fname" value="<%=tbmModel.getName()%>"><br>
	  	<label for="lname">Last name:</label><br>
	  	<input type="text" id="lname" name="lname" value="<%=tbmModel.getSurname()%>"><br>
	  	<label for="lname">Gender: [<%=tbmModel.getGender() %>]</label><br>
	  	<input type="radio" id="male" name="gender" value="M">
	  	<label for="male">Male</label><br>
	  	<input type="radio" id="female" name="gender" value="F">
	  	<label for="female">Female</label><br>
	  	<input type="radio" id="other" name="gender" value="O">
	  	<label for="other">Other</label><br>
	  	<br>
	  	<input type="hidden" name="id" value="<%=tbmModel.getId()%>">
	  	<input type="submit" value="Update">
	</form> 
	<hr />
</body>
</html>