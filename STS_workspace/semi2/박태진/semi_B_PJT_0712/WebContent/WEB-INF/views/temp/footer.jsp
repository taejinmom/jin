   <%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   
   
    <footer class="mt-5 text-white text-center mybgColor">
        Page Footer
    </footer>
<script>
	<%-- ��ũ��Ʈ ����--%>
	<%-- mypage���� �����ϴ� ��ư--%>
	$(function() {
		$('#btn0').click(function() {
			$('#updateform').submit();
		});
		
			<%--detail���� ��ǰ �������� �� �� �ݾ� ����Ʈ�� ������ִ� �޼���--%>
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
			
			$('#target1').html('�� �ݾ� :'+total.toLocaleString('ko-KR')+ "��");
		}

		
	});
		});
		<%--��ٱ��Ϸ� �̵�  --%>
		$('#basketbtn').click(function() {
			$('#purchase').attr("action", "basket")
			$('#purchase').submit(function() {
				alert('��ٱ��Ͽ� �����ϴ�!');
				
				
			});
		});
		<%--������������ �̵�  --%>
		$('#buybtn').click(function() {
			$('#purchase').attr("action", "order");
			$('#purchase').submit(function() {
				alert('������������ �̵��մϴ�');
				
			});
		});
		<%--�������������� �ѱݾ�  --%>
	$(function total() {
		let total = ${price*stock}
		$('#target2').html('�� �ݾ� :'+total.toLocaleString('ko-KR')+ "��");
	})
		
		
	});
		
		
</script>
 </body>
</html>
