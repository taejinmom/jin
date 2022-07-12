package kr.co.kosmo.mvc.controller.survey;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.controller.service.SurveyService;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

@Controller
public class SurveyController {
	//SurveyService DI
	@Autowired
	private SurveyService surveyService;
	
	@RequestMapping(value="/surveyForm")
	public String surform() {
		return "survey/surveyAddform";
	}
	//@RequestMapping(value="/addsurvey",method = RequestMethod.POST)
	@PostMapping(value="/addsurvey")
	public ModelAndView surveyadd(SurveyVO vo,HttpServletRequest request) {
		System.out.println(vo.getSub());
		// form���� name�� ���� �̸����� �Ѿ� �� �� �Ķ���͸� �޴� ��� 
		String[] surveytitle = request.getParameterValues("surveytitle");
		
		// DB�� �����ϱ� ���� List �����
		List<SurveyContentVO> list = new ArrayList<>();
		
		char stype = 'A';
		for(String e : surveytitle) {
			SurveyContentVO sv = new SurveyContentVO();
			sv.setSurveytitle(e);
			sv.setSurveycnt(0);
			// survey�� num�� ���� 
			sv.setSubcode(vo.getNum());
			sv.setSubtype(String.valueOf(stype));
			System.out.println("surveytitle => "+e);
			list.add(sv);
			stype++;
		}
		// SurveyVO �� ���� Ÿ��Ʋ�� ������ List<SurveyContentVO> ���ڷ� ���� 
		vo.setSubvey(list);
		
		surveyService.addSurvey(vo, list);
		ModelAndView mav = new ModelAndView("redirect:surveylist");
		return mav;
	}
	
	@RequestMapping(value="/surveylist")
	public ModelAndView surveylist() {
		ModelAndView mav = new ModelAndView("survey/surveyList");
		return mav;
	}	
	
	@RequestMapping(value="/surveyDetail")
	public ModelAndView surveyDetail(int num) {
		ModelAndView mav = new ModelAndView("survey/surveyDetail");
		SurveyVO vo = surveyService.adminDetail(num);
		mav.addObject("vo", vo);
		return mav;
	}
}
