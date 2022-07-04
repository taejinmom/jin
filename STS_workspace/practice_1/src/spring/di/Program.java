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
		/* ���������� �����ϴ� ������� �ٲ���
		Exam exam = new NewlecExam();
//		ExamConsole console = new InlineExamConsole(exam);
		ExamConsole console = new GridExamConsole();
		console.setExam(exam);
		console.print();
		// ������ �κ��� ���� inline => Grid �̷������� ���������ʰ� �������� �̿��Ͽ� ����
	*/	
		ApplicationContext c =  new ClassPathXmlApplicationContext("spring/di/setting.xml");

//		2���� ��� ok		
//		ExamConsole console = (ExamConsole) c.getBean("console");
		ExamConsole console = c.getBean(ExamConsole.class);
		console.print();
		
	}
}
