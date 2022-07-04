<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="main.kosmo" method="post">
<input type="hidden" name="cmd" value="login">
<input type="hidden" name="sub" value="loginchk">
<p>아이디 :<input type="text" name="id" id="id">
</p> 
<p>비밀번호 :<input type="password" name="pwd" id="pwd">
</p>
<p><input type="submit" value="send">
</p>
</form>
</body>
</html>