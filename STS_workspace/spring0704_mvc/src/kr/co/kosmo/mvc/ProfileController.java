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
	
	alist.add("������ ");
	
	alist.add("29��");
	
	alist.add("����Ư���� ���Ǳ� ��õ��");
	
	mav.addObject("key2", alist);
	mav.setViewName("profile");
	return mav; 
}
}
