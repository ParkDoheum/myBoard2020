<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
<style>
	.commentItem {
		display: flex;
	}
	
	.commentItem .r_dt {
		font-size: 12px;
		color: #95a5a6;
	}
	
	.commentContent {
		width: 500px;
	}
	
	.commentUser {
		display: flex;
		align-items: center;
	}
	
	.circular--portrait {
	  position: relative;
	  width: 50px;
	  height: 50px;
	  overflow: hidden;
	  border-radius: 50%;
	  border: 1px solid #f1f2f6;
	}
	
	.circular--portrait img {
	  width: 100%;
	  height: 100%;	  
	}
</style>
</head>
<body>

	<div>제목: ${detail.title }</div>
	<div>조회수: ${detail.hits }</div>
	<div>작성일시: ${detail.r_dt }</div>
	<div>수정일시: ${detail.m_dt }</div>
	<div>작성자: ${detail.u_nickname }</div>
	<div>내용</div>
	<div>${detail.content }</div>
	<c:if test="${loginUser.i_user == detail.i_user }">
		<div>
			<button>수정</button>
			<button onclick="clkDelBtn(${detail.i_board})">삭제</button>
		</div>
	</c:if>
	
	<div>
		<form action="/boardComment" id="frm" method="post" onsubmit="return chkComment()">
			<input type="hidden" name="i_board" value="${detail.i_board}">
			<textarea rows="3" cols="40" name="content" placeholder="댓글달기"></textarea>
			<input type="submit" value="등록">
		</form>
	</div>
	
	<div>
		<c:forEach var="item" items="${commentList}">
			<div class="commentItem">
				<div class="commentContent">
					<div>${item.content }</div>
					<div class="r_dt">${item.r_dt }</div>
				</div>
				<div class="commentUser">
					<div class="circular--portrait">
						<c:if test="${item.user_img eq null}">
							<img src="/img/noProfile.png" alt="프로필 이미지 없음">
						</c:if>
						<c:if test="${item.user_img != null}">						
							<img src="/img/${item.i_user}/${item.user_img}" alt="프로필 이미지">						
						</c:if>
					</div>
					${item.user_nm }
				</div>
				<div class="commentDel">
					<c:if test="${item.i_user == loginUser.i_user }">
						<a href="/boardComment?i_comment=${item.i_comment}">
							<button>삭제</button>
						</a>
					</c:if>
				</div>
			</div>
		</c:forEach>
	</div>
	
	<script>
		function chkComment() {
			if(frm.content.value.length == 0) {
				alert('댓글 내용을 작성해 주세요!')
				return false
			}
		}
		function clkDelBtn(i_board) {
			var result = confirm(i_board + '번 글을 삭제하시겠습니까?')
			if(result) {
				location.href = '/boardDel?i_board=' + i_board	
			}
		}
		
		var msg = '${msg}'
		
		if(msg != '' && msg != undefined) {
			alert(msg)
		}
	</script>
</body>
</html>





