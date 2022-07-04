package ex1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;

public class MyPublic {
	
	
	public String todayMethod() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		return f.format(new Date());
	}
	public void printInfo(String name) {
		System.out.println("æ»≥Á«œººø‰" + name + "¥‘");
	}
	
}
