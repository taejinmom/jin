<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
var userAgent=navigator.userAgent.toLowerCase();
function deviceCheck() {
    // ����̽� ���� ����
    var pcv = "win16|win32|win64|mac|macintel";
    // ������ ����̽� ȯ��
    if ( navigator.platform ) {
        if ( pcv.indexOf(navigator.platform.toLowerCase()) < 0 ) {
            console.log('MOBILE');
            location="mobile/"
        } else {
            
        	var browser;
        	if(userAgent.indexOf('edge')>-1){
        		browser='�ͽ��÷η� ����';
        	} else if (userAgent.indexOf('whale')>-1){
        		browser='���̹� ����'
        	} else if (userAgent.indexOf('chrome')>-1){
        		browser='ũ��';
        		
        	} else if (userAgent.indexOf('firefox')>-1){
        		browser='���̾�����';
        	} else {
        		browser='�ͽ��÷η�';
        	}
        	console.log('browser'+browser)
        	location="web/"
        }
    }
}
window.onload=function(){
	deviceCheck();
}

</script>
</head>
<body>

</body>
</html>