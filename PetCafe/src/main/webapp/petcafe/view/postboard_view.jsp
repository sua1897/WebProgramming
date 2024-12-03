<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>PetCafe</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<%@ include file="header_1.jsp" %>
	
	<div class="container text-center">
  	<div class="row">
  		<!-- 좌측 사이드바 -->
    	<div class="col-md-auto">
    		<%@ include file="sidebar.jsp" %>
    	</div>
    	<div class="col">
    	<div class="row">
    	<div class="col">
		<!-- 검색창 -->
		<form>
		<div class="input-group input-group-sm mb-3">
			<div class="col-md-auto">
    			<select class="form-select" required name="search_option">
      				<option value="">검색 옵션</option>
      				<option value="title">제목</option>
      				<option value="body">내용</option>
      				<option value="writer">작성자</option>
    			</select>
    			<div class="invalid-feedback">검색옵션을 선택해주세요.</div>
    		</div>
  			<input type="text" class="form-control">
  			<button class="btn btn-outline-secondary" type="submit" id="search_btn">검색</button>
		</div>
		</form>
		</div>
		</div>

		<!-- 게시글 목록 -->
			<div class="list-group list-group-flush">
				<c:forEach items="${posts}" var="post">
				
  				<a href="/petcafe/postControl?action=postView&option=${post.post_idx}" class="list-group-item list-group-item-action">${post.title}</a>
  			
  				</c:forEach>
  			</div>
		<!-- 페이지 넘버 -->
		<nav aria-label="Page navigation example">
  			<ul class="pagination justify-content-center">
  	  			<li class="page-item disabled">
      				<a class="page-link" href="#" aria-label="Previous">
        				<span aria-hidden="true">&laquo;</span>
      				</a>
    			</li>
    			<li class="page-item active"><a class="page-link" href="#" aria-current="page">1</a></li>
    			<li class="page-item"><a class="page-link" href="#">2</a></li>
    			<li class="page-item"><a class="page-link" href="#">3</a></li>
    			<li class="page-item">
      				<a class="page-link" href="#" aria-label="Next">
        				<span aria-hidden="true">&raquo;</span>
      				</a>
    			</li>
  			</ul>
</nav>
		</div>
   	</div>
  	</div>
</body>
</html>