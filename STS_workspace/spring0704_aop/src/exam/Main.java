package exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext c = 
				new GenericXmlApplicationContext("exam/exam.xml");
	
	       
	      
		LoginTest dao = c.getBean("login",LoginTest.class);
		dao.print();
	}
}
