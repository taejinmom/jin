package exam;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
public static void main(String[] args) {

	ApplicationContext c = new GenericXmlApplicationContext("exam/ex1.xml");
	Ex1_Profile ref= c.getBean("profile",Ex1_Profile.class);
	System.out.println(ref.printinfp());
	
}
}
