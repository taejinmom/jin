package ex3_aop;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class Main {
	public static void main(String[] args) {
		//ProxyFactoryBean : 요청이 올때 포인트컷에 해당되는 메서드를 타겟에서 찾아 Advice를 적용시켜준다
		ProxyFactoryBean pf = new ProxyFactoryBean();
		pf.setTarget(new MessageImple());
	
		//pointcut 지정해서 특정 조인포인트 대상
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		//target 이 가지고 있는 메서드이름을 대상으로 선정할 수 있다.
		pointcut.setMappedName("print*");
		//역할에 따라서 지침을 줘야 한다. => pointcut 과 적용할 Advice
//		pf.addAdvisor(new DefaultPointcutAdvisor(pointcut,new Ex1_MessageAdvice()));
		pf.addAdvisor(new DefaultPointcutAdvisor(pointcut,new Ex2_MessageAdvice()));

//				pf.addAdvice(new Ex1_MessageAdvice());
//				pf.addAdvice(new Ex1_MessageAdvice());
		
		Message prMessage = (Message) pf.getObject();
		prMessage.print();//Message의 메서드
		
	}
}
