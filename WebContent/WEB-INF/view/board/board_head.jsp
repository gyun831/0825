<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" import="java.util.Date"%>
<jsp:include page="../common/common_head.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판관리</title>
<link rel="stylesheet" href="../css/board.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<header>
<div id="wrapper">
	<h1 id="title">게시판관리</h1>
	<a id="go_main" href="<%=request.getContextPath()%>/index.jsp">메인으로 가기</a><br>
	<hr><!-- 로그인화면  -->
</div>
</header>
