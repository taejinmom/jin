<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<c:set var="mycontext" value="${pageContext.request.contextPath}"/>    
<div class="d-flex flex-row-reverse mybgColor">
<div class="p-2 bg-info"><a href="#" class="nav-link text-white" id="item1">Flex item 1</a></div>
<c:choose>
<c:when test="${sessionScope.sessionID == null }">
  <div class="p-2 bg-warning"><a href="${mycontext}/login/loginForm" class="nav-link text-white" id="item2">Login</a></div>
  <div class="p-2 bg-primary"><a href="${mycontext}/member/memberForm" class="nav-link text-white" id="item3">ȸ������</a></div>
</c:when>
<c:when test="${sessionScope.sessionID != null }">
  <div class="p-2 bg-warning"><a href="${mycontext}/login/logout" class="nav-link text-white" id="item2">Logout</a></div>
  <div class="p-2 bg-primary"><a href="${mycontext}/member/memberForm" class="nav-link text-white" id="item3">MyPage</a></div>
</c:when>
</c:choose>

</div>