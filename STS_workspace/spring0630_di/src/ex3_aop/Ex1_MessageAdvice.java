package ex3_aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
//Advice 클래스를 정의 해땅
//MethodInvocation invocation 타겟의 메서드의 호출 정보를 가지고 있는 객체를 인자로 주입받음
public class Ex1_MessageAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
			System.out.println("선행 될 공통 비지니스 로직이 수행 됨");

			Object rev = invocation.proceed();
			if(rev != null) {
				System.out.println("REV : " + rev);
			}
			
			System.out.println("후행 공통 비지니스 로직이 수행 됨");
			return rev;
	}
	
}
