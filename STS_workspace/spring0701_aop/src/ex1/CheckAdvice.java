package ex1;

import org.aspectj.lang.ProceedingJoinPoint;

// Around Advice - joinpoint�� �ݵ�� �ʿ��ϴ�.

public class CheckAdvice{
	public void checkTime(ProceedingJoinPoint pjp) throws Throwable{
		long start = System.currentTimeMillis(); // ���� ������ɻ���

		// target ��ü�� �޼��带 ȣ��
		pjp.proceed();
		
		long end = System.currentTimeMillis();	// ���� ������ɻ���
		System.out.println((end-start)/1000 + "��");
	}
}
