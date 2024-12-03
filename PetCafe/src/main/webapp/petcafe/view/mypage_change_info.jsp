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
			
			<div id="change_info" class="row">
				<div class="col">
					<p> ◆ 변경하지 않는 정보는 공백으로 남겨주세요</p>
					<div class="row">
						<div class="col-md-auto">
							<label>비밀번호</label><br><br>
							<label>비밀번호 확인</label><br> <br>
							<label>닉네임</label> <br><br>
							<label>비밀번호 찾기용 질문</label><br><br><br><br>
							 <label>비밀번호 찾기용 답변</label><br><br>
						</div>
						<div class="col">
							<form method="post" action="send_db_signup.jsp"><!--만들어야됨-->
								<input type="password" name="password" size="50"><br><br>
								
								<input type="password" name="password_check" size="50"><br>
								
								<input type="text" name="name" size="20">
								<button type="button" class="btn btn-outline-secondary">닉네임 중복 확인</button><br><br>
								
								<input type="text" name="pw_question" size="100"><br><br>
								<p> ◆ 비밀번호 찾기시 정확한 답변을 입력할 수 있도록 단답형으로 답할 수 있는 질문으로 작성해주세요.</p>
								
								<input type="text" name="pw_answer" size="30"><br><br>
								<p> ◆ 비밀번호 찾기시 정확한 답변을 입력할 수 있도록 단답형으로 답변해주세요.</p>
							</form>
					</div>
					</div>
					
			    	
					<button type="submit" class="btn btn-outline-secondary">개인정보 변경</button>
			    </div>
			</div>
		</div>
	</div>
	
</body>
</html>