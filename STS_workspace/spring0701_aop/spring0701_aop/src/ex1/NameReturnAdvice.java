package ex1;

import org.aspectj.lang.JoinPoint;

public class NameReturnAdvice {

	public void myReturnMethod(JoinPoint jp, Object ret) {
		
		String namev = jp.getSignature().getName();
		
		System.out.println("Name:"+namev);
		System.out.println("¹ÝÈ¯°ª :"+ret);
		System.out.println("============================");
	}
}
