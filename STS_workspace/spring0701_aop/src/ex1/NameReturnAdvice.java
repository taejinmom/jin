package ex1;

import org.aspectj.lang.JoinPoint;

public class NameReturnAdvice {

	public void myReturnMethod(JoinPoint jp, Object ret) {
		String namev = jp.getSignature().getName();
		System.out.println("name: "+namev);
		System.out.println("��ȯ�� : "+ret );
		System.out.println();
		System.out.println("=============================\n");
	}
}
