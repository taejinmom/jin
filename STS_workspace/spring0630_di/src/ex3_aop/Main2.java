package ex3_aop;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class Main2 {
public static void main(String[] args) {
	ProxyFactoryBean pf = new ProxyFactoryBean();
	pf.setTarget(new MessageImple());
	NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
	pointcut.addMethodName("test*");
	pf.addAdvisor(new DefaultPointcutAdvisor(pointcut,new MyBeanBeforeAdvice()));
	
	Message msg = (Message) pf.getObject();
	System.out.println("메인 시작");
	msg.test3("박태박");
}
}
