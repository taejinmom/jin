package ex5_property;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex2_Main {
	public static void main(String[] args) {
		
	ApplicationContext c = new GenericXmlApplicationContext("ex5_property/map_child.xml");
	Ex2_Map ref1 = c.getBean("map2",Ex2_Map.class);
	Map<String, String> map = ref1.getMap();
	for(Map.Entry<String, String> entry : map.entrySet()) {
//		System.out.println(entry);
		System.out.println(entry.getKey() + ":" + entry.getValue());
	}
	}
		
}
