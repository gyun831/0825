<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-디렉티브(설정)->
<%@ page import="java.sql.*" %>
<%
		//Class.forName(ORACLE_DRIVER);
		//Connection conn=DriverManager.getConnection(ORACLE_URL,USERNAME,PASSWORD);
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		//Statement stmt = conn.createStatement();
		String findName="";
		String sql="SELECT password FROM Member WHERE id='hong'";
		//ResultSet rs = stmt.executeQuery(sql);
	
		//if(rs.next()){
		//	findName = rs.getString("name");
		//}
%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
<h1>Hello <%=findName%> </h1>
</body>
</html>