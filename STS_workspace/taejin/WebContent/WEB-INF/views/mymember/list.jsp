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
	</table>
</body>
</html>