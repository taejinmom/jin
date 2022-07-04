package kr.co.kosmo.mvc;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Controller_test {

	@RequestMapping(value = "test")
	public ModelAndView print() {
		System.out.println("print �޼��� ����");
		ModelAndView mav = new ModelAndView();
		String date = new SimpleDateFormat().format(new Date());
		mav.addObject("test", date);
		mav.setViewName("test");
		return mav;
		
	}
}
