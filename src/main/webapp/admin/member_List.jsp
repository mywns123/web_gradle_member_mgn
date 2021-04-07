<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
	<h3>회원 목록</h3>
	<table border="1">
		<thead>
		<tr>
			<td>아이디</td>			
			<td>이름</td>
			<td>나이</td>
			<td>성별 </td>
			<td>이메일주소</td>
			<td>비고</td>
			<td></td>			
		</tr>
		</thead>	
	<tbody>
	<c:forEach var="member" items="${list}">
		<tr>
			<td>${member.id}</td>			
			<td>${member.name}</td>
			<td>${member.age}</td>
			<td>${member.gender} </td>
			<td>${member.email}</td>
			<td ><a href="memberDelList?id=${member.id}">삭제</a></td>
			<td><a href="admin/memberUpdateList.jsp?id=${member.id}&name=${member.name}&age=${member.age}&email=${member.email}">수정하기</a></td>	
		</tr>		
	</c:forEach>
	</tbody>
	<tfoot>
	<tr>
	<td><a href="joinForm.jsp">추가하기</a></td>
	<td><a href = "logoutServlet">로그아웃</a></td>
		
	</tr>
	</tfoot>	
	</table>	
</body>
</html>