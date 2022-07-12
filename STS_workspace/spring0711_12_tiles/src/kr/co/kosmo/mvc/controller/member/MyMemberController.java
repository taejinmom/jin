package kr.co.kosmo.mvc.controller.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.MemerDTO;
// http://localhost/spring0706_mybatis/member/memberForm   => /WEB-INF/views/mymember/memberForm.jsp
@Controller
@RequestMapping("/member")
public class MyMemberController {
		@Autowired
		private MemberDaoInter memberDaoInter;
	
		@GetMapping(value="/memberForm")
		public ModelAndView memberForm() {
			ModelAndView mav = new ModelAndView("mymember/memberForm");
			return mav;
		}
		
		@PostMapping(value="/memberIn")
		public String memberIn(MemerDTO dto) {
			System.out.println("ID : "+dto.getId());
			memberDaoInter.addMember(dto);
			return "redirect:/main";
			
		}
		// 온라인 - 스터디 / 20분 ..
		//요청이 member/idcheck?id=xman 일 때 아이디 중복 체크를 해주는 모델을 만들고
		// mymember/idchk.jsp로 msg값을 전송해서 출력하시오.
		// msg => 사용여부 출력 
		// 반드시 id란 파라미터가 있어야 한다.(체크 대상) 
		@GetMapping(value="/idcheck")
		public String idCheck(Model m,@RequestParam("id") String id) {
			System.out.println("idAjax:"+id);
			int cnt = memberDaoInter.idcheck(id);
			System.out.println("Cnt:"+cnt);
			//String msg ="이미 사용중인 아이디 입니다.";
			//if(cnt == 0) {
			//	 msg ="사용 가능한 아이디 입니다.";
			//}
			m.addAttribute("msg", cnt);
			return "mymember/idchk";
		}
		
		@RequestMapping("/memberList")
		public String memberList(Model model,String cPage) {
			//Map<String, Integer> map = new HashMap<String, Integer>();
			//map.put("begin", 1);
			//map.put("end", 10);
			int totalRecord = memberDaoInter.getCnt();
			//model.addAttribute("list", list);
			model.addAttribute("totalRecord", totalRecord);
			
			return  "mymember/memberList";
		}	
}











