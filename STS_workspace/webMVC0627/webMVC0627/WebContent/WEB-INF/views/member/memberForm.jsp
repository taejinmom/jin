<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(function() {
	$('#btn1').click(function() {
		let param = $('#id').val();
		$.ajax({
			url:"main.kosmo?cmd=idchk&id="+param,
			success:function(data){
				if(data == 1){
					$('#target').css('background-color','red')
					.css('color','white').html('사용중인 아이디 입니다.');
				}else{
					$('#target').css('background-color','blue')
					.css('color','white').html('사용 가능한 아이디 입니다.');
				}
				
			}
		});
	});
});
</script>
</head>
<body>
<h1>회원 가입 폼</h1>
<form method="post" action="main.kosmo">
<input type="hidden" name="cmd" value="member">
<input type="hidden" name="sub" value="memberin">
<p>아이디 :<input type="text" name="id" id="id">
<input type="button" id="btn1" value="중복체크">
</p> 
<div id="target"></div>
<p>비밀번호 :<input type="password" name="pwd" id="pwd">
</p> 
<p>이름 :<input type="text" name="name" id="name">
</p>
<p>성별 :<input type="radio" name="gender" id="gender" value="여자" checked="checked">여자
<input type="radio" name="gender" id="gender" value="남자">남자
</p>
<p>나이 :<input type="text" name="age" id="age">
</p>
<p><input type="submit" value="send">
</p>
</form>
</body>
</html>


