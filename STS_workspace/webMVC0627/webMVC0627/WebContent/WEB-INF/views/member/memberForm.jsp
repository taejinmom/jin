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
					.css('color','white').html('������� ���̵� �Դϴ�.');
				}else{
					$('#target').css('background-color','blue')
					.css('color','white').html('��� ������ ���̵� �Դϴ�.');
				}
				
			}
		});
	});
});
</script>
</head>
<body>
<h1>ȸ�� ���� ��</h1>
<form method="post" action="main.kosmo">
<input type="hidden" name="cmd" value="member">
<input type="hidden" name="sub" value="memberin">
<p>���̵� :<input type="text" name="id" id="id">
<input type="button" id="btn1" value="�ߺ�üũ">
</p> 
<div id="target"></div>
<p>��й�ȣ :<input type="password" name="pwd" id="pwd">
</p> 
<p>�̸� :<input type="text" name="name" id="name">
</p>
<p>���� :<input type="radio" name="gender" id="gender" value="����" checked="checked">����
<input type="radio" name="gender" id="gender" value="����">����
</p>
<p>���� :<input type="text" name="age" id="age">
</p>
<p><input type="submit" value="send">
</p>
</form>
</body>
</html>


