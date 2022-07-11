package kr.co.kosmo.mvc.controller.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.MemberDTO;

@Controller
@RequestMapping("/login")
public class LoginCheckController {
	
	@Autowired
	private MemberDaoInter memberList;
	
	@GetMapping("/loginForm")
	public String LoginForm() {
		return "login/loginForm";
	}
	
	// id, pwd => DTO
	@PostMapping("/loginProcess")
	public ModelAndView loginProcess(HttpSession session, MemberDTO vo, @RequestHeader("User-Agent") String userAgent) {
		System.out.println("User-Agent : "+userAgent);
		ModelAndView mav = new ModelAndView("redirect:/main");
		
		MemberDTO dto = memberList.loginCheck(vo);
		if(dto == null) {
			mav.setViewName("error/paramException");
			mav.addObject("emsg", "로그인 실패입니다.");
		}else {
			System.out.println("id : "+dto.getId());
			System.out.println("name : "+dto.getName());
			session.setAttribute("sessionID", dto.getId());
			session.setAttribute("sessionNum", dto.getNum());
		}
		return mav;
	}
	
	@GetMapping("/logout")
	public ModelAndView logoutProcess(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		session.removeAttribute("sessionID");
		session.removeAttribute("sessionName");
		mav.setViewName("redirect:/main");
		return mav;
	}
}
