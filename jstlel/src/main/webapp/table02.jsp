<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<c:set var="row" value="${param.r }" />
<c:set var="col" value="${param.c }" />

<c:if test="${empty row }">
	<c:set var="row" value="3"/>
</c:if>

<c:if test="${empty col }">
	<c:set var="col" value="3"/>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border='1' cellspacing="0">
		<c:forEach begin='0' end='${row-1 }' step='1' var='r'> <!-- 0에서 row-1까지 1씩 증가 -->	
			<tr>
			<c:forEach begin='0' end='${col-1 }' step='1' var='c'>
				<td>cell(${c },${r })</td>
			</c:forEach>
			</tr>
		</c:forEach>
	</table>

</body>
</html>