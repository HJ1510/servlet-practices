<%@page import="com.bitacademy.guestbook01.dao.Guestbook01Dao"%>
<%@page import="com.bitacademy.guestbook01.vo.Guestbook01Vo"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String message = request.getParameter("message");
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	Guestbook01Vo vo = new Guestbook01Vo();
	vo.setName(name);
	vo.setPassword(password);
	vo.setContents(message);
	vo.setRegDate(calendar.getTime());
	new Guestbook01Dao().insert(vo);

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