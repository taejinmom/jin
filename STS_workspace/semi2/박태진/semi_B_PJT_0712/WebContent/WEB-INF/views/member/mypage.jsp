<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@include file="../temp/header.jsp"%>
<article >
        <header>
            <h1>MyPage Demo</h1>
        </header>
        <ul class="list-unstyled"><li class="border-top my-3"></li></ul>
        <div class="container">
        <%-- mypageForm ��� �� �ڸ�. --%>
        
 <form action="updateIn" method="post" id="updateform" name="updateform">
    <div class="form-group">
      <label for="mem_id">ID</label>
      <input type="text" class="form-control" id="mem_id"
       readonly="readonly" value="${vo.mem_id }"  name="mem_id">
    </div>
    <div class="form-group">
      <label for="mem_pw">PW</label>
      <input type="password" class="form-control" id="mem_pw"
       placeholder="****" name="mem_pw" value="${vo.mem_pw}">
    </div>
    
    <div class="form-group">
   <label for="mem_name">�̸�</label>

   <input type="text" class="form-control"  id="mem_name"
    name="mem_name" placeholder="���� �̸� : ${vo.mem_name}" value="${vo.mem_name}">
   </div>
    <div class="form-group">
      <label for="mem_adr">�ּ�</label>
      <input type="text" class="form-control" id="mem_adr"
       placeholder="���� �ּ� : ${vo.mem_adr}" name="mem_adr" value="${vo.mem_adr}">
    </div>
    <div class="form-group">
      <label for="mem_phone">��ȭ��ȣ</label>
      <input type="text" class="form-control" id="mem_phone"
      readonly="readonly" value="${vo.mem_phone }" name="mem_phone" ">
    </div>
     <div class="form-group" style="text-align: right; margin-top: 10px;">
      <input type="button" class="btn btn-primary" id="btn0" value="����">
    </div>
  </form>

</div>
 
    </article>
<p>
	<input type="button" value="Home" onclick="location.href='/main'">
</p>

<%@include file="../temp/footer.jsp"%>