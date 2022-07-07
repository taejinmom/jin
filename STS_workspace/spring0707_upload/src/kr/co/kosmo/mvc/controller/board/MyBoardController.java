package kr.co.kosmo.mvc.controller.board;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.BoardDaoInter;
import kr.co.kosmo.mvc.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class MyBoardController {
	@Autowired
	private BoardDaoInter boarDaoInter;
	
	@RequestMapping(value="/boardForm")
	public ModelAndView bordForm() {
		
		ModelAndView mav = new ModelAndView("board/boardForm");
		return mav;
	}
	@RequestMapping(value = "boardlist")
	public String boardList(Model m) {
		m.addAttribute("list", boarDaoInter.boardList());
		return "board/boardList";
	}
	
	@RequestMapping(value="/boardDetail")
	public String boardDetail(Model model,int num) {
		model.addAttribute("vo", boarDaoInter.Detail(num));
		return "board/boardDetail";
	}
	@RequestMapping(value = "/boardIn")
	public String boardIn() {
		return "redirect:/main";
	}
}
