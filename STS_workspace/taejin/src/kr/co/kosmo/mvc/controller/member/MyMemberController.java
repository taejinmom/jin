package kr.co.kosmo.mvc.controller.member;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.BoardDaoInter;
import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.MemberDTO;
import kr.co.kosmo.mvc.vo.SuperDTO;

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


	
	@RequestMapping("/memberList")
	public String memberList(Model m, String cPage) {
		
		int totalRecord = memberDaoInter.getCnt();
		m.addAttribute("totalRecord", totalRecord);
		return "mymember/memberList";
	}
	@RequestMapping("/myPage")
	public String myPage(Model m,HttpSession session) {
		System.out.println("id : " + session.getAttribute("sessionID"));
		String id = (String) session.getAttribute("sessionID");
		MemberDTO dto = memberDaoInter.myPage(id);
		m.addAttribute("dto", dto);
		
		
		return "mymember/myPage";
	}

}
