package ex3_aop;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class Main {
	public static void main(String[] args) {
		//ProxyFactoryBean : ��û�� �ö� ����Ʈ�ƿ� �ش�Ǵ� �޼��带 Ÿ�ٿ��� ã�� Advice�� ��������ش�
		ProxyFactoryBean pf = new ProxyFactoryBean();
		pf.setTarget(new MessageImple());
	
		//pointcut �����ؼ� Ư�� ��������Ʈ ���
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		//target �� ������ �ִ� �޼����̸��� ������� ������ �� �ִ�.
		pointcut.setMappedName("print*");
		//���ҿ� ���� ��ħ�� ��� �Ѵ�. => pointcut �� ������ Advice
//		pf.addAdvisor(new DefaultPointcutAdvisor(pointcut,new Ex1_MessageAdvice()));
		pf.addAdvisor(new DefaultPointcutAdvisor(pointcut,new Ex2_MessageAdvice()));

//				pf.addAdvice(new Ex1_MessageAdvice());
//				pf.addAdvice(new Ex1_MessageAdvice());
		
		Message prMessage = (Message) pf.getObject();
		prMessage.print();//Message�� �޼���
		
	}
}
