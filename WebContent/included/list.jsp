<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="vo.Customer"%>   
<%
	Customer customer = (Customer)session.getAttribute("Customer");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<a href="${pageContext.request.contextPath }/From/Main">Main</a>&nbsp&nbsp&nbsp
	<a href="${pageContext.request.contextPath }/From/ShopList">ShopList</a>&nbsp&nbsp&nbsp
	<a href="${pageContext.request.contextPath }/From/ToyList">ToyList</a>&nbsp&nbsp&nbsp
	<a href="${pageContext.request.contextPath }/From/OrderList">OrderList</a>&nbsp&nbsp&nbsp
	<a href="${pageContext.request.contextPath }/From/ToyList">List</a>
	<div align="right">
		<%= customer.getCustomerName() %>회원님!&nbsp <a href="${pageContext.request.contextPath }/From/Logout">로그아웃</a>
	</div>
</div>
</body>
</html>