<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../temp/header.jsp"%>

<article>
	<header>
		<h1>회원가입 Demo</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div>
		<%-- memberForm 들어갈 자리 --%>
		<form action="memberIn" method="post">
			<input type="hidden" name="reip" value="<%=request.getRemoteAddr()%>">
			<div class="form-group">
				<label for="id" style="display: block">아이디 </label>
				<!-- placeholder 속성 입력한 데이터가 없는 경우 배경으로 나타난다.실제적으로 입력을 100자까지로 지정 -->
				<!-- required 속성을 설정하면 필수입력 사항이된다. -->
				<!-- pattern 속성을 이용한 정규표현식으로 데이터의 유효성 검사를 할 수 있다. -->
				<input type="text" class="form-control" id="id"
					placeholder="아이디 입력(5-10)" name="id" maxlength="10"
					required="required" pattern=".{5,10}" style="float: left; width: 80%; margin-right: 10px;">
				<button type="button" class="btn btn-primary" id="btn1">중복 확인</button>
				<div id="target"></div>
			</div>
			<div class="form-group">
				<label for="pwd">비밀번호 </label> <input type="password"
					class="form-control" id="pwd" placeholder="비밀번호(2자-10자)" name="pwd"
					required="required">
			</div>
			<div class="form-group">
				<label for="name">이름 </label> <input type="text"
					class="form-control" id="name" placeholder="이름을 입력하세요." name="name"
					required="required">
			</div>
			<div class="form-group">
				<label for="gender">성별 </label>
				<div>
					<input type="radio" name="gender" id="gender1"
						value="남자" checked="checked">
					<label class="form-check-label" for="gender1">남자</label>
				</div>
				<div>
					<input type="radio" name="gender" id="gender2"
						value="여자">
					<label class="form-check-label" for="gender2">여자</label>
				</div>
			</div>
			<div class="form-group">
				<label for="age">나이 </label> <input type="text" class="form-control"
					id="age" placeholder="나이를 입력하세요." name="age" required="required">
			</div>
			<div class="form-group" style="text-align: right; margin-top: 10px;">
				<button type="submit" class="btn btn-primary">등록</button>
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

</article>

<%@include file="../temp/footer.jsp"%>
<%-- 편집구간 끝 --%>