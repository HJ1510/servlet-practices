<%@page import="com.bitacademy.guestbook01.dao.Guestbook01Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
	request.setCharacterEncoding("utf-8");
	String password = request.getParameter("password");
	int no=Integer.parseInt(request.getParameter("no"));
	new Guestbook01Dao().deleteGuestbook(password);
	
	response.sendRedirect("/guestbook01");
	%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>