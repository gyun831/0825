<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>학생관리</title>
<link rel="stylesheet" href="${ctx}/resources/css/member.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div id="wrapper">
<header>
<h1 id="title">학생관리</h1>
<a id="go_main" href="${ctx}/index.jsp">메인으로 가기</a><br>
<hr />
</header>
<div id="container">
	<form id="login_box" name="login_box">
		<a href="${ctx}/index.jsp"><img src="${img}/google.jpg" width="320" height="100"/></a><br>
		<span id="login_id">ID</span>
	  	<input type="text" id="input_id" name="id" value="hong"/><br> 
		<span id="login_pass">PASSWORD</span>
		<input type="password" id="input_pass" name="pass" value="1"/><br>
		<br/>
		<input type="submit" value="LOGIN" onclick="login_alert()" id="login_btn" />
		<input type="reset" value="CANCEL" id="cancle_btn">
		<input type="hidden" name="action" value="login">
		<input type="hidden" name="page" value="home">
	</form>
</div>
<script>
function login_alert(){
	var id=document.getElementById("input_id").value;
	var pass=document.getElementById("input_pass").value;
	if(id==""){
		alert('아이디 없음');
		return false;
	}
	if(pass==""){
		alert('비밀번호 다름');
		return false;
	}
	var form=document.getElementById('login_box');
	form.method="post";
	form.action="${ctx}/common.do";
	return true;
}
</script>
<footer>
	<div>
	  <p>Posted by: Hanbit</p>
	  <p>Contact information: <a href="mailto:someone@example.com">
	  someone@example.com</a>.</p>
	  <a href="util/update_email.jsp">Email</a>
	</div>
</footer>
</div>
</body>
</html>