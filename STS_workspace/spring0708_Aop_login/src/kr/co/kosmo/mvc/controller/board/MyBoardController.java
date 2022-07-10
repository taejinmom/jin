package kr.co.kosmo.mvc.controller.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.BoardDaoInter;
import kr.co.kosmo.mvc.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class MyBoardController {
	
	@Autowired
	private BoardDaoInter boardDaoInter;
	
	@GetMapping(value = "/boardForm")
	public ModelAndView boardForm() {
		ModelAndView mav = new ModelAndView("board/boardForm");
		return mav;
	}
	
	@PostMapping(value = "/boardIn")
	public String boardIn(BoardVO vo) {
		boardDaoInter.addBoard(vo);
		return "redirect:/main";
	}
	
	@GetMapping(value = "/boardList")
	public String boardList(Model m, String cPage) {
		int totalRecord = boardDaoInter.getCnt();
		m.addAttribute("totalRecord", totalRecord);
		return "board/boardList";
	}
	
	@GetMapping(value = "/boardDetail")
	public String boardDetail(Model model, int num) {
		BoardVO vo = boardDaoInter.getDetail(num);
		model.addAttribute("vo", vo);
		return "board/boardDetail";
	}
}
