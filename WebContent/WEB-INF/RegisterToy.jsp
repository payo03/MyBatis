<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/included/list.jsp" /><br>
<form action="${pageContext.request.contextPath }/From/InsertToy" method="post">
	<table border="1" align="center" width="50%">
		<thead>
			<tr>
				<td> ToyName </td>
				<td> ShopNo </td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td> <input type="text" name="toyName" required> </td>
				<td> <input type="text" name="shopNo" required> </td>
			</tr>
		</tbody>
	</table><br>
	<div align="center">
		<input type="submit" value="장난감 등록" />
	</div>
</form>
</body>
</html>