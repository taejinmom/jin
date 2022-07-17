<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="mycontext" value="${pageContext.request.contextPath}" />
<%@include file="../temp/header.jsp"%>
    <article>
	<header>
		<h1>OrdersForm Demo</h1>
	</header>
	
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	
	<form method="post" id="orderform" action="${mycontext}/orders/orderIn">
	<div>
		<div class="form-group">
			<label for="i_name">��ǰ��</label> <input type="text"
				class="form-control" id="i_name" name="i_name"
				value="${detail.i_name }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="i_price">�ݾ�</label> <input type="text"
				class="form-control" id="i_price" name="i_price" readonly="readonly"
				value="${detail.i_price }">
		</div>
		<div class="form-group">
			<label for="i_category">�з�</label> <input type="text"
				class="form-control" id="i_category" name="i_category"
				value="${detail.i_category }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="i_gender">gender</label> <input type="text"
				class="form-control" id="i_gender" name="i_gender"
				value="${detail.i_gender }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="number">����</label> <input type="text"
				class="form-control" id="number" name="number"
				value="${stock }" readonly="readonly"></div>
		</div>
		
								<!--����ڿ��� �Է� �޴� ����  -->
		<input type="hidden" id="i_no" name="i_no" value="${detail.i_no }">
		<div class="form-group">
			<label for="ord_name">�ֹ��� �̸�</label> <input type="text"
				class="form-control" id="ord_name" name="ord_name"
				>
		</div><div class="form-group">
			<label for="ord_address">�ּ�</label> <input type="text"
				class="form-control" id="ord_address" name="ord_address">
		</div>
									<!-- ���� ���� �ݾ� -->
		<div id="target2" style="text-align: right;"><h2> total()</h2></div>	
									<!-- ��ư -->
		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="submit" class="btn btn-primary" >����</button>
			<button type="button" class="btn btn-primary" 
			onclick="location.href='${mycontext}/item/itemDetail?s_no=${detail.i_no}'">���</button>
		</div>
		
		</form>
		
		</article>

<%@include file="../temp/footer.jsp"%>