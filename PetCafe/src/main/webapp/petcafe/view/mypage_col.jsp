<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PetCafe-mypage-col</title>
<style>
	.button_container {
		display: grid; 
        grid-auto-flow: column; /* 가로로 배치 */
        gap: 50px; /* 버튼 간격 */
        margin: 50px 50px;

	}
</style>
</head>
<body>
	
	<div class="button_container"><!-- onclick 구현 필요 -->
		<button type="button" class="btn btn-outline-secondary">내가 쓴 글</button>
		<button type="button" class="btn btn-outline-secondary">내가 쓴 댓글</button>
		<button type="button" class="btn btn-outline-secondary">내 게시글에 달린 댓글</button>
		<button type="button" class="btn btn-outline-secondary">개인정보 변경</button>
	</div>

</body>
</html>