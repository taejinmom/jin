package kr.co.kosmo.mvc.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.MemberDTO;

//http://localhost/spring0706_mybatis/member/memberForm => /WEB-INF/views/mymember/memberForm.jsp
@Controller
@RequestMapping("/member")
public class MyMemberController {
	
	@Autowired
	private MemberDaoInter memberDaoInter;
	
	@GetMapping(value = "/memberForm")
	public ModelAndView memberForm() {
		ModelAndView mav = new ModelAndView("mymember/memberForm");
		return mav;
	}
	
	@PostMapping(value = "/memberIn")
	public String memberIn(MemberDTO dto) {
		System.out.println("ID : "+dto.getId());
		memberDaoInter.addMember(dto);
		return "redirect:/main";
	}
	
	@GetMapping(value = "/idcheck")
	public String idCheck(Model m, @RequestParam("id") String id) {
//		System.out.println("idAjax:"+id);
		int cnt = memberDaoInter.idcheck(id);
//		System.out.println("cnt : "+cnt);
//		String msg ="이미 사용중인 아이디 입니다.";
//		if(cnt == 0) {
//			 msg ="사용 가능한 아이디 입니다.";
//		}
		m.addAttribute("msg", cnt);
		return "mymember/idchk";
	}

	@GetMapping(value = "/loginForm")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("login/loginForm");
		return mav;
	}
	
	@PostMapping(value = "/login")
	public String login(MemberDTO dto) {
		int num = memberDaoInter.login(dto);
		if(num != 0) {
			System.out.println("로그인 실패!");			
		}else {
			System.out.println("로그인 성공!");
			return "forward:/main";
		}
		return "redirect:/main";
	}
	
//	public ModelAndView memberIdCheck(String id) {
//		ModelAndView mav = new ModelAndView();
//		int cnt = memberDaoInter.idcheck(id);
//		
//		return mav;
//	}
}
