package ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Biz_Main {
	public static void main(String[] args) {
		ApplicationContext c =
				new GenericXmlApplicationContext("ex1/ex1.anno.xml");
		BizService dao = c.getBean("target",BizService.class);
//		dao.bizMethod1();
		dao.first();
	}
}
