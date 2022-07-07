package kr.co.kosmo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParameterDemo2 {
	
	//parameter�� ���� �����ϰڴ�.
	@RequestMapping(value = "/param1",params = "code=kosmo")
	public ModelAndView paramDemo1(String code) {
		ModelAndView m = new ModelAndView();
		m.setViewName("mytest/testview");
		m.addObject("msg", code);
		return m;
	}
	@RequestMapping(value = "/param1",params = "code=kosmo113")
	public ModelAndView paramDemo2(String code) {
		ModelAndView m = new ModelAndView();
		m.setViewName("mytest/testview");
		m.addObject("msg", code);
		return m;
	}
	// mycode �� �Ķ���Ϳ� ��û �Ķ������ ���� kosmoaa�� �ƴѰ��� ���  
	@RequestMapping(value = "/param2",params = "mycode!=kosmoaa")
	public ModelAndView paramDemo3(String code) {
		ModelAndView m = new ModelAndView();
		m.setViewName("mytest/testview");
		m.addObject("msg", code);
		return m;
	}
}



