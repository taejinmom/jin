<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../temp/header.jsp"%>


<article>
	<header>
		<h1>Item Detail Demo</h1>

	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	
	<div>
		<form action="purchaseForm" method="post" name="purchase" id="purchase" >
		<input type="hidden" id="i_no" name="i_no" value="${detail.i_no }">
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
			<label for="imgn">�̹���</label>
			<div>
				<img style="width: 200px;"
					src="${pageContext.request.contextPath}/resources/item/${detail.i_img}" alt="�̹��� �غ���">
			</div>
		</div>
		<div class="form-group">
			<label for="imgn">��� : ${detail.stockvo.s_stock }</label>
				<input type="number" id="num" name="num" max="${detail.stockvo.s_stock}" min="0" >
			</div>
		<div style="text-align: left;">
		<label>�� �ݾ�</label>
		<div class="form-group" id="target"></div>
			<div>
			<table class="table">
				<thead>
				<tr>
				<th>No</th>
				<th>item</th>
				<th>writer</th>
				<th>comment</th>
				<th>score</th>
				<th>date</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach var="review" items="${list}">
					<tr>
					<c:forEach var="member" items="${review.mvo }">
					<td><a href='${pageContext.request.contextPath}/review/reviewDetail=?${member.mem_name}'>${review.r_name }</a></td>
					<td>${review.r_num }</td>
					<td>${member.mem_name }</td>
					<td>${review.r_comm }</td>
					<td>${review.r_score }</td>
					<td>${review.r_date }</td>
					</c:forEach>
					</tr>					
					</c:forEach>
				</tbody>
			</table>
			</div>
		</div>
		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="button" class="btn btn-primary" id="buybtn">����</button>
		</div>
		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="button" class="btn btn-primary" id="basketbtn">��ٱ���</button>
		</div>
		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="submit" class="btn btn-primary" id="reviewbtn">���� �ۼ�</button>
		</div>
		
		</form>
		</div>
		<c:choose>
		<c:when test="${detail.i_gender=='����' }">
		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="button" class="btn btn-primary" onclick="location.href='itemList?gender=w'">�������</button>
		</div>
		</c:when>
		<c:when test="${detail.i_gender=='����' }">
		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="button" class="btn btn-primary" onclick="location.href='itemList?gender=m'">�������</button>
		</div>
		</c:when>
</c:choose>

</article>

<%@include file="../temp/footer.jsp"%>