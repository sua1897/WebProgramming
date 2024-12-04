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
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
     <a class="navbar-brand" href="/petcafe/postControl?action=listByMain">Home</a>
     
	<% String mem_name = (String)session.getAttribute("mem_name");
	if (mem_name == null) { %>
		<div class="col-md-3 text-end">
        <button type="button" class="btn btn-outline-warning" onclick="document.location.href='/petcafe/petcafe/view/login.jsp'">로그인</button>
      </div>
	<% } else { %>
	<span class="navbar-brand mb-0 h2">안녕하세요, <%=mem_name %>님</span>
     <div class="col-md-3 text-end">
        <button class="btn btn-outline-secondary" type="button" id="post_write_btn" onclick="document.location.href='/petcafe/petcafe/view/post_write.jsp'">글쓰기</button>
        <button type="button" class="btn btn-warning">마이페이지</button>
        <button type="button" class="btn btn-outline-warning" onclick="document.location.href='/petcafe/memberControl?action=logout'">로그아웃</button>
      </div>
     <% } %>
  </div>
</nav>
</body>
</html>