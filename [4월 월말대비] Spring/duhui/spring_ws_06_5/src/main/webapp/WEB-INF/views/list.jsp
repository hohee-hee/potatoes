<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록 보기</title>
</head>
<%@ include file="includes/header.jsp" %>
<body>
	<table>
		<thead>
			<tr>
				<td>아이디</td>
				<td>이름</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users }" var="user">
				<tr>
					<td><a href="result?id=${user.userId}">${user.userId }</td>
					<td>${user.userName }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="home">홈으로</a>
</body>
</html>