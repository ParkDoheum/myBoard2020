<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<style>
	img {
		width: 20px;
	}
	table { 
		border: 1px solid #000;
		border-collapse: collapse;
		width: 80%;
	}
	
	th, td { border: 1px solid #000; }
	.fontCenter { text-align: center; }
	.pointer { 	cursor: pointer; }
	.trSelected:hover { background-color: #ecf0f1 }
</style>
</head>
<body>
	<div>
		${ loginUser.u_nickname }님 환영합니다.
		<a href="/boardRegmod">
			<button>글쓰기</button>
		</a>
		<a href="/profileDetail">
			<button>프로필</button>
		</a>
	</div>
	<div>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>조회수</th>
				<th>작성일</th>
				<th>작성자</th>
			</tr>
			
			<c:forEach var="vo" items="${list}">
			<tr class="pointer trSelected" onclick="moveToDetail(${vo.i_board}, ${vo.hits})">
				<td class="fontCenter">${vo.i_board }</td>
				<td>${vo.title }</td>
				<td class="fontCenter">${vo.hits }</td>
				<td class="fontCenter">${vo.r_dt }</td>
				<td class="fontCenter">
					
					${vo.u_nickname }
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<script>
		function moveToDetail(i_board, hits) {
			location.href = '/boardDetail?i_board=' + i_board + '&hits=' + hits
		}
	</script>
</body>
</html>





