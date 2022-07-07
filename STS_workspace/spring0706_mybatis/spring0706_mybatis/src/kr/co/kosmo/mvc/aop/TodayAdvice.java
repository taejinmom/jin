package kr.co.kosmo.mvc.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
@Component
@Aspect
public class TodayAdvice {
	// todayView 타겟으로 
	@Before("execution(* kr.co.kosmo.mvc.controller.TodayDefaultController.todayView(..))")
	public void beforToday(JoinPoint jp) {
		//System.out.println("ClassName :"+jp.getTarget().getClass().getName());
		//System.out.println("Name :"+jp.getSignature().getName());
		Object[] args = jp.getArgs(); // target의 인자값
		for(Object e : args) {
			if(e instanceof Model) {
				//System.out.println("1=>"+((Model)e).toString());
				Model m = (Model) e;
				m.addAttribute("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"이런식으로 합니다.");
			}else {
				//System.out.println("2=>"+e);
			}
			
		}
	}

	//@AfterReturning(pointcut = "execution(* kr.co.kosmo.mvc.controller.Today*.today*(..))", returning = "mav")
	public ModelAndView afterToday(JoinPoint jp, ModelAndView mav) {
		mav.addObject("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		return mav;
	}

}
