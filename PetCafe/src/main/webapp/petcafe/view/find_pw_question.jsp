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
	
	<form id="check_answer" method="post" action=""><!--만들어야됨-->
		<label>답변</label> <input type="text" name="pw_answer" size="30"><br>
		<button type="submit" class="btn btn-secondary">확인</button>
	</form>
	

</body>
</html>