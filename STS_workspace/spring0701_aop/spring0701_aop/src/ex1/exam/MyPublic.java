package ex1.exam;

import java.text.SimpleDateFormat;
import java.util.Date;
/*
 *  TodayBeforeAdvice���� MyPublic�� DI�� �޾Ƽ� Advice���� ������ ��Ų��.
 *  
 *  ex1.DaoImple �� ���ǵ� ��� �޼��忡 �����۾����� ������ɷ����� ����ǵ��� �����Ͻÿ�.
 */
 
public class MyPublic {
	public String todayMethod() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		return f.format(new Date());
	}
}
