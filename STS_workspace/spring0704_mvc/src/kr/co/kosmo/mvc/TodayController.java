package kr.co.kosmo.mvc;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class TodayController {

	@RequestMapping(value="/today") 
	public ModelAndView myHello() {
		ModelAndView mav = new ModelAndView();
		String date = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초").format(new Date());
		mav.addObject("today",date);
		mav.setViewName("today");
		
		return mav;
	}
}
