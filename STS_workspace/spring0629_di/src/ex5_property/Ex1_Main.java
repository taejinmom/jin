package ex5_property;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex1_Main {
	public static void main(String[] args) {
		ApplicationContext c = new GenericXmlApplicationContext("ex5_property/list.xml");
		Ex1_ListDemo ref = c.getBean("list",Ex1_ListDemo.class);
		List<String> slist = ref.getSlist();
		for(String e : slist) {
			System.out.println(e);
		}
		
		
	}
}
