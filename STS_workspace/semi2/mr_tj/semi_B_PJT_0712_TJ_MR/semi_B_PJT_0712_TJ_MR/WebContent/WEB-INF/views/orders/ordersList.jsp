<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../temp/header.jsp"%>
<c:set var="mycontext" value="${pageContext.request.contextPath}"/>

<style>
	a:link{text-decoration: none;}
	table img { width: 80px;}
		/* paging */
	
	table tfoot ol.paging {
		margin-left:30%;
	    list-style:none;
	}
	
	table tfoot ol.paging li {
	    float:left;
	    margin-right:8px;
	}
	
	table tfoot ol.paging li a {
	    display:block;
	    padding:3px 7px;
	    border:1px solid #00B3DC;
	    color:#2f313e;
	    font-weight:bold;
	}
	
	table tfoot ol.paging li a:hover {
	    background:#00B3DC;
	    color:white;
	    font-weight:bold;
	}
	
	.disable {
	    padding:3px 7px;
	    border:1px solid silver;
	    color:silver;
	}
	
	.now {
	   padding:3px 7px;
	    border:1px solid #ff4aa5;
	    background:#ff4aa5;
	    color:white;
	    font-weight:bold;
	}
</style>

<article >
	<script>
        console.log(${startPage});
        console.log(${endPage});
        console.log(${nowPage});
        console.log(${pagePerBlock});
        console.log(${totalPage});
	</script>
	
        <header>
            <h1>Orders List</h1>
        </header>
        <ul class="list-unstyled"><li class="border-top my-3"></li></ul>
<div>

 <%-- 리팩토링 해야 함 --%>
  <table class="table table-bordered" style="text-align: center;">
    <thead>
      <tr>
      <c:choose>
      <%-- 관리자 로그인 시 구매목록 컬럼 --%>
      <c:when test="${sessionScope.sessionId == 'admin' }">
      	<th>No</th>
        <th>주문 번호</th>
        <th>주문인</th>
        <th>회원 이름</th>
        <th>상품명</th>
        <th>주문 수량</th>
        <th>총 주문 금액</th>
        <th>주문 상태</th>
        <th>수령 장소</th>
        <th>주문날짜</th>
        <th>수령날짜</th>
      </c:when>
      <%-- 일반회원 로그인 시 구매목록 컬럼 
      	 주문번호, 상품명, 수량, 총 금액, 주문상태
      --%>
      <c:otherwise>
        <th>No</th>
        <th>주문 번호</th>
        <th>상품명</th>
        <th>주문 수량</th>
        <th>총 주문 금액</th>
        <th>주문 상태</th>
        </c:otherwise>
      </c:choose>
      </tr>
    </thead>
    
    <tbody>
    <%-- for start --%>
     <c:forEach var="e" items="${list }">
      <tr>
          <c:choose>
          <%-- 관리자 로그인 시 구매목록 컬럼 --%>
	      <c:when test="${sessionScope.sessionId == 'admin' }">
        	<td>${e.r_num }</td>
        	<td>${e.ord_no }</td>
	        <td><a href="${mycontext }/review/reviewForm?num=${e.i_no }">${e.ord_name }</a></td>
	        <td>${e.mvo.mem_name }</td>
	        <td>${e.ivo.i_name }</td>
        	<td>${e.ord_count }</td>
	        <td>${e.totalPrice }</td>
	        <td><select id="i_status" name="i_status">
	        	<option value="stSend">발송완료</option>
	        	<option value="stIng">배송 중</option>
	        	<option value="stSucc">배송 완료</option>
	        	<option value="stCal">주문 취소</option>
        	</select>
        	</td>
        	<td>${e.ord_address}</td>
	        <td>${e.ord_date }</td>
	        <td>${e.ord_edate }</td>
	      </c:when>
	      <%-- 일반회원 로그인 시 구매목록 컬럼 
	      	 주문번호, 상품명, 수량, 총 금액, 주문상태
	      --%>
	      <c:otherwise>
	      <td>${e.r_num }</td>
	        <td>${e.ord_no }</td>
	        <td>${e.ivo.i_name }</td>
	        <td>${e.ord_count }</td>
	        <td>${e.totalPrice }</td>
	        <td>${e.i_status }</td>
	      </c:otherwise>
          </c:choose>
      </tr>
     </c:forEach>
     <%-- for end --%> 
    </tbody>
    
<tfoot>
<%-- Start! --%>
<tr><td colspan="8" >
<ol class="paging" >
<c:choose>
<c:when test="${startPage < 6}">
<li class="disable">이전으로</li>
</c:when>
<c:otherwise>
<li><a href="ordersList?cPage=${nowPage-pagePerBlock}">이전으로</a></li>
</c:otherwise>
</c:choose>

<c:forEach varStatus="i" begin="${startPage}" end="${endPage }" step="1" >
	<c:choose>
	<c:when test="${i.index == nowPage}">
	 <li class="now">${i.index}</li>
	</c:when>
	<c:otherwise>
	<li><a href="ordersList?cPage=${i.index}">${i.index}</a></li>
	</c:otherwise>
	</c:choose> 
</c:forEach>
<c:choose>
	<c:when test="${endPage >= totalPage }">
	<li class="disable">다음으로</li>
	</c:when>
	<c:when test="${totalPage > (nowPage+pagePerBlock)}">
	<li><li><a href="ordersList?cPage=${nowPage+pagePerBlock }">다음으로</a></li>
	</c:when>
	<c:otherwise>
     <li><li><a href="ordersList?cPage=${totalPage }">다음으로</a></li>
	</c:otherwise>
</c:choose>

</ol>
</td>
</tr>
<tr>
<td colspan="8" >
  <form action="memberList" method="get">
	<input class="form-control me-2" type="text" id="search" name="search" value="${search}" placeholder="Search.." style="width: 300px; float: left;">
	<button class="btn btn-outline-secondary" type="submit" id="searchBtn">Search</button>
<%-- 	<input type="hidden" id="search" name="search" value="${search}"> --%>
  </form>
</td>
</tr>

</tfoot>
</table>

</div>
</article>

<div class="form-group" style="text-align: right; margin-right: 20px;">
  <c:choose>
  <c:when test="${sessionScope.sessionId == 'admin' }">
	<input type="button" value="삭제" id="ordDelBtn" class="btn btn-primary">
	<input type="button" value="수정" id="ordUpBtn" class="btn btn-primary">
  </c:when>
  </c:choose>
</div>

<%@include file="../temp/footer.jsp"%>

<script>
	$(function () {
		$('#ordDelBtn').click(function() {
			location = "";
		});
	});



</script>




