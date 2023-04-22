<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록하기</title>
</head>
<%@ include file="includes/header.jsp" %>
<body>
	<fieldset>
		<legend>회원가입</legend>
		<form action="regist" method="POST" enctype="multipart/form-data">
			<label for="userId">아이디</label>
			<input type="text" name="userId" id="userId">
			<label for="userPass">비밀번호</label>
			<input type="password" name="userPass" id="userPass">
			<label for="userName">이름</label>
			<input type="text" name="userName" id="userName">
			<label for="file">이미지 등록</label>
			<input type="file" name="file" id="file" accept="image/*">
			<input type="submit" value="회원가입">
		</form>
	</fieldset>

</body>
<script>
	let msg = "${msg }";
	if(msg) {
		alert(msg);
	}
</script>

</html>