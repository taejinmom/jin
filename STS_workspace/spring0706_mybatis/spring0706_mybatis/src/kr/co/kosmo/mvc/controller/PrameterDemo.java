package kr.co.kosmo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//http://localhost/spring0706_mybatis/test/testmapper
@RequestMapping(value="/test")
public class PrameterDemo {
	@RequestMapping(value={"/","/main"})
	public ModelAndView testDefaultView() {
		ModelAndView mav = new ModelAndView("mytest/testview");
		mav.addObject("msg", "�����  test�� �⺻ ������ �Դϴ�.");
		return mav;
	}
	
	//http://localhost/spring0706_mybatis/test/testmapper?number=113
	@RequestMapping(value="/testmapper")
	public void formParam(int number) {
		number *= 2; 
		System.out.println(number+"formParam �޼��� ȣ��!");
	}
	 //Spring�� �Ķ���Ͱ��� �ڵ����� ó�����ش�.
	@RequestMapping(value="/testmapper2")
	public String formParam(Model m, int number) {
		number *= 2; 
		System.out.println(number+"formParam �޼��� ȣ��!");
		
		//requestScope�� ���ؼ� view�� ���� ����
		m.addAttribute("msg", number+"�Դϴ�.");
		return "mytest/testview";
	}
}
