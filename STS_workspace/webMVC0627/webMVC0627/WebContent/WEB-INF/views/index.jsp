<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>����� index</h2>
<c:choose>
<c:when test="${sessionScope.id==null }">
<a href="main.kosmo?cmd=login&sub=form">Login</a>
<a href="main.kosmo?cmd=member&sub=form">Join</a>
</c:when>
<c:otherwise>
${sessionScope.id} �� �ݰ����ϴ�.
<a href="main.kosmo?cmd=mypage&id=${sessionScope.id}">Mypage</a>
<a href="main.kosmo?cmd=login&sub=logout">Logout</a>
</c:otherwise>
</c:choose>


</body>
</html>