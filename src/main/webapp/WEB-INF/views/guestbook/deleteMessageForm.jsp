<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/common/header.jsp"></jsp:include>
<div id="contents">
	<c:if test="${!empty msg}">
		<span class="msg redMsg">${msg}</span>
	</c:if>
	<c:if test="${!empty idx}">
		<h2>비밀번호를 입력해 주세요.</h2>
		<hr>
		<form method="post">
			<input type="hidden" value="${idx}" name="idx"><input
				type="password" name="inputPassword"> <input type="submit"
				value="삭제">
		</form>
	</c:if>
</div>
<jsp:include page="/resources/common/footer.jsp"></jsp:include>