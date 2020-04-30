<%@page import="ruay.model.cart.CartModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    if(session.getAttribute("memberLogin") != null) { 
    	int cartItem = 0;
    	if(session.getAttribute("cartList") != null) {
    		ArrayList<CartModel> cartList = (ArrayList<CartModel>)session.getAttribute("cartList");
    		cartItem = cartList.size();
    	} 
    	
    %>
	<hr />
	<a href="${pageContext.request.contextPath}/">Home</a> |
	<a href="${pageContext.request.contextPath}/logout">Logout</a> |
	<a href="${pageContext.request.contextPath}/about">About</a> |
	<a href="${pageContext.request.contextPath}/member/home">Member</a> |
	<a href="${pageContext.request.contextPath}/product/home">All Product</a> |
	<a href="${pageContext.request.contextPath}/cart/home">Cart</a>(<%=cartItem %>) |
	<hr />
	<% } else {%>
	<hr />
	<a href="${pageContext.request.contextPath}/">Home</a> |
	<a href="${pageContext.request.contextPath}/login">Login</a> |
	<a href="${pageContext.request.contextPath}/about">About</a> |
	<hr />
	
	<% }%>