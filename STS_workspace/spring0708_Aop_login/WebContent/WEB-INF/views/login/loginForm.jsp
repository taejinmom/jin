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
		<%-- view�ܿ��� javascript : form, �±� ���� ��ȿ��
		onsubmit : submit() �̺�Ʈ�� �߻��� �� checkValue()�� ȣ���Ѵ�
		login.LoginCheckController -> loginForm--%>
		<form action="loginProcess" method="post" id="loginInfo">
			<input type="hidden" name="reip"
				value="<%=request.getRemoteAddr()%>">
				
			<div class="form-group">
				<label for="id">ID</label>
				<!-- placeholder �Ӽ� �Է��� �����Ͱ� ���� ��� ������� ��Ÿ����.���������� �Է��� 100�ڱ����� ���� -->
				<!-- required �Ӽ��� �����ϸ� �ʼ��Է� �����̵ȴ�. -->
				<!-- pattern �Ӽ��� �̿��� ����ǥ�������� �������� ��ȿ�� �˻縦 �� �� �ִ�. -->
				<input type="text" class="form-control" id="id"
					placeholder="���̵� �Է�(4-100)" name="id" maxlength="20"
					required="required" pattern=".{2,20}">
			</div>
			
			<div class="form-group">
				<label for="content">pwd</label>
				<!--  �������� �����͸� �Է��ϰ� �ϰ��� �Ҷ� textarea �±׸� ����Ѵ�. -->
				<!--  textarea �ȿ� �ִ� ��� ���ڴ� �״�� ��Ÿ����. ���鹮��, tag, enter -->
				<input type="password" class="form-control"  id="pwd" name="pwd"
					placeholder="*******">
			</div>
			
			<div class="form-group" style="text-align: right; margin-top: 10px;">
				<button type="submit" class="btn btn-primary">���</button>		
				<button type="button" class="btn btn-primary">���̵�/��й�ȣ ã��</button>		
			</div>
			
		</form>
	</div>

</article>

<%@include file="../temp/footer.jsp"%>