<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록 결과</title>
</head>
<body>
	<h3>${user.userId }</h3>
	<h3>${user.userName }</h3>
	
	<h1>가 입 완 료</h1>
	
	<img src="./resources/upload/${user.img }">
	<a href="download?fileName=${user.img }">${user.orgImg } 다운로드</a>
</body>
</html>