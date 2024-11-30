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
    		<div class="container text-center">
    			<!-- 수정 및 삭제 버튼 -->
  				<div class="row justify-content-end">
    				<div class="col-4">
      					<button type="button" class="btn btn-secondary">수정</button>
      					<button type="button" class="btn btn-secondary">삭제</button>
    				</div>
    			</div>
    			<!-- 제목 -->
    			<div class="row justify-content-start">
    				<div class="col">
      					<p class="text-start fs-6 fw-semibold">제목</p>
    				</div>
    			</div>
    			<!-- 정보 -->
    			<div class="row justify-content-start">
    				<div class="col-md-auto">
      					<p class="text-center fs-6 fw-semibold">게시판 종류</p>
    				</div>
    				<div class="col-md-auto">
      					<p class="text-center fs-6 fw-semibold">작성자</p>
    				</div>
    				<div class="col-md-auto">
      					<p class="text-center fs-6 fw-semibold">작성 날짜</p>
    				</div>
    			</div>
    			<!-- 이미지 -->
    			<div class="row justify-content-start">
    				<div class="col-md-auto">
    					여기에 이미지 표시
    					<!-- <img src="..." class="img-fluid" alt="..."> -->
    				</div>
    			</div>
    			<!-- 내용 -->
    			<div class="row justify-content-start">
    				<div class="col">
    					<p class="text-start fs-6 fw-normal">여기에 내용 표시</p>
    				</div>
    			</div>
    			<!-- 좋아요 및 북마크 -->
    			<div class="row">
    				<div class="col-md-auto">
      					<button type="button" class="btn">
    						<img src="../img/heart-empty.png" width="30" height="30">
    				</button>
    				</div>
    				<div class="col-md-auto align-self-end">
      					<p class="text-center fs-6 fw-semibold">좋아요 수</p>
    				</div>
    				<div class="col-4">
    				</div>
    				<div class="col-md-auto">
      					<button type="button" class="btn">
    						<img src="../img/bookmark-empty.png" width="30" height="30">
    				</button>
    				</div>
    				<div class="col-md-auto align-self-end">
      					<p class="text-center fs-6 fw-semibold">북마크 수</p>
    				</div>
    			</div>
    			<!-- 댓글 작성-->
    			<form>
    				<div class="input-group">
  						<span class="input-group-text">댓글</span>
  						<textarea class="form-control"></textarea>
  						<button class="btn btn-outline-secondary" type="submit" id="reply_submit">작성</button>
					</div>
    			</form>
    			<!-- 댓글 목록 -->
    			<div class="mb-3 row">
    				<label class="col-sm-2 col-form-label">닉네임</label>
    				<div class="col">
      					<input type="text" readonly class="form-control-plaintext" id="reply_view" value="여기에 댓글 표시">
      					<button class="btn btn-outline-secondary" type="button" id="reply_edit">수정</button>
      					<button class="btn btn-outline-secondary" type="button" id="reply_remove">삭제</button>
    				</div>
  				</div>
  				<div class="mb-3 row">
    				<label class="col-sm-2 col-form-label">닉네임</label>
    				<div class="col">
      					<input type="text" readonly class="form-control-plaintext" id="reply_view" value="여기에 댓글 표시">
      					<button class="btn btn-outline-secondary" type="button" id="reply_edit">수정</button>
      					<button class="btn btn-outline-secondary" type="button" id="reply_remove">삭제</button>
    				</div>
  				</div>
  				<div class="mb-3 row">
    				<label class="col-sm-2 col-form-label">닉네임</label>
    				<div class="col">
      					<input type="text" readonly class="form-control-plaintext" id="reply_view" value="여기에 댓글 표시">
    				</div>
  				</div>
    		</div>
    	</div>
    </div>
    </div>
</body>