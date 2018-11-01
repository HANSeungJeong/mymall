<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index</h1>
		<c:if test="${loginMember != null}">
		<c:if test="${loginMember.level==0}">
			${loginMember.id} 관리자님 이 들어왔습니다. <br>
			<a href="${pageContext.request.contextPath}/LogoutController">LogOut</a>
		</c:if>
		<c:if test="${loginMember.level==1}">
		${loginMember.id} 고객분 께서 들어왔습니다. <br>
		<a href="${pageContext.request.contextPath}/LogoutController">LogOut</a>
		</c:if>
		<c:if test="${loginMember.level==null}">
		<a href="${pageContext.request.contextPath}/LoginController">Login</a>
		<a href="${pageContext.request.contextPath}/AddmemberController">AddMember</a>
		</c:if>
	</c:if>

</body>
</html>