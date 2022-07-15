   <%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   
   
    <footer class="mt-5 text-white text-center mybgColor">
        Page Footer
    </footer>
<script>
	<%-- 스크립트 영역--%>
	<%-- mypage에서 수정하는 버튼--%>
	$(function() {
		$('#btn0').click(function() {
			$('#updateform').submit();
		});
		
			<%--detail에서 상품 수량변동 시 총 금액 리스트에 출력해주는 메서드--%>
		$('#num').change(function() {
		let price= $('#i_price').val();
		var number = $('#num').val();
		var s_no = $('#i_no').val();
			console.log('price ='+price);
			console.log('number ='+number);
		$.ajax({
			url:"numchk?num="+number,
		success:function(data){
			console.log(data);
			var total = data * price;
			
			$('#target1').html('총 금액 :'+total.toLocaleString('ko-KR')+ "원");
		}

		
	});
		});
		<%--장바구니로 이동  --%>
		$('#basketbtn').click(function() {
			$('#purchase').attr("action", "basket")
			$('#purchase').submit(function() {
				alert('장바구니에 닮겼습니다!');
				
				
			});
		});
		<%--구매페이지로 이동  --%>
		$('#buybtn').click(function() {
			$('#purchase').attr("action", "order");
			$('#purchase').submit(function() {
				alert('구매페이지로 이동합니다');
				
			});
		});
		<%--구매페이지에서 총금액  --%>
	$(function total() {
		let total = ${price*stock}
		$('#target2').html('총 금액 :'+total.toLocaleString('ko-KR')+ "원");
	})
		
		
	});
		
		
</script>
 </body>
</html>
