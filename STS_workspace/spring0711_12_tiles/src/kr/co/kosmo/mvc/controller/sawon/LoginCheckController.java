package kr.co.kosmo.mvc.controller.sawon;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.MemerDTO;

@Controller
@RequestMapping(value="/login")
public class LoginCheckController {
	
	@Autowired
	private MemberDaoInter memberList;
	
	@RequestMapping(value="/loginForm")
	public String loginForm() {
		return "login/loginForm";
	}
	// id,pwd => DTO => Dao에서 select 
	// 맞으면 => Session을 심어야 하지 않나!
	@PostMapping("/loginProcess")
	public ModelAndView loginfProcess(HttpSession session, MemerDTO vo,
			@RequestHeader("User-Agent") String uesrAgent) {
		System.out.println("User-Agent : "+uesrAgent);
		ModelAndView mav = new ModelAndView("redirect:/main");
		MemerDTO dto =memberList.loginCheck(vo);
		if(dto == null) {
			mav.setViewName("error/paramException");
			mav.addObject("emsg", "로그인 실패 입니다.");
		}else {
			System.out.println("id"+dto.getId());
			System.out.println("name"+dto.getName());
			session.setAttribute("sessionName", dto.getName());
			session.setAttribute("sessionID", dto.getId());
		}
		return mav;
	}
	@GetMapping("/logout")
	public ModelAndView loginfoutProcess(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		session.removeAttribute("sessionName");
		session.removeAttribute("sessionID");
		mav.setViewName("redirect:/main");
		return mav;
	}
	
	
}
