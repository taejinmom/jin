package kr.co.kosmo.mvc.controller.upload;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}