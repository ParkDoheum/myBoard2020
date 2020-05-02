<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필</title>
<link rel="stylesheet" type="text/css" href="/css/common.css" />
</head>
<body>
	<div class="flexContainer flexCenter" style="flex-direction:column;">
		<div>프로필 이미지 display</div>
		<div>
			<form id="frm" action="profileDetail" 
				method="post" onsubmit="return chkProfile()" 
				enctype="multipart/form-data">
				<label>수정 이미지: <input type="file" name="profileImg" accept="image/*"></label>
				<div>
					<input type="submit" value="업로드">
				</div>
			</form>
		</div>
	</div>
	<script>
		function chkProfile() {
			if(frm.profileImg.value == '') {
				alert('이미지를 선택해 주세요')
				return false
			}
		}
	</script>
</body>
</html>