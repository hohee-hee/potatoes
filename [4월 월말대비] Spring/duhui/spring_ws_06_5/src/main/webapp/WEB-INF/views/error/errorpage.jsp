<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 페이지</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty msg }">
			<h1>에러가 발생했습니다.</h1>		
		</c:when>
		<c:otherwise>
			<h1>${msg } 에러가 발생했습니다.</h1>
		</c:otherwise>
	</c:choose>
	
	<a href="home">홈으로 돌아가기</a>
</body>
</html>