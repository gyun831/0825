<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="member_head.jsp" />
<div id="container">
	<form id="member_search_box" action="${ctx}/member/service_search.jsp" method="get">
	검색조건<select name="option">
			<option value="id" selected>ID</option>
			<option value="name" >이름</option>
		</select><br/><br/><br/>
		<input type="text" name="search" />	
		<input type="submit" value="SEARCH"/>
	</form>
</div>
<jsp:include page="../common/footer.jsp" />
