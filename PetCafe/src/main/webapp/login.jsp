<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/petcafe/view/header_2.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PetCafe-login</title>
<style>
	#contents {
		text-align:letf
	}
</style>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<body>
<div div class="container text-center">
	<form method="post" action="send_login.jsp"><!--만들어야됨-->
	<label>아이디</label> 
	<input type="text" name="id" size="20"><br>
	<label>비밀번호</label>
	<input type="password" name="password" size="50"><br>
	</form>
	<button type="submit" class="btn btn-outline-secondary">로그인</button>
	<br>
	<button type="button" class="btn btn-outline-secondary">회원가입</button>
	<button type="button" class="btn btn-outline-secondary">비밀번호 찾기</button>
</div>

</body>
</html>