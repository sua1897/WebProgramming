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
			
			<div id="my_comment" class="row">
				<div class="col">
			    	<div class="comment">
				        댓글 내용 <!-- 댓글 내용 보이는 코드 추가해야함 -->
				    </div>
			    </div>
			</div>
			
		</div>
	</div>
	
</body>
</html>