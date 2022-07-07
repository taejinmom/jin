<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="navigation">
	<ul>
		<li><a href="#">Home</a></li>
		<c:choose>
			<c:when test="${sessionScope.sessionID == null}">
				<li><a href="javascript:changeView(1)">로그인</a></li>
				<li><a href="javascript:changeView(2)">회원가입</a></li>
			</c:when>
			<c:when test="${sessionScope.sessionID != null}">
				<li><a href="javascript:changeView(3)">로그아웃</a></li>
				<li><a href="javascript:changeView(4)">마이페이지</a></li>
			</c:when>
			
		</c:choose>
		<li><a href="javascript:changeView(6)">게시판</a></li>
		<li><a href="#">방명록</a></li>
		<c:if test="${sessionScope.sessionID != null}">
		<li>${sessionScope.sessionName}님 반갑습니다</li>
		</c:if>
	</ul>
</div>
<script>
function changeView(value){
	
	if(value == "0") // HOME 버튼 클릭시 첫화면으로 이동
	{
		location.href="MainForm.do";
	}
	else if(value == "1") // 로그인 버튼 클릭시 로그인 화면으로 이동
	{	
		location.href="LoginForm.kosmo?cmd=loginForm";
	}
	else if(value == "2") // 회원가입 버튼 클릭시 회원가입 화면으로 이동
	{	
		location.href="memberForm";
	}
	else if(value == "3") // 로그아웃 버튼 클릭시 로그아웃 처리
	{
		location.href="MemberLogoutAction.kosmo?cmd=MemberLogoutAction";
	}
	else if(value == "4") // 내정보 버튼 클릭시 회원정보 보여주는 화면으로 이동
	{
		location.href="MemberInfoAction.do";
	}
	else if(value == "5")
	{
		location.href="MemberListAction.do";
	}
	else if(value == "6")
	{
		location.href="BoardListAction.kosmo?cmd=BoardListAction";
	}
	else if(value == "7")
	{	
		location.href="GuestbookListAction.ge";
	}
}
</script>