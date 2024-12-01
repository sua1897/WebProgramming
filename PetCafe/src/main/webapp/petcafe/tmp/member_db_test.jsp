<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>DB 테스트</title>
</head>
<body>
	<%@ include file="../view/header_1.jsp" %>
	
	<h2>회원 정보</h2>[<a href="/petcafe/memberControl">새로고침</a>]
	<hr>
	<table border="1">
		<tr><th>아이디</th><th>비밀번호</th><th>닉네임</th><th>비밀번호 찾기 질문</th><th>비밀번호 찾기 답변</th></tr>
		<c:forEach items="${members}" var="mem">
			<tr>
				<td>${mem.id}</td>
				<td>${mem.password}</td>
				<td>${mem.name}</td>
				<td>${mem.pw_question}</td>
				<td>${mem.pw_answer}</td>
			</tr>
		</c:forEach>
	</table>
	
	<form method="post" action="/petcafe/memberControl?action=insert">
		<label>아이디</label>
		<input type="text" name="id"><br>
		<label>비밀번호</label>
		<input type="text" name="password"><br>
		<label>닉네임</label>
		<input type="text" name="name"><br>
		<label>비밀번호 찾기 질문</label>
		<input type="text" name="pw_question"><br>
		<label>비밀번호 찾기 답변</label>
		<input type="text" name="pw_answer"><br>
		<button type="submit">가입</button>
	</form>
</body>
</html>