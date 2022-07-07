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
// html5 부터 제공해주는 FileReader() 함수를 사용해서 이미지 미리보기를 구현 
function readURL(input) {
	if (input.files && input.files[0]) {
		// 자바스크립트 I/O 
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
		//1. DOM 속성을 제어 해보자.
		//$('#upform').attr("action", "update.jsp");
		//$('#upform').submit();
		//2. 폼에서 사용자가 입력한 값을 받기
		// $('#target').html($('#sub').val());
		//3. input tag에 value에 값을 저장 
		 // $('#sub').val("제목을 입력하세요.")
		 console.log($('#sub').val());
		if($('#sub').val() == ""){
			alert("제목을 입력하시오.");
			$('#sub').focus();
			return; // 수행이 중단
		}
		if($('#writer').val() == ""){
			alert("작성자를 입력하시오.");
			$('#writer').focus();
			return; // 수행이 중단
		}
		$('#upform').submit();
		//alert("test1");
	});
	// key 이벤트 , forcus 이벤트 
	//$('#sub').focusin(function() {
	//	$(this).parent().css('background-color','orange');
	//});
	//$('#sub').focusout(function() {
	//	$(this).parent().css('background-color','white');
	//});
	// 해당 셀렉터 변경이 되었을 때를 감지하는 이벤트 
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
<legend>이미지 업로드 폼</legend>
<form method="post" action="insert.jsp" enctype="multipart/form-data" id="upform">
<div class="row mb-3">
   <label class="col-sm-2 col-form-label">제 목</label>
   <div class="col-sm-10"><input type="text" name="sub" id="sub" placeholder="제목을 입력하세요."/></div>
   
</div> 
<div class="row mb-3">
   <label class="col-sm-2 col-form-label">작성자</label>
   <div class="col-sm-10"><input type="text" name="writer" id="writer"/></div>
</div>
<div class="row mb-3">
    <label class="col-sm-2 col-form-label">비밀번호</label>
    <div class="col-sm-10"><input type="password" name="pwd" id="pwd"/></div>
</div>
<div class="row mb-3">
    <label class="col-sm-2 col-form-label">이미지 내용</label>
    <textarea name="cont" id="cont" rows="10" cols="13"></textarea>
</div>
<div class="row mb-3">
    <label class="col-sm-2 col-form-label">*이미지업로드</label>
    <div class="col-sm-10"><input type="file" name="upfile" id="upfile"/></div>
    <div class="col-sm-10"><img src="../resources/image/noimage.jpg" id="imgx" ></div>
</div>                        
<div class="row mb-3 ">
 <div class="col-sm-10"><input type="button" value="등록" id="btn1" class="btn btn-info"/>
 <input type="button" value="등록" id="btn1" class="btn btn-danger" onclick="location='ex1_list.jsp?cPage=1'"/>
 </div>
</div>
</form>
</fieldset>
  </div>
</div>       
</body>
</html>