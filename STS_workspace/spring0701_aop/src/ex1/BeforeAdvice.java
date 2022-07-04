package ex1;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BeforeAdvice {
	@Autowired
	
	private MyPublic pub;
	
	
	public void bf(JoinPoint jp) {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
				System.out.println(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("끝!");
		System.out.println(pub.todayMethod());
		pub.printInfo("박태진");
	}
}
