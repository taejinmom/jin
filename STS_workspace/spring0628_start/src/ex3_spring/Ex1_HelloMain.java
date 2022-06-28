package ex3_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex1_HelloMain {
	public static void main(String[] args) {
//		Ex1_HelloBean ref = new Ex1_HelloBean();
//		System.out.println(ref.printMessage());
//		ref.setMsg("����");
//		System.out.println(ref.printMessage());
		//BeanFactory�� ���� �������� ������ �����̳ʿ� ����س��� ������ �޴´�.
		//genericXml..spring 3.0 �̻���� �������� jdk5�̻�
		ApplicationContext c = new GenericXmlApplicationContext("ex3_spring/ex3.xml");
		Ex1_HelloBean ref= c.getBean("hello",Ex1_HelloBean.class);
		Ex1_HelloBean ref2= c.getBean("hi",Ex1_HelloBean.class);

		System.out.println(ref.printMessage());
		System.out.println(ref2.printMessage());
		
			
		
	}
}
