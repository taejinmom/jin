package advice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
// <aop:config> ��, ProxyFactoryBean(AOP�� �������ִ� ��ü) ����
// <aop:aspectj-autoproxy/> �� ���� �� �Ʒ��� Aspect ����!
@Aspect
public class BizAdvice {
    
    @Before("execution(* ex1.BizServiceImple.*(..))")
    public void beforeMethod() {
        String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        System.out.println("������ ��¥:"+today);
        System.out.println("��й�ȣ");
        Scanner sc = new Scanner(System.in);
        System.out.println("üũ");
    }
    @AfterReturning(pointcut = "execution(* ex1.BizServiceImple.second(..))",returning = "ret")
    
   
   public void myREturnMethod(JoinPoint jp, Object ret) {
	   String namev = jp.getSignature().getName();
	   System.out.println("name: "+namev);
	   System.out.println("ret: "+ret);
   }
    @Around("execution(* ex1.BizServiceImple.first())")
   public void myAroundMethod(ProceedingJoinPoint pjp) {
    	long start = System.currentTimeMillis();
    	
    	try {
			pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	long end = System.currentTimeMillis();
    	System.out.println("�ҿ�ð� : " + (end-start));
    }
    }

