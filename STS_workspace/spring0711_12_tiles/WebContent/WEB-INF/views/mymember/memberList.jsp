<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../temp/header.jsp"%>
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
        <header>
            <h1>UpBoard Demo</h1>
        </header>
        <ul class="list-unstyled"><li class="border-top my-3"></li></ul>
        <div>
<table class="table table-bordered">
<thead>
   <tr>
		<th >번호</th>
		<th >아이디</th>
		<th >이름</th>
		<th >성별</th>
		<th >가입날짜</th>
	</tr>
</thead>
<tbody>
<c:forEach var="e" items="${list }">
<tr>
<td class="align-middle text-center">${e.mnum }</td>
<td class="text-center">${e.id }</td>
<td class="align-middle"> ${e.name }</td>
<td class="align-middle"> ${e.gender }</td>
<td class="align-middle"> ${e.mdate }</td>
</tr>
</c:forEach>
</tbody>
<tfoot>
<tr><td colspan="5" >${startPage}/${endPage }
<ol class="paging" >
<c:choose>
<c:when test="${startPage < 6}">
<li class="disable">이전으로</li>
</c:when>
<c:otherwise>
<li><a href="${pageContext.request.contextPath}/member/memberList?cPage=${nowPage-pagePerBlock}">이전으로</a></li>
</c:otherwise>
</c:choose>

<c:forEach varStatus="i" begin="${startPage}" end="${endPage }" step="1" >
	<c:choose>
	<c:when test="${i.index == nowPage}">
	 <li class="now">${i.index}</li>
	</c:when>
	<c:otherwise>
	<li><a href="${pageContext.request.contextPath}/member/memberList?cPage=${i.index}">${i.index}</a></li>
	</c:otherwise>
	</c:choose> 
</c:forEach>
<c:choose>
	<c:when test="${endPage >= totalPage }">
	<li class="disable">다음으로</li>
	</c:when>
	<c:when test="${totalPage > (nowPage+pagePerBlock)}">
	<li><li><a href="${pageContext.request.contextPath}/member/memberList?cPage=${nowPage+pagePerBlock }">다음으로</a></li>
	</c:when>
	<c:otherwise>
     <li><li><a href="${pageContext.request.contextPath}/member/memberList?cPage=${totalPage }">다음으로</a></li>
	</c:otherwise>
</c:choose>

</ol>
</td>
</tr>
</tfoot>
</table>
        </div>
 
    </article>
<%@include file="../temp/footer.jsp"%>