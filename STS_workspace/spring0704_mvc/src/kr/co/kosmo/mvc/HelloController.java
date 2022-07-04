package kr.co.kosmo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	//http://localhost/spring0704_mvc/hello => request :*** �ߺ� X ****
	//ActionFactory ---------------> Spring Contanier ------> DispatcherServlet
	//----------->HandlerMapping�� �м�
	//
	//���۹��,���۰�,�𵨸�
	//public ActionFoward xx
	@RequestMapping(value="/hello") 
	public ModelAndView myHello() {
		ModelAndView mav = new ModelAndView();
		//request.setAttribute("key",val);
		mav.addObject("msg", "<h1>�ȳ��ϼ��� ���� ù��° spring MVC �Դϴ� <h1>");
		mav.setViewName("hello");
		return mav;
	}
	
}
