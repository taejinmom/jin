<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- Include meta tag to ensure proper rendering and touch zooming -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Include jQuery Mobile stylesheets -->
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<!-- Include the jQuery library -->
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<!-- Include the jQuery Mobile library -->
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
	<div data-role="page">
		<div data-role="header">
			<h1>Mobile Page</h1>
			<a href="#" class="ui-btn ui-btn-inline">홈</a>
			<button class="ui-btn ui-btn-inline">가입</button>
		</div>
		<!-- /header -->
		<div role="main" class="ui-content">
			<p>Page content goes here.</p>
			<div data-role="collapsible" data-mini="true">
				<h4>Heading</h4>
				
				<ul data-role="listview">
				<c:forEach var="listv" items="${list}">
					<%--<li><a href="#"><img src="../_assets/img/album-bb.jpg">
					<h2>Broken Bells</h2>
					<p>Broken Bells</p></a>
					</li> --%>
                 <li><a href="detail.kosmo?num=${listv.num }
					&query=playDetail">
					<img src="${pageContext.request.contextPath}/resources/imgfile/${listv.imgn }">
					<h2>${listv.sub }</h2></a></li>
				</c:forEach>
				</ul>
				
			</div>
			<a href="#" class="ui-btn ui-icon-delete ui-btn-icon-left">camera</a>
			<input type="file" accept="image/*" capture="camera" />
		</div>
		<!-- /content -->
		<div data-role="footer">
			<h4>Page Footer</h4>
		</div>
		<!-- /footer -->
	</div>
	<!-- /page -->

</body>
</html>