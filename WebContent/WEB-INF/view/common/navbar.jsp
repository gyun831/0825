<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">GMS</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a onclick="moveTo('common','home')"><span class="glyphicon glyphicon-home"></span>&nbsp; Home</a></li>
      <li class="dropdown">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">학생관리<span class="caret"></span></a>
      <ul id="navbar_ul_stu">
      <li><a >회원가입</a></li>
      <li><a >회원목록</a></li>
      <li><a >회원상세</a></li>
      <li><a >회원수정</a></li>
      <li><a >회원삭제</a>
 	  </ul>
 	  </li>
 	  <li class="dropdown">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">성적관리<span class="caret"></span></a>
      <ul id="navbar_ul_grade">
      <li><a >성적입력</a></li>
      <li><a >성적 목록</a></li>
      <li><a >성적상세</a></li>
      <li><a >성적수정</a></li>
      <li><a >성적삭제</a></li>
 	  </ul>
 	  </li>
 	  <li class="dropdown">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">게시글관리<span class="caret"></span></a>
      <ul id="navbar_ul_board">
      <li><a >게시글 쓰기</a></li>
      <li><a >게시글목록</a></li>
      <li><a >게시글상세</a></li>
      <li><a >게시글 수정</a></li>
      <li><a >게시글삭제</a></li>
 	  </ul>
 	  </li>
 	  </ul>
    <span class="gms-float-right">${seesion.user.name} &nbsp;<a id="logout" >로그아웃</a></span>
 <script>
 window.onload=navbarLoad();
 function log_out(dir,page){
	 location.href="${ctx}/"+dir+".do?action=logout&page="+page;
 }
 function moveTo(dir,page){
	location.href="${ctx}/"+dir+".do?action=move&page="+page;
}
 function gms_del(name){
	var person = prompt("삭제할"+name,"입력");
}
 function list(dir,page,pageNumber){
	 location.href="${ctx}/"+dir+".do?action=list&page="+page+"&pageNumber="+pageNumber;
 }
 function mainLoad(){
	 var u1 = document.getElementById("main_ul_stu");
	 var u2 = document.getElementById("main_ul_grade");
	 var u3 = document.getElementById("main_ul_board");
	 u1.setAttribute("class","list-group");
	 u2.setAttribute("class","list-group");
	 u3.setAttribute("class","list-group");
	 var u1c = u1.children;
	 var u2c = u2.children;
	 var u3c = u3.children;
	 var i;
	 for(i=0;i<u1c.length;i++){
	 	u1c[i].setAttribute("class","list-group-item");
	 }
	 for(i=0;i<u2c.length;i++){
	 	u2c[i].setAttribute("class","list-group-item");
	 }
	 for(i=0;i<u3c.length;i++){
	 	u3c[i].setAttribute("class","list-group-item");
	 }
	 u1c[0].setAttribute("onclick","moveTo('member','member_add')");
	 u1c[1].setAttribute("onclick","list('member','member_list','1')");
	 u1c[2].setAttribute("onclick","moveTo('member','member_detail')");
	 u1c[3].setAttribute("onclick","moveTo('member','member_update')");
	 u1c[4].setAttribute("onclick","gms_del('회원')");
	 		
	 u2c[0].setAttribute("onclick","moveTo('grade','grade_add')");
	 u2c[1].setAttribute("onclick","list('grade','grade_list','1')");
	 u2c[2].setAttribute("onclick","moveTo('grade','grade_detail')");
	 u2c[3].setAttribute("onclick","moveTo('grade','grade_update')");
	 u2c[4].setAttribute("onclick","gms_del('성적')");

	 u3c[0].setAttribute("onclick","moveTo('board','board_add')");
	 u3c[1].setAttribute("onclick","list('board','board_list','1')");
	 u3c[2].setAttribute("onclick","moveTo('board','board_detail')");
	 u3c[3].setAttribute("onclick","moveTo('board','board_update')");
	 u3c[4].setAttribute("onclick","gms_del('게시글')");
}
function navbarLoad(){
	 var u1 = document.getElementById("navbar_ul_stu");
	 var u2 = document.getElementById("navbar_ul_grade");
	 var u3 = document.getElementById("navbar_ul_board");
	 document.getElementById("logout").setAttribute("onclick","log_out('common','index')");
	 u1.setAttribute("class","dropdown-menu");
	 u2.setAttribute("class","dropdown-menu");
	 u3.setAttribute("class","dropdown-menu");
	 
	 var u1c = u1.children;
	 var u2c = u2.children;
	 var u3c = u3.children;
	 
	 u1c[0].setAttribute("onclick","moveTo('member','member_add')");
	 u1c[1].setAttribute("onclick","list('member','member_list','1')");
	 u1c[2].setAttribute("onclick","moveTo('member','member_detail')");
	 u1c[3].setAttribute("onclick","moveTo('member','member_update')");
	 u1c[4].setAttribute("onclick","gms_del('회원')");
	 
	 u2c[0].setAttribute("onclick","moveTo('grade','grade_add')");
	 u2c[1].setAttribute("onclick","list('grade','grade_list','1')");
	 u2c[2].setAttribute("onclick","moveTo('grade','grade_detail')");
	 u2c[3].setAttribute("onclick","moveTo('grade','grade_update')");
	 u2c[4].setAttribute("onclick","gms_del('성적')");

	 u3c[0].setAttribute("onclick","moveTo('board','board_add')");
	 u3c[1].setAttribute("onclick","list('board','board_list','1')");
	 u3c[2].setAttribute("onclick","moveTo('board','board_detail')");
	 u3c[3].setAttribute("onclick","moveTo('board','board_update')");
	 u3c[4].setAttribute("onclick","gms_del('게시글')");
}
 </script>
  </div>
</nav>