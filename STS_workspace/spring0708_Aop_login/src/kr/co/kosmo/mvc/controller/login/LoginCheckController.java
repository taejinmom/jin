package kr.co.kosmo.mvc.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginCheckController {


	@GetMapping(value = "/loginForm")
	public String loginForm() {
		return "login/loginForm";
	}

	
	
}
