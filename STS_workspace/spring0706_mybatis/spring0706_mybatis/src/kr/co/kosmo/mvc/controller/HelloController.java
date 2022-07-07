package kr.co.kosmo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
// ���� X
@Controller
public class HelloController {

	// http://localhost/spring0704_mvc/hello (request) : �ߺ��� �Ǹ� �ȵ�!
	// ActionFactory -----------> Spring Container -----------> DispatcherServlet
	// --------> HandlerMapping�� �м�
	@RequestMapping(value="/hello")
	public ModelAndView myHello() {
	
		ModelAndView mav = new ModelAndView();
		//request.setAttribute("key",Val);
		mav.addObject("msg", "<h1>�ȳ��ϼ���2. ���� ù��° spring MVC �Դϴ�.</h1>");
		//new ActionFoard("hello.jsp",false);
		//mav.setViewName("hello");
		return mav;
	}
}
