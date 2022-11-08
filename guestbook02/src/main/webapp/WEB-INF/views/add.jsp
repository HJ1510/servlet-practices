<%@page import="com.bitacademy.guestbook.dao.GuestbookDao"%>
<%@page import="com.bitacademy.guestbook.vo.GuestbookVo"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String message = request.getParameter("message");

	GuestbookVo vo = new GuestbookVo();
	vo.setName(name);
	vo.setPassword(password);
	vo.setContents(message);
	new GuestbookDao().insert(vo);

	response.sendRedirect("/guestbook01");
%>
<!-- Redirect 응답은 html 필요없음 -->