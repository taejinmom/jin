package ex3_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser2 {
//�Ｚ, LG TV�� ��û�ϴ� ���� Ŭ������ �����
	public static void main(String[] args) {
		
	ApplicationContext c = new GenericXmlApplicationContext("ex3_spring/tv.xml");
	TV tv = c.getBean("stv",TV.class);

tv.run();
	}

}
