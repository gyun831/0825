<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="member_head.jsp" />

<div id="container">
	<form action="${ctx}/member/service_update.jsp" method="get">
	<table id="member_detail_tab">
		<tr>
			<td colspan="2" rowspan="3" ><img src="${img}/2.jpg" width="130px" height="100px"/></td>
			<td>이름</td>
			<td><input type="text" name="name" placeholder="" /></td>
		</tr>
		<tr>
			<td>ID</td>
			<td><input type="hidden" name="id" value=""/></td>
		</tr>
		<tr>
			<td>SSN</td>
			<td><input type="hidden" name="ssn" value="" /></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td colspan="3"><input type="text" name="phone" placeholder="" /></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td colspan="3"><input type="text" name="email" placeholder="" /></td>
		</tr>
		<tr>
			<td>전공</td>
			<td colspan="3"><input type="text" name="major" placeholder="" /></td>
		</tr>
		<tr>
			<td>학점</td>
			<td colspan="3"><input type="text" name="subject" placeholder="A" /></td>
		</tr>
	</table>
	<input type="submit" id="confim_btn" value="수 정"/>
	<input type="button" onclick="javascript:cancel()" value="취 소" />
	</form>
</div>
		<br /><br /><br /><br />
<jsp:include page="../common/footer.jsp"/>
