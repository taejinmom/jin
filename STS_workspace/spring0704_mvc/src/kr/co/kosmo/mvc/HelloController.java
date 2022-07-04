package kr.co.kosmo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	//http://localhost/spring0704_mvc/hello => request :*** 중복 X ****
	//ActionFactory ---------------> Spring Contanier ------> DispatcherServlet
	//----------->HandlerMapping이 분석
	//
	//전송방식,전송값,모델명
	//public ActionFoward xx
	@RequestMapping(value="/hello") 
	public ModelAndView myHello() {
		ModelAndView mav = new ModelAndView();
		//request.setAttribute("key",val);
		mav.addObject("msg", "<h1>안녕하세요 나의 첫번째 spring MVC 입니다 <h1>");
		mav.setViewName("hello");
		return mav;
	}
	
}
