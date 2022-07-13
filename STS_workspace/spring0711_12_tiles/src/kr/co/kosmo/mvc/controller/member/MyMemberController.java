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
		// �¶��� - ���͵� / 20�� ..
		//��û�� member/idcheck?id=xman �� �� ���̵� �ߺ� üũ�� ���ִ� ���� �����
		// mymember/idchk.jsp�� msg���� �����ؼ� ����Ͻÿ�.
		// msg => ��뿩�� ��� 
		// �ݵ�� id�� �Ķ���Ͱ� �־�� �Ѵ�.(üũ ���) 
		@GetMapping(value="/idcheck")
		public String idCheck(Model m,@RequestParam("id") String id) {
			System.out.println("idAjax:"+id);
			int cnt = memberDaoInter.idcheck(id);
			System.out.println("Cnt:"+cnt);
			//String msg ="�̹� ������� ���̵� �Դϴ�.";
			//if(cnt == 0) {
			//	 msg ="��� ������ ���̵� �Դϴ�.";
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











