package ex1;

import org.aspectj.lang.ProceedingJoinPoint;

// Around Advice - joinpoint�� �ݵ�� �ʿ��ϴ�.
public class CheckAdvice {

	public void checkTime(ProceedingJoinPoint pjp) throws Throwable{
		long start = System.currentTimeMillis(); // ���� ������� ����
		
		//target ��ü�� �޼��带 ȣ�� 
		pjp.proceed();
		
		long end = System.currentTimeMillis(); //���� ������� ����
		
		System.out.println("���� �� �ӵ� :"+(end-start)+"��");
	}
}
