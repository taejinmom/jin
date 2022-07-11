<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../temp/header.jsp"%>

<article>
	<header>
		<h1>ȸ������ Demo</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div>
		<%-- memberForm �� �ڸ� --%>
		<form action="memberIn" method="post">
			<input type="hidden" name="reip" value="<%=request.getRemoteAddr()%>">
			<div class="form-group">
				<label for="id" style="display: block">���̵� </label>
				<!-- placeholder �Ӽ� �Է��� �����Ͱ� ���� ��� ������� ��Ÿ����.���������� �Է��� 100�ڱ����� ���� -->
				<!-- required �Ӽ��� �����ϸ� �ʼ��Է� �����̵ȴ�. -->
				<!-- pattern �Ӽ��� �̿��� ����ǥ�������� �������� ��ȿ�� �˻縦 �� �� �ִ�. -->
				<input type="text" class="form-control" id="id"
					placeholder="���̵� �Է�(5-10)" name="id" maxlength="10"
					required="required" pattern=".{5,10}" style="float: left; width: 80%; margin-right: 10px;">
				<button type="button" class="btn btn-primary" id="btn1">�ߺ� Ȯ��</button>
				<div id="target"></div>
			</div>
			<div class="form-group">
				<label for="pwd">��й�ȣ </label> <input type="password"
					class="form-control" id="pwd" placeholder="��й�ȣ(2��-10��)" name="pwd"
					required="required">
			</div>
			<div class="form-group">
				<label for="name">�̸� </label> <input type="text"
					class="form-control" id="name" placeholder="�̸��� �Է��ϼ���." name="name"
					required="required">
			</div>
			<div class="form-group">
				<label for="gender">���� </label>
				<div>
					<input type="radio" name="gender" id="gender1"
						value="����" checked="checked">
					<label class="form-check-label" for="gender1">����</label>
				</div>
				<div>
					<input type="radio" name="gender" id="gender2"
						value="����">
					<label class="form-check-label" for="gender2">����</label>
				</div>
			</div>
			<div class="form-group">
				<label for="age">���� </label> <input type="text" class="form-control"
					id="age" placeholder="���̸� �Է��ϼ���." name="age" required="required">
			</div>
			<div class="form-group" style="text-align: right; margin-top: 10px;">
				<button type="submit" class="btn btn-primary">���</button>
			</div>
		</form>
	</div>

<script type="text/javascript">
	$(function() {
		$('#btn1').click(function() {
			let param = $('#id').val();
			//alert("param"+param);
			$.ajax({
				url:"idcheck?id="+param,
				success:function(data){
					console.log(data);
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

</article>

<%@include file="../temp/footer.jsp"%>
<%-- �������� �� --%>