   <%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <c:set var="mycontext" value="${pageContext.request.contextPath}" />
   
    <footer class="mt-5 text-white text-center mybgColor">
        Page Footer
    </footer>
<script>
	<%-- ��ũ��Ʈ ����--%>
	$(function() {
		<%-- mypage���� �����ϴ� ��ư--%>
		$('#bbtn').click(function () {
			location="purchaseForm";
		});
		$('#num').change(function() {
		let price= $('#i_price').val();
		var number = $('#num').val();
			console.log('price ='+price);
			console.log('number ='+number);
		
		$.ajax({
			url:"numchk?num="+number,
		success:function(data){
			console.log(data);
			var total = data * price;
			
			$('#target').html(total.toLocaleString('ko-KR')+ "��");
		}

		
	});
		});
		<%--��ٱ��Ϸ� �̵�  --%>
		$('#basketbtn').click(function() {
			$('#purchase').attr("action", "${mycontext}/basket/addBasket");
			$('#purchase').submit(function() {
				alert('��ٱ��Ͽ� �����ϴ�!');
			});
		});
		<%--������������ �̵�  --%>
		$('#buybtn').click(function() {
			$('#purchase').attr("action", "order");
			$('#purchase').submit(function() {
				alert('���� �������� �̵��մϴ�!');
			});
		});
		<%--������������ �̵�  --%>
		$('#reviewbtn').click(function() {
			$('#purchase').submit(function() {
			$('#purchase').attr("action", "${mycontext}/review/reviewForm");
				alert('���� �������� �̵��մϴ�!');
			});
		});
		<%--�������������� �ѱݾ�  --%>
		$(function total() {
			let total = ${price*stock}
			$('#target2').html('�� �ݾ� :'+total.toLocaleString('ko-KR')+ "��");
		});
	});
	
</script>
 </body>
</html>
