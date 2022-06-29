package ex1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LocalToday {
	private String loc;
	private String name;
	public LocalToday() {
		System.out.println("LocalToday 생성자 호출!");
	}
	//spring에 의해서 String 문자열 값을 주입받기 위한
	//setter,<property 에 적용
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public void setName(String name) {
		this.name = name;
	}
	// Bean이 스프링 컨테이너에 의해서 생성되고 난 후 사용될 메서드
	public String printLocalToday() {
		SimpleDateFormat af = new SimpleDateFormat("yyyy-MM-dd");
		String msg = "이름 : "+name+" 지역 : " +loc+ ":" + af.format(new Date());
		System.out.println(name);
		System.out.println(msg);
		return msg;
	}
	
}
