<%@page import="domain.Toy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Toy toy = (Toy)request.getAttribute("Toy");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/included/list.jsp" /><br>
<form action="${pageContext.request.contextPath }/From/UpdateToy" method="post">
	<table border="1" align="center" width="50%">
		<thead>
			<tr>
				<td> ShopNo </td>
				<td> ToyNo </td>
				<td> ToyName </td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td> <input type="hidden" name="shopNo" value="<%= toy.getShopNo() %>"/><%= toy.getShopNo() %> </td>
				<td> <input type="hidden" name="toyNo" value="<%= toy.getToyNo() %>"/><%= toy.getToyNo() %> </td>
				<td> <input type="text" name="toyName" value="<%= toy.getToyName() %>"> </td>
			</tr>
		</tbody>
	</table>
	<div align="center">
		<input type="submit" value="수정" />
	</div>
</form>
</body>
</html>