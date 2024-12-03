<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/petcafe/view/header_2.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PetCafe-findPw1</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<body>
	<textarea id="print_question">비밀번호 찾기용 질문(id 확인후 표시)</textarea>
	<form id="checkid" method="post" action="send_id_findpw.jsp"><!--만들어야됨-->
		<label>아이디</label> <input type="text" name="id" size="20"><br>
		<button type="submit" class="btn btn-secondary">다음</button>
	</form>
	<form id="check_answer" method="post" action="send_findpw.jsp"><!--만들어야됨-->
		<label>답변</label> <input type="text" name="pw_answer" size="30"><br>
		<button type="submit" class="btn btn-secondary">확인</button>
	</form>
	<form id="reset_pw" method="post" action="send_findpw.jsp"><!--만들어야됨-->
		<label>새로운 비밀번호 입력</label> <input type="password" name="password" size="30"><br>
		<label>비밃번호 확인</label> <input type="password" name="password_check" size="30"><br>
		<button type="submit" class="btn btn-secondary">비밀번호 재설정</button>
	</form>

</body>
</html>