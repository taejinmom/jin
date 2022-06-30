package ex3_aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
/*
 * 1) ������ɻ����� �и� �س��� Advice�� �����Ѵ�. ������ ���ؾ� �Ѵ�.
 * 2) ������ �� �����ؼ� �ش� Advice�� ������ ����� ������ �� ���..
 * 3) ProxyFactoryBean(ĸ��ȭ)���� pointCut���� ������ �����ؼ�
 * ���������� ����ǵ���(joinpoint)
 * */
public class Ex2_MessageAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
			
		long start = System.currentTimeMillis();
			//Joinpoint = proceed�� �����Ҽ�����
			Object rev = invocation.proceed();
			if(rev != null) {
				System.out.println("REV : " + rev);
				
			}
			
			
			
			long end = System.currentTimeMillis();
			long difTime = (start - end)/1000;
			System.out.println("�ɸ��ð� : " + Math.abs(difTime));
			return rev;
	}
	
}
