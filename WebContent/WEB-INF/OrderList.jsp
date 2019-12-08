<%@page import="vo.Toy"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Order> orderList = (ArrayList<Order>)request.getAttribute("OrderList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/included/list.jsp" /><br>
<form action="" method="post">
<table border="1" align="center" width="50%">
	<thead>
		<tr>
			<td> ToyNo </td>
			<td> CustomerName</td>
			<td> ToyName</td>
			<td> ShopName</td>
			<td> OrderDate</td>
		</tr>
	</thead>
	<tbody>
<%		for(int i=0; i<orderList.size(); i++) { %>
		<tr>
			<td> <%= orderList.get(i).getToyNo() %> </td>
			<td> <%= orderList.get(i).getCustomerName() %></td>
			<td> 
				<%= orderList.get(i).getToy().getToyName() %>
				<a href="${pageContext.request.contextPath }/From/Cancel?toyNo=<%= orderList.get(i).getToyNo()%>&shopNo=<%= orderList.get(i).getShopNo() %>">주문 취소</a>
			</td>
			<td> <%= orderList.get(i).getShop().getShopName() %></td>
			<td> <%= orderList.get(i).getOrderDate() %> </td>
		</tr>
<%		} %>
	</tbody>
</table>
</form>
</body>
</html>