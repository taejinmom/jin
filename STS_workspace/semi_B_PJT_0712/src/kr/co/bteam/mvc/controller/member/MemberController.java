package kr.co.bteam.mvc.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.bteam.mvc.dao.MemberDaoInter;
import kr.co.bteam.mvc.vo.MemberVO;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	@Autowired
	private MemberDaoInter daoInter;
	
	@GetMapping(value = "/memberForm")
	public String addMemberForm() {
		return "member/memberForm";
	}
	
	@PostMapping(value = "/memberIn")
	public String addMember(MemberVO vo) {
		daoInter.addMember(vo);
		return "redirect:/main";
	}
	@GetMapping(value = "/loginForm")
	public String loginForm() {
		return "login/loginForm";
	}
	@PostMapping(value = "/loginIn")
	public String login(MemberVO vo) {
		daoInter.loginCheck(vo);
		return "redirect:/main";
	}
	@GetMapping(value = "/mypage")
	public ModelAndView myPage(String id) {
		ModelAndView mav = new ModelAndView("member/myPage");
		
		daoInter.memberInfo(id);
		
		return mav;
	}
	@GetMapping(value="/idcheck")
	public String idCheck(Model m,@RequestParam("mem_id") String mem_id) {
		System.out.println("idAjax:"+mem_id);
		int cnt = daoInter.idcheck(mem_id);
		System.out.println("Cnt:"+cnt);
		
		m.addAttribute("msg", cnt);
		return "member/idchk";
	}
	
}
