<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<h2>login Form</h2>
	<form action="<%=request.getContextPath()%>/LoginController" method="post">
		<table border="1">
			<tr>
				<td>ID</td>
				<td><input type="text" name="ID"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="text" name="PW"></td>
			</tr>
		</table>
		<div>
			<a href="<%=request.getContextPath()%>/IndexController">
				<button type="button">취소</button>
			</a>
			<input type="submit" value="로그인">
		</div>
	</form>
</body>
</html>