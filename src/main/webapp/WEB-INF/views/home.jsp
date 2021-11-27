<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>[ 메인 페이지 ]</h1>
<c:if test="${login_info != null }">
<h2>${login_info.name }님(${login_info.id }) 환영합니다.</h2>
<div><a href="logout">로그아웃</a></div>
</c:if>
<c:if test="${login_info == null }">
<div><a href="joinForm">회원가입</a></div>
<div><a href="loginForm">로그인</a></div>
</c:if>
<div></div>
</body>
</html>
