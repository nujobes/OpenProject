<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link
	href="https://fonts.googleapis.com/css?family=Kaushan+Script|Nanum+Gothic|Nanum+Myeongjo|Yeon+Sung"
	rel="stylesheet">
<title>Open Project</title>
<!-- CDN 추가 -->
<script src="https://code.jquery.com/jquery-1.10.0.js"></script>
</head>
<body>
	<h1 class="title">
		<span class="color1">Op</span><span class="color2">en</span><span
			class="color3"> pro</span><span class="color4">je</span><span
			class="color5">ct</span>
	</h1>
	<ul id="gnb">
		<!-- global navigation bar-->
		<li><a href="${pageContext.request.contextPath}">메인</a></li>
		<li><a href="${pageContext.request.contextPath}/member/memberReg">회원가입</a></li>
		<c:choose>
			<c:when test="${empty sessionScope.loginInfo}">
				<li><a href="${pageContext.request.contextPath}/member/login">로그인</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${pageContext.request.contextPath}/member/logout">로그아웃</a></li>
			</c:otherwise>
		</c:choose>
		<li><a href="${pageContext.request.contextPath}/member/myPage">마이페이지</a></li>
		<li><a
			href="${pageContext.request.contextPath}/member/memberList">회원리스트</a></li>
		<li><a href="${pageContext.request.contextPath}/guestbook/list">방명록</a></li>
	</ul>