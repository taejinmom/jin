package kr.co.kosmo.mvc.controller;

import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.vo.MemberDemoVO;
@Controller
public class MemberModelAttrDemo {
	
	//only Get��ĸ� ���� spring4.X ����
	@GetMapping(value="/memberForm")
	public ModelAndView memberForm() {
		ModelAndView mav = new ModelAndView("member/memberForm");
		//ModelAndView mav = new ModelAndView("mymember/memberForm");
		//mav.addObject(attributeName, attributeValue)
		return mav;
	}
	//@GetMapping(value="/memberForm")
	//public ModelAndView memberForm() {
	//	ModelAndView mav = new ModelAndView("member/memberForm");
		//mav.addObject(attributeName, attributeValue)
	//	return mav;
	//}
	
	//@Controller �������ִ� ��� 
	@PostMapping(value="/memberIn")
	public String addTest(Model model,@ModelAttribute(value="vo") MemberDemoVO vo) {
		//model.addAttribute("vo", vo);
		return "member/success2";
	}
}









