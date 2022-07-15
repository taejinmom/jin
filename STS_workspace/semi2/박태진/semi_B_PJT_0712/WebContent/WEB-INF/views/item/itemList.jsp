<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="mycontext" value="${pageContext.request.contextPath}" />
<%@include file="../temp/header.jsp"%>
<article>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>��ȣ</th>
				<th>����</th>
				<th>��ǰ��</th>
				<th>ī�װ�</th>
				<th>����</th>
			</tr>
		</thead>
		<tbody>
			<%-- for start --%>
			<c:forEach var="e" items="${list}">
				<tr>
					<td>${e.i_no}</td>
					<td><a href="itemDetail?s_no=${e.i_no}">${e.i_name}</a></td>
					<td>${e.i_price}</td>
					<td>${e.i_category}</td>
					<td><img src="${mycontext}/resources/item/${e.i_img}"
						style="width: 200px"></td>
				</tr>
			</c:forEach>
			<%-- for end --%>
		</tbody>
		<tfoot>
			<tr>
				<th colspan="5" style="text-align: center;">
					<nav aria-label="Page navigation example">
						<ul class="pagination pagination-sm"
							style="margin: auto; width: 60%">
							<c:choose>
								<c:when test="${startPage < 6}">
									<li class="page-item disabled">��������</li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="boardList?cPage=${startPage-1}">��������</a></li>
								</c:otherwise>
							</c:choose>
							<c:forEach varStatus="i" begin="${startPage}" end="${endPage }"
								step="1">
								<c:choose>
									<c:when test="${i.index == nowPage}">
										<li class="page-item">${i.index}</li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="boardList?cPage=${i.index}">${i.index}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>

							<c:choose>
								<c:when test="${endPage >= totalPage }">
									<li class="page-item">��������</li>
								</c:when>
								<c:when test="${totalPage > (nowPage+pagePerBlock)}">
									<li>
									<li><a class="page-link" href="uplist?cPage=${endPage+1 }">��������</a></li>
								</c:when>
								<c:otherwise>
									<li>
									<li><a class="page-link" href="uplist?cPage=${totalPage}">��������</a></li>
								</c:otherwise>
							</c:choose>
						</ul>
					</nav>
				</th>
			</tr>
			
			<tr>
				<th colspan="5">
					<form class="d-flex">
						<input class="form-control me-2" type="text"
							placeholder="Search.." style="width: 300px">
						<button class="btn btn-outline-secondary" type="button">Search</button>
					</form>
				</th>
			</tr>
			<tr>
				<td colspan="5" style="text-align: right;">
					<button type="button" class="btn btn-outline-secondary" id="wbtn">���ۼ�</button>
				</td>
			</tr>
		</tfoot>
	</table>
</article>
<%@include file="../temp/footer.jsp"%>
