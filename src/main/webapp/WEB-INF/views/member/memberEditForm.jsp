<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/common/header.jsp"></jsp:include>
<div id="contents">
	<h2>수정하기</h2>
	<span class="msg redMsg">${msg}</span>
	<hr>
	<form method="post" enctype="multipart/form-data" id="editSubmit">
		<table>
			<tr>
				<td colspan="2"><c:choose>
						<c:when test="${mv.userPhoto eq 'no-image'}">
							<img
								src="${pageContext.request.contextPath}/resources/images/no-image.png"
								class="memberListPhoto">
						</c:when>
						<c:otherwise>
							<img
								src="${pageContext.request.contextPath}/uploadfile/userphoto/${mv.userPhoto}"
								class="memberListPhoto">
						</c:otherwise>
					</c:choose><input type="hidden" name="userPhoto" value="${mv.userPhoto}"></td>
			</tr>
			<tr>
				<td>아이디(이메일)</td>
				<td><input type="text" name="userId" value="${mv.userId}"
					readonly="readonly"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"
					value="${mv.password}" required></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName" value="${mv.userName}"
					required></td>
			</tr>
			<tr>
				<td colspan="2"><input type="file" name="photoFile"
					value="${mv.userPhoto}"></td>
			</tr>
			<tr>
				<td colspan="2" class="align_center"><input type="submit"
					value="수정완료"><input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="/resources/common/footer.jsp"></jsp:include>

