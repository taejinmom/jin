<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="../temp/header.jsp"%>

<article>
	<header>
		<h1>�ı� �ۼ� Form</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div class="container">
		<%--memberForm ��� �� �ڸ�. --%>
		<form action="reviewIn" method="post">
			<%-- ������� �����Ǹ� �޾ƿͼ� ������ �ʴ� �Ӽ����� reip �� �Ķ���ͷ� �����Ѵ�. --%>
			<input type="hidden" name="ord_no" value="${ord_no }">
			<input type="hidden" name="mem_no" value="${mem_no }">
			
			<%--��ǰ��ȣ, ����, ����, ���� --%>
			<div class="form-group">
				<label for="i_no">��ǰ��ȣ</label> 
				<input type="text" class="form-control"
					id="i_no" name="i_no" value="${i_no }" required="required" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="r_name">����</label> 
				<input type="text" class="form-control"
					id="r_name" placeholder="�ı� ������ �Է��ϼ���." name="r_name" required="required">
			</div>
			<div class="form-group">
				<label for=r_comm>����</label> 
				<input type="text" class="form-control"
					id="r_comm" name="r_comm" required="required">
			</div>
			<div class="form-group">
				<label for="r_score">����</label> 
				<input type="number" class="form-control"
					id="r_score" placeholder="�̸��� �Է��ϼ���." name="r_score" max="5" min="0" step="0.5" required="required">
			</div>

			<div class="form-group" style="text-align: right; margin-top: 10px;">
				<button type="submit" class="btn btn-primary">���</button>
			</div>
		</form>
	</div>
</article>







<%@include file="../temp/footer.jsp"%>