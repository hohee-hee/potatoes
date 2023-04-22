<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.header {
	display: flex;
	justify-content: space-between;
}

#user-info {
	line-height: 87px;
}

form {
	margin: 0;
}
</style>

<h1>게시판 관리</h1>
<c:choose>
    <c:when test="${empty sessionScope.loginUser}">
        <form method="POST" action="login">
            <input type="text" name="userId" placeholder="아이디"> 
            <input type="password" name="userPass" placeholder="비밀번호"> 
            <input type="submit" value="로그인">
        </form>
    </c:when>
    <c:otherwise>
        <div>${sessionScope.loginUser.userName} 님 환영합니다. <a href="logout">로그아웃</a></div>
    </c:otherwise>
</c:choose>

<hr>
<script>
	let msg = "${msg }";
	if (msg) {
		alert(msg)
	}
</script>