package kr.co.kosmo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParameterDemo2 {
	
	//parameter의 값을 고정하겠다.
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
	// mycode 란 파라미터에 요청 파라미터의 값이 kosmoaa가 아닌것은 허용  
	@RequestMapping(value = "/param2",params = "mycode!=kosmoaa")
	public ModelAndView paramDemo3(String code) {
		ModelAndView m = new ModelAndView();
		m.setViewName("mytest/testview");
		m.addObject("msg", code);
		return m;
	}
}



