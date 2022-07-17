   <%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <c:set var="mycontext" value="${pageContext.request.contextPath}" />
   
    <footer class="mt-5 text-white text-center mybgColor">
        Page Footer
    </footer>
<script>
	<%-- 스크립트 영역--%>
	$(function() {
		<%-- mypage에서 수정하는 버튼--%>
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
			
			$('#target').html(total.toLocaleString('ko-KR')+ "원");
		}

		
	});
		});
		<%--장바구니로 이동  --%>
		$('#basketbtn').click(function() {
			$('#purchase').attr("action", "${mycontext}/basket/addBasket");
			$('#purchase').submit(function() {
				alert('장바구니에 닮겼습니다!');
			});
		});
		<%--구매페이지로 이동  --%>
		$('#buybtn').click(function() {
			$('#purchase').attr("action", "order");
			$('#purchase').submit(function() {
				alert('구매 페이지로 이동합니다!');
			});
		});
		<%--리뷰페이지로 이동  --%>
		$('#reviewbtn').click(function() {
			$('#purchase').submit(function() {
			$('#purchase').attr("action", "${mycontext}/review/reviewForm");
				alert('리뷰 페이지로 이동합니다!');
			});
		});
		<%--구매페이지에서 총금액  --%>
		$(function total() {
			let total = ${price*stock}
			$('#target2').html('총 금액 :'+total.toLocaleString('ko-KR')+ "원");
		});
	});
	
</script>
 </body>
</html>
