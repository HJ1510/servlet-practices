<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World</h1>
	<h2>Hello World</h2>
	<h3>Hello World</h3>
	<h4>Hello World</h4>
	<h5>Hello World</h5>
	<h6>Hello World</h6>

	<table border='1' cellspacing="0">
		<!-- css와 html은 분리하는것이 좋음.. 지금은 임시방편 -->
		<tr>
			<td>글번호</td>
			<td>글제목</td>
			<td>작성자</td>
		</tr>

		<tr>
			<td>2</td>
			<td>안녕</td>
			<td>둘리</td>
		</tr>

		<tr>
			<td>1</td>
			<td>안녕!</td>
			<td>마이콜</td>
		</tr>

	</table>

	<br />
	<img src="http://localhost:8080/helloweb/images/cute2.jpg" style="width:100px" />
	<br />
	<img src="/helloweb/images/cute2.jpg" style="width:100px" /> <!-- /부터 시작하면 절대경로 -->
	<br />
	<img src="images/cute2.jpg" style="width:100px" /> <!-- 상대경로 (./) 생략가능 주로 이렇게 씀(프로그램 이름을 바꾸거나 위치를 바꾸는 경우 수월)-->
	<p>
		문장입니다!<br/>
		문장입니다!<br/>
		문장입니다!<br/>
	</p>
	
	<a href="hello.jsp?name=윤현정">hello로 가기1</a> <!-- 상대경로 -->
	<br/>
	<a href="/helloweb/hello?name=윤현정">hello로 가기2</a> <!-- 상대경로 --> <!-- doGet 호출 -->
	<br/>
	<a href="form.jsp">폼으로 가기</a> 

</body>
</html>