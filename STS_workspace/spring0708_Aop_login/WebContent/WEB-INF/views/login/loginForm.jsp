<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../temp/header.jsp"%>


<article>
	<header>
		<h1>Login Process Demo</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div class="container">
		<%-- view단에서 javascript : form, 태그 관련 유효성
		onsubmit : submit() 이벤트가 발생할 때 checkValue()를 호출한다
		login.LoginCheckController -> loginForm--%>
		<form action="loginProcess" method="post" id="loginInfo">
			<input type="hidden" name="reip"
				value="<%=request.getRemoteAddr()%>">
				
			<div class="form-group">
				<label for="id">ID</label>
				<!-- placeholder 속성 입력한 데이터가 없는 경우 배경으로 나타난다.실제적으로 입력을 100자까지로 지정 -->
				<!-- required 속성을 설정하면 필수입력 사항이된다. -->
				<!-- pattern 속성을 이용한 정규표현식으로 데이터의 유효성 검사를 할 수 있다. -->
				<input type="text" class="form-control" id="id"
					placeholder="아이디 입력(4-100)" name="id" maxlength="20"
					required="required" pattern=".{2,20}">
			</div>
			
			<div class="form-group">
				<label for="content">pwd</label>
				<!--  여러줄의 데이터를 입력하고 하고자 할때 textarea 태그를 사용한다. -->
				<!--  textarea 안에 있는 모든 글자는 그대로 나타난다. 공백문자, tag, enter -->
				<input type="password" class="form-control"  id="pwd" name="pwd"
					placeholder="*******">
			</div>
			
			<div class="form-group" style="text-align: right; margin-top: 10px;">
				<button type="submit" class="btn btn-primary">등록</button>		
				<button type="button" class="btn btn-primary">아이디/비밀번호 찾기</button>		
			</div>
			
		</form>
	</div>

</article>

<%@include file="../temp/footer.jsp"%>