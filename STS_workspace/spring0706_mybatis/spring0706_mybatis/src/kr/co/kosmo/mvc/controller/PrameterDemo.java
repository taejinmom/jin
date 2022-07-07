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
		mav.addObject("msg", "여기는  test의 기본 페이지 입니다.");
		return mav;
	}
	
	//http://localhost/spring0706_mybatis/test/testmapper?number=113
	@RequestMapping(value="/testmapper")
	public void formParam(int number) {
		number *= 2; 
		System.out.println(number+"formParam 메서드 호출!");
	}
	 //Spring은 파라미터값을 자동으로 처리해준다.
	@RequestMapping(value="/testmapper2")
	public String formParam(Model m, int number) {
		number *= 2; 
		System.out.println(number+"formParam 메서드 호출!");
		
		//requestScope를 통해서 view에 값을 전달
		m.addAttribute("msg", number+"입니다.");
		return "mytest/testview";
	}
}
