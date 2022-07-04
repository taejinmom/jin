package kr.co.kosmo.mvc;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ProfileController {
@RequestMapping(value = "profile")
public ModelAndView viewProfile() {
	ModelAndView mav = new ModelAndView();
	
	ArrayList<String> alist = new ArrayList<String>();
	ArrayList<String> slist = new ArrayList<String>();
	
	alist.add("박태진 ");
	
	alist.add("29살");
	
	alist.add("서울특별시 관악구 봉천동");
	
	mav.addObject("key2", alist);
	mav.setViewName("profile");
	return mav; 
}
}
