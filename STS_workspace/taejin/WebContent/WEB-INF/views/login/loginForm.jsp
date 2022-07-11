<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../temp/header.jsp"%>


<article>
	<header>
		<h1>LoginProcess Demo</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div class="container">
		<%-- View 단에서 javascript : form 태그 관련 유효성
		onsubmit : submit() 이벤트가 발생할 때 checkValue()를 호출한다.
		login.LoginCheckController - /loginForm
		--%>
		<form action="loginProcess" method="post" id="loginInfo" onsubmit="return checkValue()">
			<input type="hidden" name="reip"
				value="<%=request.getRemoteAddr()%>">
			<div class="form-group">
				<label for="id">ID</label>
				<input type="text" class="form-control" id="id"
					placeholder="아이디 입력" name="id" maxlength="10"
					required="required" pattern=".{2,10}">
			</div>
			<div class="form-group">
				<label for="pwd">PASSWORD</label>
				<input type="password" class="form-control" id="pwd"
					placeholder="******" name="pwd" required="required">
			</div>
			<div class="form-group" style="text-align: right; margin-top: 10px;">
				<button type="submit" class="btn btn-primary">등록</button>&nbsp;
				<button type="button" class="btn btn-primary">아이디/비밀번호 찾기</button>	
			</div>
		</form>
	</div>

</article>

<%@include file="../temp/footer.jsp"%>