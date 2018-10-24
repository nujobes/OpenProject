<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/resources/common/header.jsp"></jsp:include>
<div id="contents">
	<h2>회원가입</h2>
	<span class="msg redMsg">${msg}</span>
	<hr>
	<form method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>아이디(이메일)</td>
				<td><input type="text" name="userId" value="${mv.userId}"
					required></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName" value="${mv.userName}"
					required></td>
			</tr>
			<tr>
				<td>사진</td>
				<td><input type="file" name="photoFile"></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><input
					type="submit" value="등록"><input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="/resources/common/footer.jsp"></jsp:include>
