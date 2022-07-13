<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../temp/header.jsp"%>
<article >
        <header>
            <h1>로그인 Demo</h1>
        </header>
        <ul class="list-unstyled"><li class="border-top my-3"></li></ul>
        <div class="container">
 <%--memberForm 들어 갈 자리. --%>
 <form action="loginInIn" method="post">
 <%-- 사용자의 아이피를 받아와서 보이지 않는 속성으로 reip 란 파라미터로 지정한다. --%>
 
    <div class="form-group">
      <label for="mem_id">아이디 </label>
<!-- placeholder 속성 입력한 데이터가 없는 경우 배경으로 나타난다.실제적으로 입력을 100자까지로 지정 -->
<!-- required 속성을 설정하면 필수입력 사항이된다. -->
<!-- pattern 속성을 이용한 정규표현식으로 데이터의 유효성 검사를 할 수 있다. -->
      <input type="text" class="form-control" id="mem_id"
       placeholder="아이디 입력(5-10)" name="mem_id"
       maxlength="10" required="required"
       pattern=".{1,10}">
   	 <div id="target"></div>
    </div>
    <div class="form-group">
      <label for="mem_pw">비밀번호</label>
      <input type="password" class="form-control" id="mem_pw"
        name="mem_pw" required="required"  placeholder="*******">
    </div> 
    
     <div class="form-group" style="text-align: right; margin-top: 10px;">
      <button type="submit" class="btn btn-primary">등록</button>
    </div>
  </form>

</div>
 
    </article>
<%@include file="../temp/footer.jsp"%>    
