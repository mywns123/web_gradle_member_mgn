<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<form action="../memberUpdateList" method="get">
	<table>
		<tr>
			<td><label for="id">아이디 :</label>
				<input type="text" name="id" id=:id value="<%=request.getParameter("id")%>"></td>	
		</tr>		
		<tr>
			<td><label for="name">이름 : </label>
				<input type="text" name="name" id="name" value="<%=request.getParameter("name")%>"></td>
		</tr>
		<tr>
			<td><label for="age">나이 : </label>
				<input type="text" name="age" id="age" value="<%=request.getParameter("age")%>"></td>
		</tr>
		<tr>
			<td><label for="gender1">성별 : </label>
				<input type="radio" name="gender" value="남" checked id="gender1"/>남자
				<input type="radio" name="gender" value="여" checked id="gender2"/>여자</td>
		</tr>
		<tr>
			<td><label for="email">이메일 주소 : </label>
				<input type="text" name="email" id="email" value="<%=request.getParameter("email")%>"></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="회원 정보 수정">
			<input type="reset" value="다시 작성">
				<!-- <a href="javascript:memberUpdateList.submit()">회원 정보 수정</a>&nbsp;&nbsp;
				<a href="javascript:memberUpdateList.reset()">다시 작성</a> -->
			</td>
		</tr>		
	</table>
	</form>
</body>
</html>