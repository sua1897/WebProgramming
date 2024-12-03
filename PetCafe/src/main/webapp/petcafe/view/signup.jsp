<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/petcafe/view/header_2.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PetCafe-signup</title>
<style>
	body {
		text-align:center;
	}
</style>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<body>
<div div class="container text-center"><!--수평 중간 정렬 -->
	<form method="post" action="send_db_signup.jsp"><!--만들어야됨-->
		<label>아이디</label> 
		<input type="text" name="id" size="20">
		<button type="button" class="btn btn-outline-secondary">중복 확인</button><br>
		<label>비밀번호</label> 
		<input type="password" name="password" size="50"><br>
		<label>비밀번호 확인</label> 
		<input type="password" name="password_check" size="50"><br>
		<label>닉네임</label> 
		<input type="text" name="name" size="20">
		<button type="button" class="btn btn-outline-secondary">중복 확인</button><br>
		<label>비밀번호 찾기용 질문</label>
		<input type="text" name="pw_question" size="100"><br>
		<label>비밀번호 찾기용 답변</label>
		<input type="text" name="pw_answer" size="30"><br>
	</form>
	<button type="submit" class="btn btn-outline-secondary">회원가입</button>
</div>
</body>
</html>