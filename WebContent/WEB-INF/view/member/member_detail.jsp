<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="member_head.jsp" />

			<div id="container">
			<table id="member_detail_tab">
				<tr>
					<td colspan="2" rowspan="3" ><img src="${img}/2.jpg" width="130px" height="100px"/></td>
					<td>이름</td>
					<td></td>
				</tr>
				<tr>
					<td>ID</td>
					<td></td>
				</tr>
				<tr>
					<td>SSN</td>
					<td></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td colspan="3"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td colspan="3"></td>
				</tr>
				<tr>
					<td>전공</td>
					<td colspan="3"></td>
				</tr>
				<tr>
					<td>학점</td>
					<td colspan="3">A</td>
				</tr>
			</table>
			<button id="list_btn" onclick="javascript:goList()">목 록</button>
			<button id="update_btn" onclick="javascript:goUpdate()">수 정</button>
		</div>
<jsp:include page="../common/footer.jsp"/>
