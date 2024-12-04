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
	
	<form method="post" action="/petcafe/postControl?action=editPost">
  		<div class="row mb-3">
    		<label for="choosePostboard" class="col-sm-2 col-form-label">게시판 선택</label>
    		<!-- 콤보박스 -->
    		<div class="col-md-auto">
    		<div class="mb-3">
    			<select class="form-select" required aria-label="select example" name="postboard">
      				<option value="">게시판 선택</option>
      				<option value="free">자유 게시판</option>
      				<option value="ask">질문 게시판</option>
    			</select>
    		<div class="invalid-feedback">게시판을 선택해주세요.</div>
    		</div>
    		</div>

    	</div>
    	<div class="row mb-3">
    		<label for="chooseAspect" class="col-sm-2 col-form-label">공개범위 선택</label>
    		<!-- 라디오 버튼 -->
    		<div class="col-sm-10">
    			<div class="form-check form-check-inline">
  					<input class="form-check-input" type="radio" name="only_member" value="true" required>
  					<label class="form-check-label" for="inlineRadio1">회원에게만 공개</label>
				</div>
				<div class="form-check form-check-inline">
  					<input class="form-check-input" type="radio" name="only_member" value="false" required>
  					<label class="form-check-label" for="inlineRadio2">비회원에게도 공개</label>
				</div>
    		</div>
    	</div>
    	<div class="row mb-3">
    		<label for="inputTitle" class="col-sm-2 col-form-label">제목</label>
    		<!-- 제목 입력창 -->
    		<div class="col-sm-10">
    			<input type="text" class="form-control" name="title" required value=${ori_post.title}>
    		</div>
    	</div>
    	<div class="row mb-3">
    		<label for="inputBody" class="col-sm-2 col-form-label">내용</label>
    		<!-- 내용 입력창 -->
    		<div class="col-sm-10">
    			<div class="input-group">
  					<textarea class="form-control" name="body" required>${ori_post.body}</textarea>
				</div>
    		</div>
    	</div>
    	
    	<button type="submit" class="btn btn-secondary">게시글 수정</button>
  </form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>