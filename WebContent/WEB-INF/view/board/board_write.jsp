<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="board_head.jsp" />
	<div id="container">
		<form action="" method="get">
			<input name="id" type="text" placeholder="제목"/><br/>
			<textarea name="" rows="20" cols="50" placeholder="내용"></textarea><br/>
			<input type="submit">
		</form>
	</div>
<%@ include file="../common/footer.jsp" %>