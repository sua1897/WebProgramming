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
    		<div class="container text-center">
    			<!-- 수정 및 삭제 버튼 -->
    			<% String now_mem_id = (String)session.getAttribute("mem_id");
    			if (now_mem_id != null) {
    			if (now_mem_id.equals((String)request.getAttribute("now_post_writer_id"))) { %>
  				<div class="row justify-content-end">
    				<div class="col-4">
      					<button type="button" class="btn btn-secondary" onclick="document.location.href='/petcafe/postControl?action=edit'">수정</button>
      					<button type="button" class="btn btn-secondary" onclick="document.location.href='/petcafe/postControl?action=delete'">삭제</button>
    				</div>
    			</div>
    			<% }} %>
    			<!-- 제목 -->
    			<div class="row justify-content-start">
    				<div class="col">
      					<p class="text-start fs-6 fw-semibold">${post.title}</p>
    				</div>
    			</div>
    			<!-- 정보 -->
    			<div class="row justify-content-start">
    				<div class="col-md-auto">
      					<p class="text-center fs-6 fw-semibold">${post.postboard_kr}</p>
    				</div>
    				<div class="col-md-auto">
      					<p class="text-center fs-6 fw-semibold">${post.member_name}</p>
    				</div>
    				<div class="col-md-auto">
      					<p class="text-center fs-6 fw-semibold">${post.post_date}</p>
    				</div>
    			</div>
    			<!-- 내용 -->
    			<div class="row justify-content-start">
    				<div class="col">
    					<p class="text-start fs-6 fw-normal">${post.body}</p>
    				</div>
    			</div>
    			<!-- 좋아요 및 북마크 -->
    			<div class="row">
    				<div class="col-md-auto">
    					<c:choose>
    					<c:when test="${empty mem_id}">
    						<img src="/petcafe/petcafe/img/heart-empty.png" width="30" height="30">
    					</c:when>
    					<c:otherwise>
    						<c:choose>
    						<c:when test="${!is_like_it_checked}">
      						<button type="button" class="btn" onclick="document.location.href='/petcafe/postControl?action=addLike_it'">
    							<img src="/petcafe/petcafe/img/heart-empty.png" width="30" height="30">
    						</button>
    						</c:when>
    						<c:otherwise>
    						<button type="button" class="btn" onclick="document.location.href='/petcafe/postControl?action=deleteLike_it'">
    							<img src="/petcafe/petcafe/img/heart-full.png" width="30" height="30">
    						</button>
    						</c:otherwise>
    						</c:choose>
    					</c:otherwise>
    					</c:choose>
    				</div>
    				<div class="col-md-auto align-self-end">
      					<p class="text-center fs-6 fw-semibold">${like_it_count}</p>
    				</div>
    				<div class="col-4">
    				</div>
    				<div class="col-md-auto">
      					<c:choose>
    					<c:when test="${empty mem_id}">
    						<img src="/petcafe/petcafe/img/bookmark-empty.png" width="30" height="30">
    					</c:when>
    					<c:otherwise>
    						<c:choose>
    						<c:when test="${!is_bookmark_checked}">
      						<button type="button" class="btn" onclick="document.location.href='/petcafe/postControl?action=addBookmark'">
    							<img src="/petcafe/petcafe/img/bookmark-empty.png" width="30" height="30">
    						</button>
    						</c:when>
    						<c:otherwise>
    						<button type="button" class="btn" onclick="document.location.href='/petcafe/postControl?action=deleteBookmark'">
    							<img src="/petcafe/petcafe/img/bookmark-full.png" width="30" height="30">
    						</button>
    						</c:otherwise>
    						</c:choose>
    					</c:otherwise>
    					</c:choose>
    				</div>
    				<div class="col-md-auto align-self-end">
      					<p class="text-center fs-6 fw-semibold">${bookmark_count}</p>
    				</div>
    			</div>
    			<!-- 댓글 작성-->
    			<% if (now_mem_id != null) { %>
    			<form method="post" action="/petcafe/postControl?action=insertReply">
    				<div class="input-group">
  						<span class="input-group-text">댓글</span>
  						<textarea class="form-control" name="body"></textarea>
  						<button class="btn btn-outline-secondary" type="submit">작성</button>
					</div>
    			</form>
    			<% } %>
    			<!-- 댓글 목록 -->
    			
    			<c:forEach items="${replys}" var="reply">
    			
    			<div class="mb-3 row">
    				<label class="col-sm-2 col-form-label">${reply.member_name}</label>
    				<div class="col">
      					<input type="text" readonly class="form-control-plaintext" value="${reply.body}">
      					
      					<c:if test="${mem_id eq reply.member_id}">
      						<button class="btn btn-outline-secondary" type="button" onclick="document.location.href='/petcafe/postControl?action=deleteReply&option=${reply.reply_idx}'">삭제</button>
      					</c:if>
    				</div>
  				</div>
  				
  				</c:forEach>
  				
  				
    		</div>
    	</div>
    </div>
    </div>
</body>