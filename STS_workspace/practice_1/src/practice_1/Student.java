package practice_1;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Student {
	@Autowired
	private String name;
	@Autowired
	private String addr;
	@Autowired
	private int age;
	
	public String Msg() {
		return "안녕하세요 제 이름은 " + name + "이고 나이는 " + age + "살, 사는 곳은 " + addr + "입니다";
	}
}
