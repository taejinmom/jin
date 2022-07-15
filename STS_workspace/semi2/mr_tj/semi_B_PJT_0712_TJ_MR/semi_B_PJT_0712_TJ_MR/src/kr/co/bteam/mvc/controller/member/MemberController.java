package kr.co.bteam.mvc.controller.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.bteam.mvc.dao.MemberDaoInter;
import kr.co.bteam.mvc.vo.MemberVO;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	@Autowired
	private MemberDaoInter memberdaointer;
	
	@GetMapping(value="/memberForm")
	public ModelAndView memberForm() {
		ModelAndView mav = new ModelAndView("member/memberForm");
		return mav;
	}
	
	@PostMapping(value="/memberIn")
	public ModelAndView addMember(MemberVO vo) {
		ModelAndView mav = new ModelAndView("redirect:/main");
		memberdaointer.addMember(vo);
		return mav;
	}
	@GetMapping("/myPage")
	public ModelAndView myPageLsit(Model m, MemberVO vo, HttpSession session) {
		ModelAndView mav = new ModelAndView("member/mypage");
		String id = (String) session.getAttribute("sessionId");
		vo = memberdaointer.memberInfo(id);
		m.addAttribute("vo", vo);
		
		return mav;
	}
	@GetMapping("/idchk")
	public ModelAndView idchk(Model m, String mem_id) {
		ModelAndView mav = new ModelAndView("member/idchk");
		int cnt = memberdaointer.idcheck(mem_id);
		System.out.println("ID중복확인 체크 : " + cnt);
		m.addAttribute("msg",cnt );
		
		return mav;
	}
	@PostMapping("/updateIn")
	public String update(MemberVO vo,HttpSession session,HttpServletRequest request) {
		int mem_no = (int) session.getAttribute("sessionNo");
		vo.setMem_no(mem_no);
		memberdaointer.memberUpdate(vo);
		
//		String mem_id = (String) session.getAttribute("sessionId");
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("mem_name",request.getParameter("mem_name"));
//		map.put("mem_pw",request.getParameter("mem_pw"));
//		map.put("mem_adr",request.getParameter("mem_adr"));
//		map.put("mem_id",mem_id);
//		memberdaointer.memberUpdate(map);
		return "redirect:/main";
		
	}
	
}
