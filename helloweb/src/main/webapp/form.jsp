<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="join.jsp" method="post">
		email : <input type="text" name="email"/>
		<br/><br/>
		
		비밀번호 : <input type="password" name="password" value=""/>
		<br/><br/>
		
		생년 : 
		<select name="birthYear">
		<option value="1996">1996년</option>
		<option value="1997">1997년</option>
		<option value="1998">1998년</option>
		</select>
		<br/><br/>
		
		성별 : 
		여성<input type="radio" name="gender" value="female" checked="checked"/> <!-- name="gender" 이 부분 이름이 같아야 배타적 선택 checked="checked" 기본 선택값-->
		남성<input type="radio" name="gender" value="male" />
		<br/><br/>
		
		자기소개 : 
		<br/>
		<textarea name="profile"></textarea> <!-- 탭이나 엔터 사용xx -->
		<br/><br/>
		
		취미 : 
		<br/>
		코딩<input type="checkbox" name="hobby" value="coding" /> <!-- checkbox는 여러개 선택가능 -->
		노래하기<input type="checkbox" name="hobby" value="singing" />
		요리<input type="checkbox" name="hobby" value="cooking" />
		수영<input type="checkbox" name="hobby" value="swimming" />
		<br/><br/>
		<input type="submit" value="회원가입" />
	</form> 
</body>
</html>