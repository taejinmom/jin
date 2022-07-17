<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@include file="../temp/header.jsp"%>
<article>
	<header>
		<h1>회원가입 Demo</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div class="container">
		<%--memberForm 들어 갈 자리. --%>
		<form action="memberIn" method="post">
			<%-- 사용자의 아이피를 받아와서 보이지 않는 속성으로 reip 란 파라미터로 지정한다. --%>
			<input type="hidden" name="reip" value="<%=request.getRemoteAddr()%>">
			<div class="form-group">
				<label for="mem_id">아이디 </label>
				<!-- placeholder 속성 입력한 데이터가 없는 경우 배경으로 나타난다.실제적으로 입력을 100자까지로 지정 -->
				<!-- required 속성을 설정하면 필수입력 사항이된다. -->
				<!-- pattern 속성을 이용한 정규표현식으로 데이터의 유효성 검사를 할 수 있다. -->
				<input type="text" class="form-control" id="mem_id"
					placeholder="아이디 입력(5-10)" name="mem_id" maxlength="10"
					required="required" pattern=".{1,10}">
				<div id="target"></div>
			</div>
			<div class="form-group">
				<label for="mem_pw">비밀번호</label> <input type="password"
					class="form-control" placeholder="********" id="mem_pw" name="mem_pw" required>
			</div>
			<div class="form-group">
				<label for="mem_name">이름</label> <input type="text" class="form-control"
					id="mem_name" placeholder="이름을 입력하세요." name="mem_name" required="required">
			</div>


			<div class="form-group">
				<label for="mem_jubun">주민번호</label> <input type="text" class="form-control"
					id="mem_jubun" placeholder="주민번호를 입력하세요." name="mem_jubun" required="required">
			</div>
			<div class="form-group">
				<label for="mem_phone">전화번호</label> <input type="text" class="form-control"
					id="mem_phone" placeholder="전화번호를 입력하세요." name="mem_phone" required="required">
			</div>
			<div class="form-group">
				<label for="mem_adr">주소</label> <input type="text" class="form-control"
					id="mem_adr" placeholder="주소를 입력하세요." name="mem_adr" required="required">
			</div>
			<div class="form-group" style="text-align: right; margin-top: 10px;">
				<button type="submit" class="btn btn-primary">등록</button>
			</div>
		</form>

	</div>

</article>
<%@include file="../temp/footer.jsp"%>
	<script>
$(function() {

	//아이디를 사용자가 입력할때
	$('#mem_id').bind('input',function() {
		//mem_id - > 값을 param에 저장하고
		let param = $('#mem_id').val();
		$.ajax({
			//idchk
			url:"idchk?mem_id="+param,
			success:function(data){
				if(data == 1){
					$('#target').css('display','inline-block').
					css('color','red').html("사용중입니다");
				}else{
					$('#target').css('display','inline-block').
					css('color','blue').html("사용가능합니다");
				}
				
			}
		});
	});
});
</script>

