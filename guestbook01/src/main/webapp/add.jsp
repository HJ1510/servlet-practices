<%@page import="com.bitacademy.guestbook.dao.Guestbook01Dao"%>
<%@page import="com.bitacademy.guestbook.vo.Guestbook01Vo"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String message = request.getParameter("message");

	Guestbook01Vo vo = new Guestbook01Vo();
	vo.setName(name);
	vo.setPassword(password);
	vo.setContents(message);
	new Guestbook01Dao().insert(vo);

	response.sendRedirect("/guestbook01");
%>
<!-- Redirect 응답은 html 필요없음 -->