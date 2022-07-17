<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@include file="../temp/header.jsp"%>
<article>
	<header>
		<h1>ȸ������ Demo</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div class="container">
		<%--memberForm ��� �� �ڸ�. --%>
		<form action="memberIn" method="post">
			<%-- ������� �����Ǹ� �޾ƿͼ� ������ �ʴ� �Ӽ����� reip �� �Ķ���ͷ� �����Ѵ�. --%>
			<input type="hidden" name="reip" value="<%=request.getRemoteAddr()%>">
			<div class="form-group">
				<label for="mem_id">���̵� </label>
				<!-- placeholder �Ӽ� �Է��� �����Ͱ� ���� ��� ������� ��Ÿ����.���������� �Է��� 100�ڱ����� ���� -->
				<!-- required �Ӽ��� �����ϸ� �ʼ��Է� �����̵ȴ�. -->
				<!-- pattern �Ӽ��� �̿��� ����ǥ�������� �������� ��ȿ�� �˻縦 �� �� �ִ�. -->
				<input type="text" class="form-control" id="mem_id"
					placeholder="���̵� �Է�(5-10)" name="mem_id" maxlength="10"
					required="required" pattern=".{1,10}">
				<div id="target"></div>
			</div>
			<div class="form-group">
				<label for="mem_pw">��й�ȣ</label> <input type="password"
					class="form-control" placeholder="********" id="mem_pw" name="mem_pw" required>
			</div>
			<div class="form-group">
				<label for="mem_name">�̸�</label> <input type="text" class="form-control"
					id="mem_name" placeholder="�̸��� �Է��ϼ���." name="mem_name" required="required">
			</div>


			<div class="form-group">
				<label for="mem_jubun">�ֹι�ȣ</label> <input type="text" class="form-control"
					id="mem_jubun" placeholder="�ֹι�ȣ�� �Է��ϼ���." name="mem_jubun" required="required">
			</div>
			<div class="form-group">
				<label for="mem_phone">��ȭ��ȣ</label> <input type="text" class="form-control"
					id="mem_phone" placeholder="��ȭ��ȣ�� �Է��ϼ���." name="mem_phone" required="required">
			</div>
			<div class="form-group">
				<label for="mem_adr">�ּ�</label> <input type="text" class="form-control"
					id="mem_adr" placeholder="�ּҸ� �Է��ϼ���." name="mem_adr" required="required">
			</div>
			<div class="form-group" style="text-align: right; margin-top: 10px;">
				<button type="submit" class="btn btn-primary">���</button>
			</div>
		</form>

	</div>

</article>
<%@include file="../temp/footer.jsp"%>
	<script>
$(function() {

	//���̵� ����ڰ� �Է��Ҷ�
	$('#mem_id').bind('input',function() {
		//mem_id - > ���� param�� �����ϰ�
		let param = $('#mem_id').val();
		$.ajax({
			//idchk
			url:"idchk?mem_id="+param,
			success:function(data){
				if(data == 1){
					$('#target').css('display','inline-block').
					css('color','red').html("������Դϴ�");
				}else{
					$('#target').css('display','inline-block').
					css('color','blue').html("��밡���մϴ�");
				}
				
			}
		});
	});
});
</script>

