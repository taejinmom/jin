package mobile.kosmo.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.kosmo.mvc.vo.UpBoardDTO;
import mobile.kosmo.mvc.dao.UpBoardDaoInter;



@Controller
public class DefaultMobileController {

	@Autowired
	private UpBoardDaoInter upBoardList;
	
	@RequestMapping(value= {"/","/main"})
	public String defaultMPage(Model m) {
		
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", 11);
		map.put("end", 20);
		List<UpBoardDTO> list = (List<UpBoardDTO>) upBoardList.getList(map);
		
		m.addAttribute("list", list);
		
		return "index";
	}
}





