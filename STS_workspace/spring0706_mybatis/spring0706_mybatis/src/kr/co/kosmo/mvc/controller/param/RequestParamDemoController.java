package kr.co.kosmo.mvc.controller.param;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestParamDemoController {
	
	// 해당 파라미터 자체가 없을 때 예외를 발생 시킨다.
	// MissingServletRequestParameterException
	@RequestMapping(value="/reqparam1",method = RequestMethod.GET)
	public ModelAndView paramDemo1(@RequestParam String code) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mytest/testview");
		mav.addObject("msg", code);
		return mav;
	}
	// 속성 :value로 정해진 id 즉 파라미터 이름으로 받을 수 있다.
	// http://localhost/spring0706_mybatis/reqparam2?code=test x
	// http://localhost/spring0706_mybatis/reqparam2?id=test o
	// 속성 : 기본값은 required=true 이기 때문에 파라미터가 없을 경우 MissingServletRequestParameterException 발생한다.
	// required=false : 파라미터 값에 대한 예외를 발생하지 않는다.
	// defaultValue="" 파라미터값이 없을 때 기본값으로 설정
	@RequestMapping(value="/reqparam2",method = RequestMethod.GET)
	public ModelAndView paramDemo2(@RequestParam(value="id",required=false,defaultValue = "하하하1하하!") String code) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mytest/testview");
		mav.addObject("msg", code);
		return mav;
	}
}








