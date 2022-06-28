package ex3_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex1_HelloMain {
	public static void main(String[] args) {
//		Ex1_HelloBean ref = new Ex1_HelloBean();
//		System.out.println(ref.printMessage());
//		ref.setMsg("ㅎ허");
//		System.out.println(ref.printMessage());
		//BeanFactory와 같은 개념으로 스프링 컨테이너에 등록해놓고 관리를 받는다.
		//genericXml..spring 3.0 이상부터 지원가능 jdk5이상
		ApplicationContext c = new GenericXmlApplicationContext("ex3_spring/ex3.xml");
		Ex1_HelloBean ref= c.getBean("hello",Ex1_HelloBean.class);
		Ex1_HelloBean ref2= c.getBean("hi",Ex1_HelloBean.class);

		System.out.println(ref.printMessage());
		System.out.println(ref2.printMessage());
		
			
		
	}
}
