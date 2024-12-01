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
	
	<h2>게시판 정보</h2>[<a href="/petcafe/postboardControl">새로고침</a>]
	<hr>
	<table border="1">
		<tr><th>이름</th></tr>
		<c:forEach items="${postboards}" var="pb">
			<tr>
				<td>${pb.name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>