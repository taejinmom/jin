<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<jsp:include page="../head.jsp"/>
<jsp:include page="../menu.jsp"/>

    <div id="article">
        <div id="header2">
            <h1>Article Heading</h1>
            <p id="time">Oct 1th, 2011</p>
        </div>
<%-- Content 내용 들어 갈 자리 --%>        
     <table style="width: 30%; margin: auto">
   		<tr>
   		   <td>가입날짜</td>
   		   <td style="color:red">
   		   		${today }
   		   </td>
   		 </tr>
   		 	<tr>
   		   <td>아이디</td>
   		   <td>
   		   		${mid}
   		   </td>
   		 </tr>
   		  <tr><td colspan="2" style="text-align: center">
   		  <input type="button" value="로그인하기">
   		  </td></tr>
   </table>
<%-- Content 내용 들어 갈 자리 --%>                  


    </div>

    <div id="aside">
        <div id="header5">
            <h1>Siderbar Heading</h1>
        </div>
        <p>문서의 주 내용이 아닌 관련성이 낮은 내용들은 aside로 표시할 수 있다.
		본문과 직접적으로 상관이 없는 관련 사이트 링크나 안내글, nav 요소의 그룹 등이 aside 요소로 기술 될 수 있다.
		보통 블로그에서 좌우측 사이드바를 의미하는 것으로서 사이드바의 특성으로 볼때 필수적이지 않아서 표시를 해도 되고 안 해도 되는 내용들 또는 광고물같은 내용들이 자리할 수 있다.</p>

    </div>

    <div id="footer4">
        Page Footer
    </div>
</body>
</html>