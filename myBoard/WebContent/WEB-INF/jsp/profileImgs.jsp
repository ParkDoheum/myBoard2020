<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 리스트</title>
<link href="/css/carousel.css" rel="stylesheet">
<script src="/js/carousel.min.js" type="text/javascript"></script>
<style>
	
</style>
</head>
<body>	
	<div class="carousel" id="carousel-banner">
		<div class="carousel-wrapper">
			<c:forEach var="item" items="${imgList}">
				<div class="carousel-item">
					<img src="/img/${loginUser.i_user}/${item.img}">
				</div>
			</c:forEach>
		</div>
		<div class="navi-wrapper"></div>
	</div>
	
	<script>
	 new Carousel(document.querySelector('#carousel-banner'), {
		    CarouselMotion: 'slide',
		    naviPosition: 'right',
		    naviStyle: 'arrow',
		    autoMove: true,
		    autoMoveTime: 2000
		  });
	</script>
</body>
</html>