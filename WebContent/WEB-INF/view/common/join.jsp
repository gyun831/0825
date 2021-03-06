<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../member/member_head.jsp" %>

<div id="container">
	<form id="join_form" action="../member/service_add.jsp" method="get">
	<fieldset style="width:400px; margin:0 auto; padding-top:5px;">
		<legend>Join information</legend>
			<span id="join_id">ID</span>
			<input name="id" type="text" placeholder="ID"/><br/>
			<span id="join_pass">PW</span>
			<input name="password" type="password" placeholder="PW"/><br>
			<span id="join_name">NAME</span>
			<input name="name" type="text" placeholder="이름"/><br>
			<span id="join_phone">전화번호</span>
			<input name="phone" type="text" placeholder="전화번호"/><br/>
			<span id="join_birth">생년월일</span>
			<input name="birthday" type="date" placeholder="생년월일"/><br />
			<span id="join_gender">성별</span>
			<input type="radio" name="gender" value="남"/>남자
			<input type="radio" name="gender" value="여"/>여자<br/>
			<span id="join_email">E-MAIL</span>
			<input type="email" name="email" />
	<h3>전 공</h3>
	<select name="major">
		<option value="computer">컴퓨터공학</option>
		<option value="economics" selected>경제학</option>
		<option value="tourism">항공학</option>
		<option value="art">미술학</option>
	</select><br/>
	<h3>수강과목</h3>
	<input type="checkbox" name="subject" value="java" checked/>자바<br/>
	<input type="checkbox" name="subject" value="c" checked/>C언어<br/>
	<input type="checkbox" name="subject" value="html"/>HTML<br/>
	<input type="checkbox" name="subject" value="css"/>CSS<br/>
	<input type="checkbox" name="subject" value="javascript"/>자바스크립트<br/>
	<input type="checkbox" name="subject" value="sql"/>SQL<br/>
	<input type="checkbox" name="subject" value="python"/>파이썬<br/>
	<input id="join_yes_btn" type="submit" value="등록"/>
	<input id="join_no_btn" type="reset"  value="취소">
	</fieldset>
	</form>
</div>
	<%@ include file="../common/footer.jsp" %>
	
	
<script>
alert('ID없다 회원가입해라이새기야');
</script>
