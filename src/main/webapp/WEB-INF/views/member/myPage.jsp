<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/common/header.jsp"></jsp:include>
<div id="contents">
	<c:choose>
		<c:when test="${empty sessionScope.loginInfo}">
			<h2>로그인 후 이용 가능한 서비스입니다.</h2>
		</c:when>
		<c:otherwise>
			<h2>나의 정보</h2>
			<hr>
			<form>
				<table>
					<tr>
						<td>아이디</td>
						<td>${loginInfo.userId}</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>${loginInfo.userName}</td>
					</tr>
					<tr>
						<td>사진</td>
						<td><c:choose>
								<c:when test="${loginInfo.userPhoto eq 'no-image'}">
									<img
										src="${pageContext.request.contextPath}/resources/images/no-image.png"
										id="myPagePhoto">
								</c:when>
								<c:otherwise>
									<img
										src="${pageContext.request.contextPath}/uploadfile/userphoto/${loginInfo.userPhoto}"
										id="myPagePhoto">
								</c:otherwise>
							</c:choose></td>
					</tr>
				</table>
			</form>
		</c:otherwise>
	</c:choose>
</div>
<jsp:include page="/resources/common/footer.jsp"></jsp:include>