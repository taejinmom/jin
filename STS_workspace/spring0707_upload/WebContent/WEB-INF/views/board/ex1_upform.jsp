<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	
    #imgx{
		width: 100px;
	}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
// html5 ���� �������ִ� FileReader() �Լ��� ����ؼ� �̹��� �̸����⸦ ���� 
function readURL(input) {
	if (input.files && input.files[0]) {
		// �ڹٽ�ũ��Ʈ I/O 
		var reader = new FileReader();
		//
		reader.onload = function(e) {
			//e.target.result
			console.log("Path :"+e.target.result);
			$('#imgx').attr('src', e.target.result); 
		}
		reader.readAsDataURL(input.files[0]);
	}
}
$(function(){
	$('#btn1').click(function(){
		//1. DOM �Ӽ��� ���� �غ���.
		//$('#upform').attr("action", "update.jsp");
		//$('#upform').submit();
		//2. ������ ����ڰ� �Է��� ���� �ޱ�
		// $('#target').html($('#sub').val());
		//3. input tag�� value�� ���� ���� 
		 // $('#sub').val("������ �Է��ϼ���.")
		 console.log($('#sub').val());
		if($('#sub').val() == ""){
			alert("������ �Է��Ͻÿ�.");
			$('#sub').focus();
			return; // ������ �ߴ�
		}
		if($('#writer').val() == ""){
			alert("�ۼ��ڸ� �Է��Ͻÿ�.");
			$('#writer').focus();
			return; // ������ �ߴ�
		}
		$('#upform').submit();
		//alert("test1");
	});
	// key �̺�Ʈ , forcus �̺�Ʈ 
	//$('#sub').focusin(function() {
	//	$(this).parent().css('background-color','orange');
	//});
	//$('#sub').focusout(function() {
	//	$(this).parent().css('background-color','white');
	//});
	// �ش� ������ ������ �Ǿ��� ���� �����ϴ� �̺�Ʈ 
	$('#upfile').change(function() {
		//console.log($(this).val())
		readURL(this);
	});
});
</script>
</head>
<body>

<div id="main" class="container">
<div id="sub1">
<fieldset>
<legend>�̹��� ���ε� ��</legend>
<form method="post" action="insert.jsp" enctype="multipart/form-data" id="upform">
<div class="row mb-3">
   <label class="col-sm-2 col-form-label">�� ��</label>
   <div class="col-sm-10"><input type="text" name="sub" id="sub" placeholder="������ �Է��ϼ���."/></div>
   
</div> 
<div class="row mb-3">
   <label class="col-sm-2 col-form-label">�ۼ���</label>
   <div class="col-sm-10"><input type="text" name="writer" id="writer"/></div>
</div>
<div class="row mb-3">
    <label class="col-sm-2 col-form-label">��й�ȣ</label>
    <div class="col-sm-10"><input type="password" name="pwd" id="pwd"/></div>
</div>
<div class="row mb-3">
    <label class="col-sm-2 col-form-label">�̹��� ����</label>
    <textarea name="cont" id="cont" rows="10" cols="13"></textarea>
</div>
<div class="row mb-3">
    <label class="col-sm-2 col-form-label">*�̹������ε�</label>
    <div class="col-sm-10"><input type="file" name="upfile" id="upfile"/></div>
    <div class="col-sm-10"><img src="../resources/image/noimage.jpg" id="imgx" ></div>
</div>                        
<div class="row mb-3 ">
 <div class="col-sm-10"><input type="button" value="���" id="btn1" class="btn btn-info"/>
 <input type="button" value="���" id="btn1" class="btn btn-danger" onclick="location='ex1_list.jsp?cPage=1'"/>
 </div>
</div>
</form>
</fieldset>
  </div>
</div>       
</body>
</html>