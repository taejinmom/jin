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
<%-- Content ���� ��� �� �ڸ� --%>        
     <table style="width: 30%; margin: auto">
   		<tr>
   		   <td>���Գ�¥</td>
   		   <td style="color:red">
   		   		${today }
   		   </td>
   		 </tr>
   		 	<tr>
   		   <td>���̵�</td>
   		   <td>
   		   		${mid}
   		   </td>
   		 </tr>
   		  <tr><td colspan="2" style="text-align: center">
   		  <input type="button" value="�α����ϱ�">
   		  </td></tr>
   </table>
<%-- Content ���� ��� �� �ڸ� --%>                  


    </div>

    <div id="aside">
        <div id="header5">
            <h1>Siderbar Heading</h1>
        </div>
        <p>������ �� ������ �ƴ� ���ü��� ���� ������� aside�� ǥ���� �� �ִ�.
		������ ���������� ����� ���� ���� ����Ʈ ��ũ�� �ȳ���, nav ����� �׷� ���� aside ��ҷ� ��� �� �� �ִ�.
		���� ��α׿��� �¿��� ���̵�ٸ� �ǹ��ϴ� �����μ� ���̵���� Ư������ ���� �ʼ������� �ʾƼ� ǥ�ø� �ص� �ǰ� �� �ص� �Ǵ� ����� �Ǵ� �������� ������� �ڸ��� �� �ִ�.</p>

    </div>

    <div id="footer4">
        Page Footer
    </div>
</body>
</html>