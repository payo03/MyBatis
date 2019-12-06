<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="domain.Shop" %>
<%@ page import="java.util.ArrayList" %>
<%
	List<Shop> shopList = (ArrayList<Shop>)request.getAttribute("ShopList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/included/list.jsp" /><br>
<form action="${pageContext.request.contextPath }/From/Search" >
	<table border="1" align="center" width="50%">
		<thead>
			<tr>
				<td> ShopNo </td>
				<td> ShopName </td>
				<td> ShopLocation </td>
				<td> ShopStatus </td>
			</tr>
		</thead>
		<tbody>
<%		for(int i=0; i<shopList.size(); i++) { %>
				<tr>
					<td> <%= shopList.get(i).getShopNo() %></td>
					<td> <%= shopList.get(i).getShopName() %></td>
					<td> <%= shopList.get(i).getShopLocation() %></td>
					<td> <%= shopList.get(i).getShopStatus() %></td>
				</tr>
<%		} %>
		</tbody>
	</table>
	<div align="center">
		<input type="text" name="shopLocation" placeholder="ShopLocation">
		<input type="submit" value="검색">
	</div>
</form><br>
<div align="center">
	<a href="${pageContext.request.contextPath }/From/Write">가게 등록</a>&nbsp
</div>
</body>
</html>