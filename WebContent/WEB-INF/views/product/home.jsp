<%@page import="ruay.model.TbStockModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
	@SuppressWarnings("unchecked")
	ArrayList<TbStockModel> tbStockList = (ArrayList<TbStockModel>)request.getAttribute("stockList"); 
%>
</head>
<body>
	<h2>Welcome to Ruay Project [PRODUCT]</h2>
	<jsp:include page="/include/menu.jsp"></jsp:include>
	
	
	<form action="${pageContext.request.contextPath}/cart/add_cart" method="POST">
		<table>
			<tr>
		    	<th>ID#</th>
		    	<th>P NAME#</th>
		    	<th>UNITPRICE</th>
		    	<th>QUANTITY</th>
		    	<th>AMOUNT</th>
		  	</tr>
		  	<%
		  		for (int i = 0; i < tbStockList.size(); i++) {
		  			TbStockModel stockModel = tbStockList.get(i);
		  	%>
		  	<tr>
		  		<td><%=stockModel.getId() %></td>
		    	<td><%=stockModel.getGood().getName() %></td>
		    	<td><%=stockModel.getGood().getUnitPrice() %></td>
		    	<td><%=stockModel.getQuantity() %></td>
		    	<td>
		    		<input type="hidden" name="stockId" value="<%=stockModel.getId() %>">
		    		<input type="hidden" name="goodId" value="<%=stockModel.getGood().getId() %>">
					<select id="num" name="qty">
						<option value="0" selected="selected">0</option>
					    <option value="1">1</option>
					    <option value="2">2</option>
					    <option value="3">3</option>
					    <option value="4">4</option>
					    <option value="5">5</option>
				    </select>
				</td>
			</tr>
			<% 	} %>
		</table>
		<input type="submit" value="Add Cart">
	</form>
	<hr />
	
</body>
</html>