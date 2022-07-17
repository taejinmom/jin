package kr.co.bteam.mvc.orderadvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class OrdersStatusAdvice {

	// PageListInter�� getBean���� �޾ƿ��� ����
	@Autowired
	private ApplicationContext applicationContext;
	
	
	@After("execution(* kr.co.bteam.mvc.controller.*.*Controller.addOrders(..))")
	public void orderStatus(JoinPoint jp) {
		Object[] args = jp.getArgs();
		HttpServletRequest request = (HttpServletRequest) args[1];
		
		int i_no = Integer.parseInt(request.getParameter("i_no"));
		System.out.println("ordersAdvice-��ǰ��ȣ : " + i_no);
		String methodName = jp.getSignature().getName();
		System.out.println("methodName : "+methodName);
		
		OrdersStatusInter ordersStatusInter = applicationContext.getBean(methodName, OrdersStatusInter.class);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("i_no", i_no);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ordersStatusInter.statusUpdate(map);
				
			}
		}).start();
	}
		
	
}
