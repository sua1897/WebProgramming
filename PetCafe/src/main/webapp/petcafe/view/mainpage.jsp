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
	<% session.removeAttribute("now_pb"); %>

	<%@ include file="header_1.jsp" %>
	
	<div class="container text-center">
  	<div class="row">
  		<!-- 좌측 사이드바 -->
    	<div class="col-md-auto">
    		<%@ include file="sidebar.jsp" %>
    	</div>
    	<!-- 게시판 메뉴 1 -->
    	<div class="col">
    		<div class="container text-center">
    		<!-- 상단 메뉴 -->
  			<div class="row">
    			<div class="col">
    				<p class="text-center fs-4 fw-semibold">자유 게시판</p>
    			</div>
    			<div class="col-md-auto">
    				<button type="button" class="btn" onclick="document.location.href='/petcafe/postControl?action=listByPb&option=free'">더보기</button>
   				</div>
   			</div>
   			<!-- 게시글 목록 -->
   			<div class="row">
   				<div class="col">
   					<div class="list-group list-group-flush">
   						<c:forEach items="${posts_free}" var="post_free">
   					
  						<a href="/petcafe/postControl?action=postView&option=${post_free.post_idx}" class="list-group-item list-group-item-action">${post_free.title}</a>
  						
  						</c:forEach>
  					</div>
   				</div>
   			</div>
   			</div>
   		</div>
   		<!-- 게시판 메뉴 2 -->
   		<div class="col">
   			<div class="container text-center">
      		<!-- 상단 메뉴 -->
  			<div class="row">
    			<div class="col">
    				<p class="text-center fs-4 fw-semibold">질문 게시판</p>
    			</div>
    			<div class="col-md-auto">
    				<button type="button" class="btn" onclick="document.location.href='/petcafe/postControl?action=listByPb&option=ask'">더보기</button>
   				</div>
   			</div>
   			<!-- 게시글 목록 -->
   			<div class="row">
   				<div class="col">
   					<div class="list-group list-group-flush">
  						<c:forEach items="${posts_ask}" var="post_ask">
   					
  						<a href="/petcafe/postControl?action=postView&option=${post_ask.post_idx}" class="list-group-item list-group-item-action">${post_ask.title}</a>
  						
  						</c:forEach>
  					</div>
   				</div>
   			</div>
   			</div>
   		</div>
   	</div>
  	</div>
</body>
</html>