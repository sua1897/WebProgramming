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
			
	    </div>
	</div>
	
</body>
</html>