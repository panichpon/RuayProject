<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%if(session.getAttribute("memberLogin") != null) { %>
	<hr />
	<a href="${pageContext.request.contextPath}/">Home</a> |
	<a href="${pageContext.request.contextPath}/logout">Logout</a> |
	<a href="${pageContext.request.contextPath}/about">About</a> |
	<a href="${pageContext.request.contextPath}/member/home">Member</a> |
	<a href="${pageContext.request.contextPath}/product/home">All Product</a> |
	<hr />
	<% } else {%>
	<hr />
	<a href="${pageContext.request.contextPath}/">Home</a> |
	<a href="${pageContext.request.contextPath}/login">Login</a> |
	<a href="${pageContext.request.contextPath}/about">About</a> |
	<hr />
	
	<% }%>