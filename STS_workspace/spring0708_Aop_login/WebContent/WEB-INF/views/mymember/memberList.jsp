<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th>���̵�</th>
				<th>�̸�</th>
				<th>����</th>
				<th>����</th>
			</tr>
		</thead>
		<c:forEach var="m" items="${list }">
			<tbody>
				<tr>
					<td>${m.id}</td>
					<td>${m.name}</td>
					<td>${m.gender}</td>
					<td>${m.age}</td>
				</tr>
			</tbody>
		</c:forEach>
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
											href="${pageContext.request.contextPath}/member/memberList?cPage=${startPage-1}">��������</a></li>
									</c:otherwise>
								</c:choose>
								<!--        <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li> -->
								<c:forEach varStatus="i" begin="${startPage}" end="${endPage }"
									step="1">
									<c:choose>
										<c:when test="${i.index == nowPage}">
											<li class="page-item">${i.index}</li>
										</c:when>
										<c:otherwise>
											<li class="page-item"><a class="page-link"
												href="${pageContext.request.contextPath}/member/memberList?cPage=">${i.index}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>


								<!--           <li class="page-item active" ><a class="page-link" href="#">1</a></li> -->
								<!--           <li class="page-item"><a class="page-link" href="#">2</a></li> -->
								<!--           <li class="page-item"><a class="page-link" href="#">3</a></li> -->
								<!--           <li class="page-item"><a class="page-link" href="#">4</a></li> -->
								<!--           <li class="page-item"><a class="page-link" href="#">5</a></li> -->
								<c:choose>
									<c:when test="${endPage >= totalPage }">
										<li class="page-item">��������</li>
									</c:when>
									<c:when test="${totalPage > (nowPage+pagePerBlock)}">
										<li>
										<li><a class="page-link"
											href=""${pageContext.request.contextPath}/member/memberList?cPage="${endPage+1 }">��������</a></li>
									</c:when>
									<c:otherwise>
										<li>
										<li><a class="page-link" href="${pageContext.request.contextPath}/member/memberList?cPage=${totalPage}">��������</a></li>
									</c:otherwise>
								</c:choose>
								<!--           <li class="page-item"><a class="page-link" href="#">Next</a></li> -->
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
						<%-- jQuery�� ����ؼ� ���ۼ� ������ �̵���Ű��
              - id �߰��ϱ� : selector�� ����ؼ� �ڵ鸵
              - footer.jsp 
       --%>
						<button type="button" class="btn btn-outline-secondary" id="ebtn">���ۼ�</button>
					</td>
				</tr>
			</tfoot>
	</table>
</body>
</html>