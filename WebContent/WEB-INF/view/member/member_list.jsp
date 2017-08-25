<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="member_head.jsp" />
	<div id="container">
	<table id="detail_tab">
		<tr>
			<th>NO.</th>
			<th>ID</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>수강과목</th>
			<th>등록일</th>
			<th>수정/삭제</th>
		</tr>
		<c:forEach var="i" items="${requestScope.list}">
		<tr>
			<td>${i.no}</td>
			<td>${i.id}</td>
			<td><a onclick="detailStudent('${i.id}')">${i.name}</a></td>
			<td>${i.ssn}</td>
			<td>${i.phone}</td>
			<td>${i.email}</td>
			<td>${i.title}</td>
			<td>${i.regdate}</td>
			<td><a onclick="updateStudent('${i.id}')">수정</a>/<a onclick="deleteStudent('${i.id}')">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
	<nav aria-label="Page navigation" style="width:400px;margin: 0 auto">
  		<ul class="pagination">
  			<c:if test="${requestScope.prevBlock gt 0 }">
  			 <li><a href="#"><span class="glyphicon glyphicon-step-backward" aria-hidden="true"></span></a></li>
   			 <li><a onclick="list('member','member_list','${requestScope.startPage-2}')" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
    		</li>
    		</c:if>
    		<c:forEach varStatus="i" begin="${requestScope.startPage}" end="${requestScope.endPage}" step="1">
    			<c:choose>
    				<c:when test="${i.index eq requestScope.pageNumber}">
    				 	<li class="active"><a href="#">${i.index}</a></li> 
    				</c:when>
    				<c:otherwise>
    					<li><a onclick="list('member','member_list',${i.index})" href="#">${i.index}</a></li>
    				</c:otherwise>
    			</c:choose>
			</c:forEach>
			<c:if test="${requestScope.endBlock le requestScope.theNumberOfPages}">
		    <li>
     		 	<a onclick="list('member','member_list','${requestScope.startPage+2}')" aria-label="Next">
       			 <span aria-hidden="true">&raquo;</span>
      			</a>
   			 </li>
   			  <li><a href="#"><span class="glyphicon glyphicon-step-forward" aria-hidden="true"></span></a></li>
   			</c:if>
  		</ul>
	</nav>
</div>
<script>
function updateStudent(id){
	alert('수정할 id'+id);
	location.href="${ctx}/member.do?action=update&page=member_update&id="+id;
}
function deleteStudent(id){
	alert('삭제할 id'+id);
	location.href="${ctx}/member.do?action=delete&page=member_delete&id="+id;
}
function detailStudent(id){
	alert('조회할 id'+id);
	location.href="${ctx}/member.do?action=detail&page=member_detail&id="+id;
}
</script>
<jsp:include page="../common/footer.jsp"/>
