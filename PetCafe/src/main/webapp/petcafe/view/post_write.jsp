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
	
	<!-- 수정 폼 -->
	<form>
  		<div class="row mb-3">
    		<label for="choosePostboard" class="col-sm-2 col-form-label">게시판 선택</label>
    		<!-- 콤보박스 -->
    		<div class="col-sm-10">
      			<div class="dropdown">
  					<button class="btn btn-light dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
    				게시판 선택</button>
  					<ul class="dropdown-menu">
    					<li><a class="dropdown-item" href="#">자유 게시판</a></li>
    					<li><a class="dropdown-item" href="#">질문 게시판</a></li>
  					</ul>
				</div>
    		</div>
    	</div>
    	<div class="row mb-3">
    		<label for="chooseAspect" class="col-sm-2 col-form-label">공개범위 선택</label>
    		<!-- 라디오 버튼 -->
    		<div class="col-sm-10">
    			<div class="form-check form-check-inline">
  					<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
  					<label class="form-check-label" for="inlineRadio1">회원에게만 공개</label>
				</div>
				<div class="form-check form-check-inline">
  					<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
  					<label class="form-check-label" for="inlineRadio2">비회원에게도 공개</label>
				</div>
    		</div>
    	</div>
    	<div class="row mb-3">
    		<label for="inputTitle" class="col-sm-2 col-form-label">제목</label>
    		<!-- 제목 입력창 -->
    		<div class="col-sm-10">
    			<input type="text" class="form-control" aria-label="post_title">
    		</div>
    	</div>
    	<div class="row mb-3">
    		<label for="inputBody" class="col-sm-2 col-form-label">내용</label>
    		<!-- 내용 입력창 -->
    		<div class="col-sm-10">
    			<div class="input-group">
  					<textarea class="form-control"></textarea>
				</div>
    		</div>
    	</div>
    	<div class="row mb-3">
    		<label for="inputBody" class="col-sm-2 col-form-label">이미지 업로드</label>
    		<!-- 이미지 업로드 -->
    		<div class="col-sm-10">
    			<div class="input-group mb-3">
  					<input type="file" class="form-control" id="inputImageFile">
				</div>
    		</div>
    	</div>
    	<button type="submit" class="btn btn-secondary">게시글 업로드</button>
  </form>
</body>