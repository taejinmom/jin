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
 <%-- �����丵 �ؾ� �� --%>
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>��ȣ</th>
        <th>����</th>
        <th>�ۼ���</th>
        <th>��ȸ��</th>
        <th>�ۼ���¥</th>
      </tr>
    </thead>
    <tbody>
    <%-- for start --%>
     <c:forEach var="e" items="${list }">
      <tr>
        <td>${e.num }</td>
        <td><a href="boardDetail?num=${e.num }">${e.sub }</a></td>
        <td>${e.writer }</td>
        <td>${e.imgn }</td>
        <td>${e.udate}</td>
      </tr>
     </c:forEach>
        <%-- for end --%> 
    </tbody>
    <tfoot>
    <%-- Start! --%>
    <tr><td colspan="5" >${startPage}/${endPage }
<ol class="paging" >
<c:choose>
<c:when test="${startPage < 6}">
<li class="disable">��������</li>
</c:when>
<c:otherwise>
<li><a href="${pageContext.request.contextPath}/upload/upboardList?cPage=${nowPage-pagePerBlock}">��������</a></li>
</c:otherwise>
</c:choose>

<c:forEach varStatus="i" begin="${startPage}" end="${endPage }" step="1" >
	<c:choose>
	<c:when test="${i.index == nowPage}">
	 <li class="now">${i.index}</li>
	</c:when>
	<c:otherwise>
	<li><a href="${pageContext.request.contextPath}/upload/upboardList?cPage=${i.index}">${i.index}</a></li>
	</c:otherwise>
	</c:choose> 
</c:forEach>
<c:choose>
	<c:when test="${endPage >= totalPage }">
	<li class="disable">��������</li>
	</c:when>
	<c:when test="${totalPage > (nowPage+pagePerBlock)}">
	<li><li><a href="${pageContext.request.contextPath}/upload/upboardList?cPage=${nowPage+pagePerBlock }">��������</a></li>
	</c:when>
	<c:otherwise>
     <li><li><a href="${pageContext.request.contextPath}/upload/upboardList?cPage=${totalPage }">��������</a></li>
	</c:otherwise>
</c:choose>

</ol>
</td>
</tr>
    
    
    
    <%-- End ! --%>
    <%-- 
    <tr>
<th colspan="5" style="text-align: center; ">
      <ul class="pagination" style="margin:0 auto; width: 35%">
		  <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
		  <li class="page-item active" ><a class="page-link" href="#">1</a></li>
		  <li class="page-item"><a class="page-link" href="#">2</a></li>
		  <li class="page-item"><a class="page-link" href="#">3</a></li>
		  <li class="page-item"><a class="page-link" href="#">4</a></li>
		  <li class="page-item"><a class="page-link" href="#">5</a></li>
		  <li class="page-item"><a class="page-link" href="#">Next</a></li>
      </ul>
 </th>
      </tr>
      --%>
      <%--
    end
       --%>
       
       
       
      <tr><th colspan="5" >
       <form class="d-flex">
         <select class="form-control btn-mini" id="sel1" style="margin-left: 120px;">
		    <option>1</option>
		    <option>2</option>
		    <option>3</option>
		    <option>4</option>
  		</select>
        <input class="form-control me-2" type="text" placeholder="Search.." style="width: 300px">
        <button class="btn btn-outline-secondary" type="button">Search</button>
        </form>
      </th></tr>
      <tr><td colspan="5" style="text-align: right;">
      <!-- 
      jQuery�� ���ۼ� ������ �̵���Ű��
      id�� �ο��Ͽ� �����ڷ� selector�� ����ؼ� �̵���Ű��
      footer.jsp���� �ۼ�.
       -->      
      <button type="button" class="btn btn-outline-secondary" id="wbtn">���ۼ�</button>
      </td></tr>
    
    </tfoot>
  </table>
 
 <%-- �����丵 !!!!!!!! --%>
        </div>
 
    </article>
<%@include file="../temp/footer.jsp"%>