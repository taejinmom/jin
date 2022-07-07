package kr.co.kosmo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodayDefaultController {

	@RequestMapping(value= {"/","/main"})
	public String todayView(Model model) {
		// "main/index";
		// ModelAndView mav = new ModelAndView("main/index");
		System.out.println("index ½ÇÇà!");
		return "main/index";
	}
}
