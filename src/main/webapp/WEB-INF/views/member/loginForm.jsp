<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/resources/common/header.jsp"></jsp:include>
<div id="contents">
	<h2>로그인</h2>
	<span class="msg redMsg">${msg}</span>
	<hr>
	<form method="post">
		<table>
			<tr>
				<td>아이디(이메일)</td>
				<td><input type="text" name="userId" required></td>
			</tr>
			<tr>
				<td class="align_right"><input type="checkbox" name="savedId"
					id="savedId" value="savedId"></td>
				<td><label for="savedId">아이디(이메일) 기억하기</label></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><input
					type="submit" value="로그인"></td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="/resources/common/footer.jsp"></jsp:include>
