package ex3_aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeanBeforeAdvice implements MethodBeforeAdvice{
	//joinpoint : Advice �� PointCut�� ���ؼ� �����Ǵ� ����
	@Override
	public void before(Method method, Object[] id, Object target) throws Throwable { //joinpoint ����
		System.out.println("Before Start -----------------");
		System.out.println("�޼����� �̸� : " + method.getName());
		System.out.println("���� Ÿ��:" + method.getReturnType());
		System.out.println("Target�� �ּ� : "+target.getClass().getName());
		try {
			String idv = (String)id[0];
			System.out.println("ID :" + idv);
			System.out.println("Before End -----------------");
		} catch (Exception e) {
			System.out.println("Args�� �����ϴ�");
		}
	}

}
