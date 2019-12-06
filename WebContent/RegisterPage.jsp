<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="included/top.jsp" /><br>
<form action="${pageContext.request.contextPath }/Register" method="post">
	<table border="1" align="center" width="50%">
		<tr>
			<td> ID </td>
			<td> <input type="text" name="id" /> </td>
		</tr>
		<tr>
			<td> PW </td>
			<td> <input type="password" name="pw" /> </td>
		</tr>
		<tr>
			<td> Name </td>
			<td> <input type="text" name="name" /> </td>
		</tr>
		<tr>
			<td colspan="2" align="center"> <input type="submit" value="회원가입" /></td>		
		</tr>
	</table>
</form>
</body>
</html>