<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>PetCafe</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<% String now_pb = (String)session.getAttribute("now_pb");
	if (now_pb == null) {
		now_pb = "";
	}
%>

<div class="d-grid gap-2">
	<% if (now_pb.equals("all")) { %>
  <button type="button" class="btn active" data-bs-toggle="button" aria-pressed="true" onclick="document.location.href='/petcafe/postControl?action=listByPb&option=all'">전체 게시글</button>
  	<% } else { %>
  <button type="button" class="btn" data-bs-toggle="button" onclick="document.location.href='/petcafe/postControl?action=listByPb&option=all'">전체 게시글</button>
  	<% } %>
  	
  	<% if (now_pb.equals("free")) { %>
  <button type="button" class="btn active" data-bs-toggle="button" aria-pressed="true" onclick="document.location.href='/petcafe/postControl?action=listByPb&option=free'">자유 게시판</button>
	<% } else { %>  
  	<button type="button" class="btn" data-bs-toggle="button" onclick="document.location.href='/petcafe/postControl?action=listByPb&option=free'">자유 게시판</button>
  	<% } %>
  	
  	<% if (now_pb.equals("ask")) { %>
  <button type="button" class="btn active" data-bs-toggle="button" aria-pressed="true" onclick="document.location.href='/petcafe/postControl?action=listByPb&option=ask'">질문 게시판</button>
  	<% } else { %>
  <button type="button" class="btn" data-bs-toggle="button" onclick="document.location.href='/petcafe/postControl?action=listByPb&option=ask'">질문 게시판</button>
  	<% } %>
  
  	<% String mem_id = (String)session.getAttribute("mem_id");
  		if (mem_id != null) { %>
  	<% if (now_pb.equals("bookmark")) { %>
  <button type="button" class="btn active" data-bs-toggle="button" aria-pressed="true" onclick="document.location.href='/petcafe/postControl?action=listByBk&option=all'">북마크 게시글</button>
  	<% } else { %>
  <button type="button" class="btn" data-bs-toggle="button" onclick="document.location.href='/petcafe/postControl?action=listByBk&option=all'">북마크 게시글</button>
  	<% } %>
  	<% } %>
  
</div>
</body>
</html>