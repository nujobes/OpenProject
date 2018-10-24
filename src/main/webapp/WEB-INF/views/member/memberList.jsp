<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/common/header.jsp"></jsp:include>
<div id="contents">
	<h2>회원 리스트</h2>
	<span class="msg redMsg">${msg}</span>
	<hr>
	<table>
		<tr>
			<td class="align_center">번호</td>
			<td class="align_center">아이디</td>
			<td class="align_center">이름</td>
			<td class="align_center">사진</td>
			<td class="align_center">수정/삭제</td>
		</tr>
		<c:choose>
			<c:when test="${empty members}">
				<tr>
					<td colspan="5">회원이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:set var="count" value="0" scope="page" />
				<c:forEach var="item" items="${members}">
					<c:set var="count" value="${count + 1}" scope="page" />
					<tr>
						<td class="align_center">${count}</td>
						<td class="align_center">${item.userId}</td>
						<td class="align_center">${item.userName}</td>
						<td class="align_center"><c:choose>
								<c:when test="${item.userPhoto eq 'no-image'}">
									<img
										src="${pageContext.request.contextPath}/resources/images/no-image.png"
										class="memberListPhoto">
								</c:when>
								<c:otherwise>
									<img
										src="${pageContext.request.contextPath}/uploadfile/userphoto/${item.userPhoto}"
										class="memberListPhoto">
								</c:otherwise>
							</c:choose></td>
						<td class="align_center"><a
							href="${pageContext.request.contextPath}/member/memberEdit?userid=${item.userId}"><input
								type="button" value="수정"></a><a
							href="${pageContext.request.contextPath}/member/memberDelete?userid=${item.userId}"><input
								type="button" value="삭제"></a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</div>

<jsp:include page="/resources/common/footer.jsp"></jsp:include>