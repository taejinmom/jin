<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="mycontext" value="${pageContext.request.contextPath}" />
<%@include file="../temp/header.jsp"%>


<article>
	<header>
		<h1>Item Detail Demo</h1>

	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<!-- detail페이지 구매/장바구니/목록 -->
	<div>
		<form  method="post" name="purchase" id="purchase" >
			<!-- hidden으로 상품의 번호를 다음 페이지까지 보냄 -->
		<input type="hidden" id="i_no" name="i_no" value="${detail.i_no }">
		<div class="form-group">
			<label for="i_name">상품명</label> <input type="text"
				class="form-control" id="i_name" name="i_name"
				value="${detail.i_name }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="i_price">금액</label> <input type="text"
				class="form-control" id="i_price" name="i_price" readonly="readonly"
				value="${detail.i_price }">
		</div>
		<div class="form-group">
			<label for="i_category">분류</label> <input type="text"
				class="form-control" id="i_category" name="i_category"
				value="${detail.i_category }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="i_gender">gender</label> <input type="text"
				class="form-control" id="i_gender" name="i_gender"
				value="${detail.i_gender }" readonly="readonly">
		</div>
		
		<div class="form-group">
			<label for="imgn">이미지</label>
			<div>
				<img style="width: 200px;"
					src="${mycontext}/resources/item/${detail.i_img}">
			</div>
		</div>
		<!-- 상품 수량 고르기 -->
		<div class="form-group">
			<label for="num">재고 : ${detail.stockvo.s_stock }</label>
				<input type="number" id="num" name="num" max="${detail.stockvo.s_stock}" min="0" >
			</div>
		<div>
		
		<div class="form-group" id="target1"><!-- 총금액 나오는 구간 --></div>
			
		</div>
		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="submit" class="btn btn-primary" id="buybtn">구매</button><!-- 구매 폼으로 -->
		</div>
		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="submit" class="btn btn-primary" id="basketbtn">장바구니</button><!-- 장바구니 폼으로 -->
		</div>
		</form>
		</div>
		<!-- 상품리스트 페이지-> 남성/여성 으로 돌아가기-->
		<c:choose>
		<c:when test="${detail.i_gender=='여성' }">
		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="button" class="btn btn-primary" onclick="location.href='itemList?gender=w'">목록으로</button>
		</div>
		</c:when>
		<c:when test="${detail.i_gender=='남성' }">
		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="button" class="btn btn-primary" onclick="location.href='itemList?gender=m'">목록으로</button>
		</div>
		</c:when>
</c:choose>

</article>

<%@include file="../temp/footer.jsp"%>