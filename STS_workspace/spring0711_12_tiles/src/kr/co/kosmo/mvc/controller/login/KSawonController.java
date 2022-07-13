package kr.co.kosmo.mvc.controller.login;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.SawonDao;
import kr.co.kosmo.mvc.vo.DeptVO;
import kr.co.kosmo.mvc.vo.SawonVO;

@Controller
public class KSawonController {

	@Autowired
	private SawonDao sawonDao;
	
	@GetMapping("sPhoneList")
	public String sawonPhonelist(Model m) {
		List<SawonVO> list = sawonDao.getSawonPhoneList();
		m.addAttribute("splist", list);
		return "sawonPhoneList";
	}
	@GetMapping("deptForm")
	public String deptchooseForm() {
		return "deptchooseform";
	}
	@PostMapping("deptlist")
	public ModelAndView deptlist(int deptno) {
		ModelAndView mav = new ModelAndView("deptList");
		DeptVO list  = sawonDao.getDeptList(deptno);
		mav.addObject("dlist",list);
		return mav;
	}
}
