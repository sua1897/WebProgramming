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
	<%@ include file="../view/header_2.jsp" %>
	
	<h2>로그인</h2>
	<hr>
	
	<form method="post" action="/petcafe/memberControl?action=login">
		<label>아이디</label>
		<input type="text" name="id"><br>
		<label>비밀번호</label>
		<input type="text" name="password"><br>
		<button type="submit">로그인</button>
	</form>
</body>
</html>