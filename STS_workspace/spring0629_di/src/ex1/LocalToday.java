package ex1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LocalToday {
	private String loc;
	private String name;
	public LocalToday() {
		System.out.println("LocalToday ������ ȣ��!");
	}
	//spring�� ���ؼ� String ���ڿ� ���� ���Թޱ� ����
	//setter,<property �� ����
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public void setName(String name) {
		this.name = name;
	}
	// Bean�� ������ �����̳ʿ� ���ؼ� �����ǰ� �� �� ���� �޼���
	public String printLocalToday() {
		SimpleDateFormat af = new SimpleDateFormat("yyyy-MM-dd");
		String msg = "�̸� : "+name+" ���� : " +loc+ ":" + af.format(new Date());
		System.out.println(name);
		System.out.println(msg);
		return msg;
	}
	
}
