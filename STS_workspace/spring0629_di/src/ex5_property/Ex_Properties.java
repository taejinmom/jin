package ex5_property;

import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex_Properties {
	private Properties prop;

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
	public static void main(String[] args) {
		ApplicationContext c = new GenericXmlApplicationContext("ex5_property/set.xml");
		Ex_Properties prop = c.getBean("prop",Ex_Properties.class);
		Properties v = prop.getProp();
		String[] arr= {"addr","email","hello"};
		for(int i = 0; i < arr.length; i++) {
			System.out.println(v.get(arr[i]));
		}
	}
	
}
