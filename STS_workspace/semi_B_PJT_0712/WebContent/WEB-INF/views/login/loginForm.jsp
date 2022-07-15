<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../temp/header.jsp"%>
<article >
        <header>
            <h1>�α��� Demo</h1>
        </header>
        <ul class="list-unstyled"><li class="border-top my-3"></li></ul>
        <div class="container">
 <%--memberForm ��� �� �ڸ�. --%>
 <form action="loginInIn" method="post">
 <%-- ������� �����Ǹ� �޾ƿͼ� ������ �ʴ� �Ӽ����� reip �� �Ķ���ͷ� �����Ѵ�. --%>
 
    <div class="form-group">
      <label for="mem_id">���̵� </label>
<!-- placeholder �Ӽ� �Է��� �����Ͱ� ���� ��� ������� ��Ÿ����.���������� �Է��� 100�ڱ����� ���� -->
<!-- required �Ӽ��� �����ϸ� �ʼ��Է� �����̵ȴ�. -->
<!-- pattern �Ӽ��� �̿��� ����ǥ�������� �������� ��ȿ�� �˻縦 �� �� �ִ�. -->
      <input type="text" class="form-control" id="mem_id"
       placeholder="���̵� �Է�(5-10)" name="mem_id"
       maxlength="10" required="required"
       pattern=".{1,10}">
   	 <div id="target"></div>
    </div>
    <div class="form-group">
      <label for="mem_pw">��й�ȣ</label>
      <input type="password" class="form-control" id="mem_pw"
        name="mem_pw" required="required"  placeholder="*******">
    </div> 
    
     <div class="form-group" style="text-align: right; margin-top: 10px;">
      <button type="submit" class="btn btn-primary">���</button>
    </div>
  </form>

</div>
 
    </article>
<%@include file="../temp/footer.jsp"%>    
