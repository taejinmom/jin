package ex3_aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
//Advice Ŭ������ ���� �ض�
//MethodInvocation invocation Ÿ���� �޼����� ȣ�� ������ ������ �ִ� ��ü�� ���ڷ� ���Թ���
public class Ex1_MessageAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
			System.out.println("���� �� ���� �����Ͻ� ������ ���� ��");

			Object rev = invocation.proceed();
			if(rev != null) {
				System.out.println("REV : " + rev);
			}
			
			System.out.println("���� ���� �����Ͻ� ������ ���� ��");
			return rev;
	}
	
}
