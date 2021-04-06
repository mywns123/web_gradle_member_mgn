<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="id" value="${sessionScope.id}"/>

<c:if test="${id eq null}">
	<c:redirect url="loginForm.jsp"/>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<form name="logout" action="../logoutServlet" method="get">
	<h3>${id}로 로그인 하셨습니다.</h3>
	<c:if test="${id eq 'admin'}">
		<a href = "/web_gradle_member_mgn/memberList">관리자 모드 접속(회원 목록 보기)</a>
	</c:if>
	<a href="javascript:logout.submit()">로그아웃</a>
	</form>
</body>
</html>