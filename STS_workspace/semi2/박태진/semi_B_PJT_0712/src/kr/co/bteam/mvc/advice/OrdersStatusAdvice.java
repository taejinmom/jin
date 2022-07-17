package kr.co.bteam.mvc.advice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import kr.co.bteam.mvc.dao.OrdersStatusInter;
import kr.co.bteam.mvc.dao.PageListInter;
import kr.co.bteam.mvc.vo.OrdersVO;
import kr.co.bteam.mvc.vo.SuperVO;
@Component
@Aspect
public class OrdersStatusAdvice {
	@Autowired
	private ApplicationContext applicationContext;
	//사용자가 상품을 구매하면 
	//배송상태 업데이트 -> ordersMapper.xml -> "ptj_orders.status"
	@After("execution(* kr.co.bteam.mvc.controller.*.*Controller.addOrders(..))")
	public void orderStatus(JoinPoint jp) {
		Object[] args = jp.getArgs(); 
		HttpServletRequest request = (HttpServletRequest) args[1];
		
		//i_no = 구매하는 상품의 상품번호
		int i_no = Integer.parseInt(request.getParameter("i_no"));
		System.out.println("ordersAdvice-상품번호 : " + i_no);
		
		String methodName = jp.getSignature().getName();
		System.out.println("methodName : "+methodName);
		OrdersStatusInter ordersStatusInter = applicationContext.getBean(methodName, OrdersStatusInter.class);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("i_no", i_no);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {Thread.sleep(5000);} 
				catch (InterruptedException e){e.printStackTrace();}
				ordersStatusInter.statusUpdate(map);}
		}).start();
	}
}
