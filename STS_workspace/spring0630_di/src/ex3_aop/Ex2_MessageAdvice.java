package ex3_aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
/*
 * 1) 공통관심사항을 분리 해내서 Advice로 설계한다. 시점을 정해야 한다.
 * 2) 패턴을 좀 생각해서 해당 Advice가 적용할 대상을 정의할 때 고민..
 * 3) ProxyFactoryBean(캡슐화)에게 pointCut으로 패턴을 적용해서
 * 관점지향이 적용되도록(joinpoint)
 * */
public class Ex2_MessageAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
			
		long start = System.currentTimeMillis();
			//Joinpoint = proceed를 생략할수없다
			Object rev = invocation.proceed();
			if(rev != null) {
				System.out.println("REV : " + rev);
				
			}
			
			
			
			long end = System.currentTimeMillis();
			long difTime = (start - end)/1000;
			System.out.println("걸린시간 : " + Math.abs(difTime));
			return rev;
	}
	
}
