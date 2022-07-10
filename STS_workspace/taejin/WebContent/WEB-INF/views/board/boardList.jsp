<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../temp/header.jsp"%>


<article>
	<header>
		<h1>Board Demo</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div>
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
						<td>${e.r_num }</td>
						<td><a href="boardDetail?num=${e.num}">${e.title}</a></td>
						<td>${e.writer }</td>
						<td>${e.view_cnt }</td>
						<td>${e.bdate }</td>
					</tr>
				</c:forEach>
				<%-- for end --%>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="3" style="text-align: center;">
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
										<li><a class="page-link"
											href="uplist?cPage=${endPage+1 }">��������</a></li>
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
					<th colspan="3">
						<form class="d-flex">
							<input class="form-control me-2" type="text"
								placeholder="Search.." style="width: 300px">
							<button class="btn btn-outline-secondary" type="button">Search</button>
						</form>
					</th>
				</tr>
				<tr>
					<td colspan="5" style="text-align: right;">
						<%-- jQuery�� ����ؼ� ���ۼ� ������ �̵���Ű��
              - id �߰��ϱ� : selector�� ����ؼ� �ڵ鸵
              - footer.jsp 
       --%>
						<button type="button" class="btn btn-outline-secondary" id="wbtn">���ۼ�</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>

</article>

<%@include file="../temp/footer.jsp"%>