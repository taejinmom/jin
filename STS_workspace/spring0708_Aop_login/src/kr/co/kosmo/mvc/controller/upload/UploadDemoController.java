package kr.co.kosmo.mvc.controller.upload;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.kosmo.mvc.dao.UpBoardDaoInter;
import kr.co.kosmo.mvc.vo.UpBoardDTO;

@Controller
@RequestMapping("/upload")
public class UploadDemoController {
   @Autowired
	private UpBoardDaoInter upBoardDaoInter;
   
    @RequestMapping(value = "/upform" )
    public String upform() {
    	return "updemo/upform"; // ModelAndView
    }
    @RequestMapping(value = "/uploadpro",method = RequestMethod.POST)
    public String uploadFile(Model m ,UpBoardDTO dto,HttpServletRequest requset) {
    	System.out.println("vo:"+dto.getSub());
    	return "updemo/upform";
    }
   
    @RequestMapping(value = "/uplist")
    public String upboardList(Model m ,String cPage) {
    	int totalRecord = upBoardDaoInter.getCnt();
    	m.addAttribute("totalRecord", totalRecord);
    	
    	return "updemo/uplist";
    }
    @GetMapping(value = "/updetail")
	public String upDetail(Model m, @RequestParam("num") int num) {
		UpBoardDTO dto = upBoardDaoInter.getDetail(num);
		m.addAttribute("uvo", dto);
		return "updemo/updetail";
	}
}