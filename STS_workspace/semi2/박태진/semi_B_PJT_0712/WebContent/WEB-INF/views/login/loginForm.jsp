<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../temp/header.jsp"%>

    <article >
        <header>
            <h1>LoginProcess Demo</h1>
        </header>
        <ul class="list-unstyled"><li class="border-top my-3"></li></ul>
        <div class="container">
<%-- View�ܿ��� javascript : form �±� ���� ��ȿ��  
onsubmit : submit() �̺�Ʈ�� �߻� �� �� checkValue()�� ȣ�� �Ѵ�.
login.LoginCheckController -> /loginForm 
--%>
 <form action="loginProcess" method="post" >
 <input type="hidden" name="reip" value="<%=request.getRemoteAddr()%>">
    <div class="form-group">
      <label for="mem_id">ID</label>
      <input type="text" class="form-control" id="mem_id"
       placeholder="���̵� �Է�" name="mem_id"
       maxlength="10" required="required"
       pattern=".{2,10}">
    </div>
    <div class="form-group">
      <label for="mem_pw">PWD</label>
      <input type="password" class="form-control" id="mem_pw"
       placeholder="******" name="mem_pw"
       maxlength="10" required="required"
       pattern=".{2,10}">
    </div>
     <div class="form-group" style="text-align: right; margin-top: 10px;">
      <button type="submit" class="btn btn-primary">���</button>
      <button type="button" class="btn btn-primary">���̵�/���ã��</button>
    </div>
  </form>

</div>
 
    </article>
<%@include file="../temp/footer.jsp"%>