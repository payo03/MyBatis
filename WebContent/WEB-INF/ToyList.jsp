<%@page import="java.util.ArrayList"%>
<%@page import="domain.Toy"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<Toy> toyList = (ArrayList<Toy>)request.getAttribute("ToyList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/included/list.jsp" /><br>
<table border="1" align="center" width="50%">
	<thead>
		<tr>
			<td> ToyNo </td>
			<td> ToyName </td>
			<td> ShopName </td>
			<td> ShopLocation </td>
			<td> Order </td>
		</tr>
	</thead>
	<tbody>
<%	for(int i=0; i<toyList.size(); i++) { %>
		<tr>
			<td> <%= toyList.get(i).getToyNo() %></td>
			<td> <%= toyList.get(i).getToyName() %></td>
<%			for(int j=0; j<toyList.get(i).getShops().size(); j++) { %>
<%				String shopName = toyList.get(i).getShops().get(j).getShopName(); 
				String shopLocation = toyList.get(i).getShops().get(j).getShopLocation() ;%>
				<td rowspan="<%= toyList.get(i).getShops().size()%>"> 
					<%= shopName %></td>
				<td rowspan="<%= toyList.get(i).getShops().size()%>"> 
					<%= shopLocation %></td>
				<td>
					<form action="${pageContext.request.contextPath }/From/UpdateOrder" method="post" > 
						<input type="hidden" name="toyNo" value="<%= toyList.get(i).getToyNo() %>" />
						<input type="hidden" name="shopNo" value="<%= toyList.get(i).getShops().get(j).getShopNo() %>" />
						<input type="submit" name="update" value="수정" />
						<input type="submit" name="order" value="주문" />
					</form>
				</td>
<%			} %>
		</tr>
<%	} %>
	</tbody>
</table>
<div align="center">
	<input type="text" name="shopLocation" placeholder="ShopLocation">
	<input type="submit" value="검색">
</div>
</body>
</html>