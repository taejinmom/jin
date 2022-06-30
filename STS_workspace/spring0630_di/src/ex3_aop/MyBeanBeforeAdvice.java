package ex3_aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeanBeforeAdvice implements MethodBeforeAdvice{
	//joinpoint : Advice 가 PointCut에 의해서 위빙되는 지점
	@Override
	public void before(Method method, Object[] id, Object target) throws Throwable { //joinpoint 정보
		System.out.println("Before Start -----------------");
		System.out.println("메서드의 이름 : " + method.getName());
		System.out.println("리턴 타입:" + method.getReturnType());
		System.out.println("Target의 주소 : "+target.getClass().getName());
		try {
			String idv = (String)id[0];
			System.out.println("ID :" + idv);
			System.out.println("Before End -----------------");
		} catch (Exception e) {
			System.out.println("Args가 없습니다");
		}
	}

}
