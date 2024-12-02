<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/petcafe/view/header_1.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PetCafe-mypage</title>
<style>
		.container {
            display: flex; /* Flexbox 활성화 */
        }
        .comment{
        	background:yellow;
        }
        .box {
            padding: 20px;
            text-align: center;
            font-size: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        
        p {
        	color:red;
        	text-align:left;
        }
        .title {flex: 3; /* 3 비율 */}
        .writer {flex: 1; /* 1 비율 */}
        .like {flex: 1; /* 1 비율 */}
</style>
</head>
<body>
	<div class="row">
		<div class="col-md-auto">
	    	<%@ include file="/petcafe/view/sidebar.jsp" %>
	    </div>
	    <div class="col">
	    	<div class="row">
				<div class="col">
			    	<%@ include file="/petcafe/view/mypage_col.jsp" %>
			    </div>
			</div>
			<div id="my_post" class="row">
				<div class="col">
			    	<div class="container">
				        <div class="box title">제목</div>
				        <div class="box writer">작성자</div>
				        <div class="box like">좋아요</div>
				    </div>
			    </div>
			</div>
			<div id="my_comment" class="row">
				<div class="col">
			    	<div class="comment">
				        댓글 내용 <!-- 댓글 내용 보이는 코드 추가해야함 -->
				    </div>
			    </div>
			</div>
			<div id="check_before_change" class="row">
				<div class="col">
			    	본인 확인을 위해 비밀번호를 입력해주세요.
			    	<form method="post" action="check.jsp"><!-- 구현 필요 -->
			    		<label>비밀번호</label>
			    		<input type="text" name="password_for_check" size="50"><br>
			    		<button type="submit" class="btn btn-outline-secondary">다음</button>
			    	</form>
			    </div>
			</div>
			<div id="change_info" class="row">
				<div class="col">
					<p> ◆ 변경하지 않는 정보는 공백으로 남겨주세요</p>
			    	<form method="post" action="send_db_signup.jsp"><!--만들어야됨-->
						<label>비밀번호</label> 
						<input type="password" name="password" size="50"><br>
						<label>비밀번호 확인</label> 
						<input type="password" name="password_check" size="50"><br>
						<label>닉네임</label> 
						<input type="text" name="name" size="20">
						<button type="button" class="btn btn-outline-secondary">닉네임 중복 확인</button><br>
						<label>비밀번호 찾기용 질문</label>
						<input type="text" name="pw_question" size="100"><br>
						<p> ◆ 비밀번호 찾기시 정확한 답변을 입력할 수 있도록 단답형으로 답할 수 있는 질문으로 작성해주세요.</p>
						<label>비밀번호 찾기용 답변</label>
						<input type="text" name="pw_answer" size="30"><br>
						<p> ◆ 비밀번호 찾기시 정확한 답변을 입력할 수 있도록 단답형으로 답변해주세요.</p>
					</form>
					<button type="submit" class="btn btn-outline-secondary">회원가입</button>
			    </div>
			</div>
		</div>
	</div>
	
</body>
</html>