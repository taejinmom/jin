package kr.co.bteam.mvc.controller.login;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.bteam.mvc.dao.MemberDaoInter;
import kr.co.bteam.mvc.vo.MemberVO;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	   private MemberDaoInter memberList;
	   
	   @RequestMapping(value="/loginForm")
	   public String loginForm() {
	      return "login/loginForm";
	   }
	   // id,pwd => DTO => Dao���� select 
	   // ������ => Session�� �ɾ�� ���� �ʳ�!
	   @PostMapping("/loginProcess")
	   public ModelAndView loginfProcess(HttpSession session, MemberVO vo,
	         @RequestHeader("User-Agent") String uesrAgent) {
	      System.out.println("User-Agent : "+uesrAgent);
	      ModelAndView mav = new ModelAndView("redirect:/main");
	      MemberVO dto =memberList.loginCheck(vo);
	      if(dto == null) {
	         mav.setViewName("error/paramException");
	         mav.addObject("emsg", "�α��� ���� �Դϴ�.");
	      }else {
	      
	         session.setAttribute("sessionNo",dto.getMem_no());
	         session.setAttribute("sessionId", dto.getMem_id());
	         System.out.println("�α��� �մϴ�!");
	         System.out.println("Mem_no : " + dto.getMem_no());
	         System.out.println("Mem_ID : " + dto.getMem_id());
	      }
	      return mav;
	   }
	   @GetMapping("/logout")
	   public ModelAndView loginfoutProcess(HttpSession session) {
	      ModelAndView mav = new ModelAndView();
	      session.removeAttribute("sessionNo");
	      session.removeAttribute("sessionId");
	      System.out.println("�α׾ƿ��մϴ�");
	      mav.setViewName("redirect:/main");
	      return mav;
	   }
}