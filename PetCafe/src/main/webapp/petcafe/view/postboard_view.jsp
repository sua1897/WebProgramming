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
		<div class="input-group mb-3">
  			<div class="input-group mb-3">
  				<button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">검색옵션</button>
  				<ul class="dropdown-menu">
    				<li><a class="dropdown-item" href="#">제목</a></li>
    				<li><a class="dropdown-item" href="#">내용</a></li>
    				<li><a class="dropdown-item" href="#">작성자</a></li>
    			</ul>
  				<input type="text" class="form-control" aria-label="Text input with dropdown button">
  				<button class="btn btn-outline-secondary" type="submit" id="search_btn">검색</button>
			</div>
		</div>
		</form>
		</div>
		<div class="col-md-auto">
		<!-- 글쓰기 버튼 -->
		<button class="btn btn-outline-secondary" type="button" id="post_write_btn">글쓰기</button>
		</div>
		</div>
		<!-- 게시글 목록 -->
			<div class="list-group list-group-flush">
  				<a href="#" class="list-group-item list-group-item-action">게시글 제목 / 작성자 / 좋아요</a>
  				<a href="#" class="list-group-item list-group-item-action">게시글 제목 / 작성자 / 좋아요</a>
  				<a href="#" class="list-group-item list-group-item-action">게시글 제목 / 작성자 / 좋아요</a>
  				<a href="#" class="list-group-item list-group-item-action">게시글 제목 / 작성자 / 좋아요</a>
  				<a href="#" class="list-group-item list-group-item-action">게시글 제목 / 작성자 / 좋아요</a>
  				<a href="#" class="list-group-item list-group-item-action">게시글 제목 / 작성자 / 좋아요</a>
  				<a href="#" class="list-group-item list-group-item-action">게시글 제목 / 작성자 / 좋아요</a>
  				<a href="#" class="list-group-item list-group-item-action">게시글 제목 / 작성자 / 좋아요</a>
  				<a href="#" class="list-group-item list-group-item-action">게시글 제목 / 작성자 / 좋아요</a>
  				<a href="#" class="list-group-item list-group-item-action">게시글 제목 / 작성자 / 좋아요</a>
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