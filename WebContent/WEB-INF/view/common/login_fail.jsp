<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>학생관리</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/member.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div id="wrapper">
<header>
<h1 id="title">학생관리</h1>
<a id="go_main" href="<%=request.getContextPath()%>/index.jsp">메인으로 가기</a><br>
<hr />
</header>
<div id="container">
	<form id="login_box" name="login_box">
		<a href="<%=request.getContextPath()%>/index.jsp"><img src="<%=request.getContextPath()%>/resources/img/google.jpg" width="320" height="100"/></a><br>
		<span id="login_id">ID</span>
	  	<input type="text" id="id" name="id"/><br> 
		<span id="login_pass">PASSWORD</span>
		<input type="password" id="pass" name="pass"/><br>
		<br/>
		<input type="submit" value="LOGIN" onclik="login_alert()" id="login_btn" />
		<input type="reset" value="CANCEL" id="cancle_btn">
		<input type="hidden" name="action" value="login">
		<input type="hidden" name="page" value="home">
	</form>

</div>
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