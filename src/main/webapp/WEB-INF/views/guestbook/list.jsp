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
			<h2>방명록</h2>
			<span class="msg redMsg">${msg}</span>
			<hr>
			<form method="post">
				<input type="hidden" name="userId" value="${loginInfo.userId}" />메세지<br>
				<textarea name="message" cols="30" row="3"></textarea>
				<br /> <input type="submit" value="메세지 남기기" />
			</form>
			<hr>
			<c:if test="${msgs.isEmpty()}">
	작성된 방명록 메시지가 없습니다.
	</c:if>
			<c:if test="${!msgs.isEmpty()}">
				<table>
					<tr>
						<td>아이디(이메일)</td>
						<td>메세지</td>
						<td>삭제</td>
					</tr>
					<c:forEach var="message" items="${msgs.messageList}">
						<tr>
							<td>${message.userId}</td>
							<td>${message.message}</td>
							<td>
								<%-- <a
								href="${pageContext.request.contextPath}/guestbook/view/${message.idx}">[상세보기]</a> --%>
								<a
								href="${pageContext.request.contextPath}/guestbook/delete?idx=${message.idx}&userId=${message.userId}">[삭제]</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<c:forEach var="num" begin="1" end="${msgs.pageTotalCount}">
				<a href="list?page=${num}">[${num}]</a>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</div>
<jsp:include page="/resources/common/footer.jsp"></jsp:include>