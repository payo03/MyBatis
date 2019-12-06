<%@page import="java.util.ArrayList"%>
<%@page import="domain.Shop"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	List<Shop> shopList = (ArrayList<Shop>)request.getAttribute("SearchData");
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
				<td> ToyNo </td>
				<td> ToyName </td>
			</tr>
		</thead>
		<tbody>
<%			for(int i=0; i<shopList.size(); i++) { %>
			<tr>
				<td rowspan="<%= shopList.get(i).getToys().size()%>"> 
					<%= shopList.get(i).getShopNo() %></td>
				<td rowspan="<%= shopList.get(i).getToys().size()%>"> 
					<%= shopList.get(i).getShopName() %></td>
				<td rowspan="<%= shopList.get(i).getToys().size()%>"> 
					<%= shopList.get(i).getShopLocation() %> </td>
<% 				for(int j=0; j<shopList.get(i).getToys().size(); j++) { %>
				<td> <%= shopList.get(i).getToys().get(j).getToyNo() %>
				<td> <%= shopList.get(i).getToys().get(j).getToyName() %>
			</tr>
<%				} %>
<%			} %>
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