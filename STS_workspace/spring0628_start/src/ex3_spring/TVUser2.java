package ex3_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser2 {
//삼성, LG TV를 시청하는 유저 클래스를 만들고
	public static void main(String[] args) {
		
	ApplicationContext c = new GenericXmlApplicationContext("ex3_spring/tv.xml");
	TV tv = c.getBean("stv",TV.class);

tv.run();
	}

}
