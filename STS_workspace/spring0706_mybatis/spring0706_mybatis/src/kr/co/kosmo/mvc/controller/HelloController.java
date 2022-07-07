package kr.co.kosmo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
// 생략 X
@Controller
public class HelloController {

	// http://localhost/spring0704_mvc/hello (request) : 중복이 되면 안됨!
	// ActionFactory -----------> Spring Container -----------> DispatcherServlet
	// --------> HandlerMapping이 분석
	@RequestMapping(value="/hello")
	public ModelAndView myHello() {
	
		ModelAndView mav = new ModelAndView();
		//request.setAttribute("key",Val);
		mav.addObject("msg", "<h1>안녕하세요2. 나의 첫번째 spring MVC 입니다.</h1>");
		//new ActionFoard("hello.jsp",false);
		//mav.setViewName("hello");
		return mav;
	}
}
