package ex4_const;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex1_Const {
	private int num;
	private String msg;
	private String code;
	
	public Ex1_Const(int num) {
		this.num = num;
		System.out.println("int형 생성자");
	}
	public Ex1_Const(String msg) {
		this.msg = msg;
		System.out.println("String 형 생성자");
	}
	
	public Ex1_Const(int num, String code) {
		this.num = num;
		this.code = code;
		System.out.println("int형");
		System.out.println("String 형");
	}
	public String printConstRes() {
		StringBuffer sb = new StringBuffer();
		sb.append("num :").append(num);
		sb.append("msg :").append(msg);
		sb.append("code :").append(code);
		return sb.toString();
	}
public static void main(String[] args) {
	ApplicationContext c = new GenericXmlApplicationContext("ex4_const/ex4_const.xml");
//	Ex1_Const ref = c.getBean("msg",Ex1_Const.class);
}
	
}
