<%@page import="com.bitacademy.guestbook.dao.Guestbook01Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
String sno = request.getParameter("no");
Long no = Long.parseLong(sno);
String password = request.getParameter("password");

new Guestbook01Dao().deleteByNoAndPassword(no,password);
	
	response.sendRedirect("/guestbook01");
%>