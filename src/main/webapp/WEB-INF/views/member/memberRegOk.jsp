<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/common/header.jsp"></jsp:include>
<div id="contents">
	<h2>회원가입이 완료되었습니다.</h2>
	<hr>
	<table>
		<tr>
			<td>아이디(이메일)</td>
			<td>${mv.userId}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${mv.password}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${mv.userName}</td>
		</tr>
		<tr>
			<td>사진</td>
			<td><c:choose>
					<c:when test="${mv.userPhoto eq 'no-image'}">
						<img
							src="${pageContext.request.contextPath}/resources/images/no-image.png"
							id="memberRegPhoto">
					</c:when>
					<c:otherwise>
						<img
							src="${pageContext.request.contextPath}/uploadfile/userphoto/${mv.userPhoto}"
							id="memberRegPhoto">
					</c:otherwise>
				</c:choose></td>
		</tr>
	</table>
</div>
<jsp:include page="/resources/common/footer.jsp"></jsp:include>