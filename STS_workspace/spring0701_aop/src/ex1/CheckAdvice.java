package ex1;

import org.aspectj.lang.ProceedingJoinPoint;

// Around Advice - joinpoint가 반드시 필요하다.

public class CheckAdvice{
	public void checkTime(ProceedingJoinPoint pjp) throws Throwable{
		long start = System.currentTimeMillis(); // 선행 공통관심사항

		// target 객체의 메서드를 호출
		pjp.proceed();
		
		long end = System.currentTimeMillis();	// 후행 공통관심사항
		System.out.println((end-start)/1000 + "초");
	}
}
