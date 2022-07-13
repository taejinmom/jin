<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../temp/header.jsp"%>
<article >
        <header>
            <h1>ȸ������ Demo</h1>
        </header>
        <ul class="list-unstyled"><li class="border-top my-3"></li></ul>
        <div class="container">
 <%--memberForm ��� �� �ڸ�. --%>
 <form action="memberIn" method="post">
 <%-- ������� �����Ǹ� �޾ƿͼ� ������ �ʴ� �Ӽ����� reip �� �Ķ���ͷ� �����Ѵ�. --%>
 
    <div class="form-group">
      <label for="mem_id">���̵� </label>
<!-- placeholder �Ӽ� �Է��� �����Ͱ� ���� ��� ������� ��Ÿ����.���������� �Է��� 100�ڱ����� ���� -->
<!-- required �Ӽ��� �����ϸ� �ʼ��Է� �����̵ȴ�. -->
<!-- pattern �Ӽ��� �̿��� ����ǥ�������� �������� ��ȿ�� �˻縦 �� �� �ִ�. -->
      <input type="text" class="form-control" id="mem_id"
       placeholder="���̵� �Է�(5-10)" name="mem_id"
       maxlength="10" required="required"
       pattern=".{1,10}"><button type="button" class="btn btn-primary" id="btn1">�ߺ�Ȯ��</button>
   	 <div id="target"></div>
    </div>
    <div class="form-group">
      <label for="mem_pw">��й�ȣ</label>
      <input type="password" class="form-control" id="mem_pw"
        name="mem_pw" required="required"  placeholder="*******">
    </div> 
    <div class="form-group">
      <label for="mem_name">�̸�</label>
      <input type="text" class="form-control" id="mem_name"
       placeholder="�̸��� �Է��ϼ���." name="mem_name" required="required">
    </div>
    
           
    <div class="form-group">
      <label for="mem_jubun">�ֹι�ȣ</label>
      <input type="text" class="form-control" id="mem_jubun"
       placeholder="�ֹι�ȣ�� �Է��ϼ���" name="mem_jubun" required="required">
    </div>
    <div class="form-group">
      <label for="mem_phone">��ȭ��ȣ</label>
      <input type="text" class="form-control" id="mem_phone"
       placeholder="��ȭ��ȣ�� �Է��ϼ���" name="mem_phone" required="required">
    </div>
    <div class="form-group">
      <label for="mem_adr">�ּ�</label>
      <input type="text" class="form-control" id="mem_adr"
       placeholder="�ּҸ� �Է��ϼ���" name="mem_adr" required="required">
    </div>
     <div class="form-group" style="text-align: right; margin-top: 10px;">
      <button type="submit" class="btn btn-primary">���</button>
    </div>
  </form>

</div>
 
    </article>
<%@include file="../temp/footer.jsp"%>    
    
    
<%-- �������� �� --%>    

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>

$(function() {

	
	$('#btn1').click(function() {
		let param = $('#mem_id').val();
		//alert("param"+param);
		$.ajax({
			url:"idcheck?mem_id="+param,
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