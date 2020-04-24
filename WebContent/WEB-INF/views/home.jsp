<%@page import="ruay.model.TbMemberModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ruay Home page</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
<%
	@SuppressWarnings("unchecked")
	ArrayList<TbMemberModel> tbmMemberList = (ArrayList<TbMemberModel>)request.getAttribute("tbmMemberList"); 
%>
</head>
<body>
	<h2>Welcome to Ruay Project</h2>
	<hr />
	<a href="${pageContext.request.contextPath}/">Home</a> |
	<a href="${pageContext.request.contextPath}/about">About</a>
	<hr />
	<h2>FORM1</h2>
	<form action="${pageContext.request.contextPath}/register" method="POST">
		<label for="fname">First name:</label><br>
	  	<input type="text" id="fname" name="fname" value=""><br>
	  	<label for="lname">Last name:</label><br>
	  	<input type="text" id="lname" name="lname" value=""><br>
	  	<label for="lname">Gender:</label><br>
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
	<table>
		<tr>
	    	<th>ID#</th>
	    	<th>NAME</th>
	    	<th>SURNAME</th>
	    	<th>GENDER</th>
	    	<th>REGISTER DATE</th>
	    	<th>UPDATE | DELETE</th>
	  	</tr>
	  	<%
	  		for (int i = 0; i < tbmMemberList.size(); i++) {
	  			TbMemberModel tbmModel = tbmMemberList.get(i);
	  	%>
	  	<tr>
	  		<td><%=tbmModel.getId() %></td>
	    	<td><%=tbmModel.getName() %></td>
	    	<td><%=tbmModel.getSurname() %></td>
	    	<td><%=tbmModel.getGender() %></td>
	    	<td><%=tbmModel.getTimeReg() %></td>
	    	<td>
	    		<a href="${pageContext.request.contextPath}/update_member?id=<%=tbmModel.getId()%>">UPDATE</a> | 
	    		<a href="${pageContext.request.contextPath}/delete?id=<%=tbmModel.getId()%>">DELETE</a>
	    	</td>
		</tr>
		<% 	} %>
	</table>
	<hr />
</body>
</html>