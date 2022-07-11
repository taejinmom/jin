<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../temp/header.jsp"%>


<article>
	<header>
		<h1>UpBoard Demo</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div>
		<div class="form-group">
			<label for="sub">����</label>
			<!-- placeholder �Ӽ� �Է��� �����Ͱ� ���� ��� ������� ��Ÿ����.���������� �Է��� 100�ڱ����� ���� -->
			<!-- required �Ӽ��� �����ϸ� �ʼ��Է� �����̵ȴ�. -->
			<!-- pattern �Ӽ��� �̿��� ����ǥ�������� �������� ��ȿ�� �˻縦 �� �� �ִ�. -->
			<input type="text" class="form-control" id="sub" value="${uvo.sub }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="cont">����</label>
			<!--  �������� �����͸� �Է��ϰ� �ϰ��� �Ҷ� textarea �±׸� ����Ѵ�. -->
			<!--  textarea �ȿ� �ִ� ��� ���ڴ� �״�� ��Ÿ����. ���鹮��, tag, enter -->
			<textarea class="form-control" rows="5" id="cont" name="cont"
				readonly="readonly">${uvo.cont }</textarea>
		</div>
		<div class="form-group">
			<label for="writer">�ۼ���</label> <input type="text"
				class="form-control" id="writer" name="writer" value="${uvo.writer }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="udate">�ۼ���¥</label> <input type="text"
				class="form-control" id="bdate" name="udate" value="${uvo.udate }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="imgn">�̹���</label>
			<div><img style="width: 200px;" src="${pageContext.request.contextPath}/resources/imgfile/${uvo.imgn}"></div>
		</div>
		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="button" class="btn btn-primary" id="ubtn">�������</button>
		</div>
	</div>

</article>

<%@include file="../temp/footer.jsp"%>