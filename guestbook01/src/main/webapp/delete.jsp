<%@page import="com.bitacademy.guestbook01.dao.Guestbook01Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
	request.setCharacterEncoding("utf-8");
	String password = request.getParameter("password");
	int no=Integer.parseInt(request.getParameter("no"));
	new Guestbook01Dao().deleteGuestbook(password,no);
	
	response.sendRedirect("/guestbook01");
	%>