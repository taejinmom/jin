package exam2;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ExamListMap {
public static void main(String[] args) {
	ApplicationContext c = new GenericXmlApplicationContext("exam2/listmap.xml");
	
	ListMap ref = c.getBean("list",ListMap.class);
	List<Map<String,String>> listmap = ref.getListmap();
	
	for(Map<String,String> e : listmap) {
		System.out.println(e.get("name"));
		System.out.println(e.get("email"));
		System.out.println(e.get("addr"));
		System.out.println("======================");
	}
//	for(int i = 0; i < listmap.size(); i++) {
//		System.out.println(listmap.get(i));
//	}
}
}
