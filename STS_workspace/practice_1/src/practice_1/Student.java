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
		return "�ȳ��ϼ��� �� �̸��� " + name + "�̰� ���̴� " + age + "��, ��� ���� " + addr + "�Դϴ�";
	}
}
