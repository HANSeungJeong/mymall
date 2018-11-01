<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addMember.jsp</title>
</head>
<body>
	<h1>addMember Form</h1>
	<form action="<%=request.getContextPath()%>/AddMemberController" method="post">
		<table border="1">
			<tr>
				<td>ID</td>
				<td><input type="text" name="ID"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="text" name="PW"></td>
			</tr>
			<tr>
				<td>LEVEL</td>
				<td>
					<input type="radio">
					<lavel>고객</lavel>
					<lavel>관리자</lavel>
				</td>
			</tr>
		</table>
		
		<div>
			<a href="<%=request.getContextPath()%>/IndexController">
				<button type="button">취소</button>
			</a>
			<input type="submit" value="회원가입">
		</div>
	
	
	
	</form>
</body>
</html>