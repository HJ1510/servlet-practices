<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8"); 
	String email = request.getParameter("email"); 
	String password = request.getParameter("password");
	String birthYear = request.getParameter("birthYear");
	String gender = request.getParameter("gender");
	String profile = request.getParameter("profile");
	String[] hobbies = request.getParameterValues("hobby");
%> <!-- getParameter의 변수값은 무조건 String임.. 다른 데이터일 경우 캐스팅 필요 -->
<!-- request.setCharacterEncoding("UTF-8") => body를 utf8로 인코딩 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4><%=email %></h4>
	<h4><%=password %></h4>
	<h4><%=birthYear %></h4>
	<h4><%=gender %></h4>
	<p><%=profile %></p>
	<!-- hobbies array 출력 -->
	<%
		for(String hobby:hobbies){
	%>
		<h4><%=hobby %></h4>
	<%
		}
	%>
</body>
</html>