<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="navigation">
	<ul>
		<li><a href="#">Home</a></li>
		<c:choose>
			<c:when test="${sessionScope.sessionID == null}">
				<li><a href="javascript:changeView(1)">�α���</a></li>
				<li><a href="javascript:changeView(2)">ȸ������</a></li>
			</c:when>
			<c:when test="${sessionScope.sessionID != null}">
				<li><a href="javascript:changeView(3)">�α׾ƿ�</a></li>
				<li><a href="javascript:changeView(4)">����������</a></li>
			</c:when>
			
		</c:choose>
		<li><a href="javascript:changeView(6)">�Խ���</a></li>
		<li><a href="#">����</a></li>
		<c:if test="${sessionScope.sessionID != null}">
		<li>${sessionScope.sessionName}�� �ݰ����ϴ�</li>
		</c:if>
	</ul>
</div>
<script>
function changeView(value){
	
	if(value == "0") // HOME ��ư Ŭ���� ùȭ������ �̵�
	{
		location.href="MainForm.do";
	}
	else if(value == "1") // �α��� ��ư Ŭ���� �α��� ȭ������ �̵�
	{	
		location.href="LoginForm.kosmo?cmd=loginForm";
	}
	else if(value == "2") // ȸ������ ��ư Ŭ���� ȸ������ ȭ������ �̵�
	{	
		location.href="memberForm";
	}
	else if(value == "3") // �α׾ƿ� ��ư Ŭ���� �α׾ƿ� ó��
	{
		location.href="MemberLogoutAction.kosmo?cmd=MemberLogoutAction";
	}
	else if(value == "4") // ������ ��ư Ŭ���� ȸ������ �����ִ� ȭ������ �̵�
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