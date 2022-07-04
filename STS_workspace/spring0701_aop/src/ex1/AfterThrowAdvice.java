package ex1;

import org.aspectj.lang.JoinPoint;

public class AfterThrowAdvice {
	public void commthrow(JoinPoint jp,Exception ew) {
		System.out.println("예외메세지 : " + ew.getMessage());
	}

}
