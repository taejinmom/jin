   <%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   
   
    <footer class="mt-5 text-white text-center mybgColor">
        Page Footer
    </footer>
<script>
	<%-- 스크립트 영역--%>
	$(function() {
		
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
		$('#basketbtn').click(function() {
			$('#purchase').submit(function() {
				alert('장바구니에 닮겼습니다!');
				return false;
			})
		})
	});
	
</script>
 </body>
</html>
