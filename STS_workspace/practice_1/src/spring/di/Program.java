package spring.di;

import java.io.Console;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {
	

	public static void main(String[] args) {
		/* 스프링에게 지시하는 방법으로 바꾸자
		Exam exam = new NewlecExam();
//		ExamConsole console = new InlineExamConsole(exam);
		ExamConsole console = new GridExamConsole();
		console.setExam(exam);
		console.print();
		// 수정할 부분이 생겨 inline => Grid 이런식으로 변경하지않고 스프링을 이용하여 변경
	*/	
		ApplicationContext c =  new ClassPathXmlApplicationContext("spring/di/setting.xml");

//		2가지 방법 ok		
//		ExamConsole console = (ExamConsole) c.getBean("console");
		ExamConsole console = c.getBean(ExamConsole.class);
		console.print();
		
	}
}
