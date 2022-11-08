<%@page import="com.bitacademy.guestbook.dao.GuestbookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
	String password = request.getParameter("password");
	int no = Integer.parseInt(request.getParameter("no"));
	new GuestbookDao().deleteGuestbook(password, no);
	
	response.sendRedirect("/guestbook01");
%>
<!-- String sno = request.getParameter("no");
	Long no=Long.parseLong(sno); -->