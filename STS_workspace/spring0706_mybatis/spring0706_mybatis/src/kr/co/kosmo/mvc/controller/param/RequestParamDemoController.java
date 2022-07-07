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
	
	// �ش� �Ķ���� ��ü�� ���� �� ���ܸ� �߻� ��Ų��.
	// MissingServletRequestParameterException
	@RequestMapping(value="/reqparam1",method = RequestMethod.GET)
	public ModelAndView paramDemo1(@RequestParam String code) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mytest/testview");
		mav.addObject("msg", code);
		return mav;
	}
	// �Ӽ� :value�� ������ id �� �Ķ���� �̸����� ���� �� �ִ�.
	// http://localhost/spring0706_mybatis/reqparam2?code=test x
	// http://localhost/spring0706_mybatis/reqparam2?id=test o
	// �Ӽ� : �⺻���� required=true �̱� ������ �Ķ���Ͱ� ���� ��� MissingServletRequestParameterException �߻��Ѵ�.
	// required=false : �Ķ���� ���� ���� ���ܸ� �߻����� �ʴ´�.
	// defaultValue="" �Ķ���Ͱ��� ���� �� �⺻������ ����
	@RequestMapping(value="/reqparam2",method = RequestMethod.GET)
	public ModelAndView paramDemo2(@RequestParam(value="id",required=false,defaultValue = "������1����!") String code) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mytest/testview");
		mav.addObject("msg", code);
		return mav;
	}
}








