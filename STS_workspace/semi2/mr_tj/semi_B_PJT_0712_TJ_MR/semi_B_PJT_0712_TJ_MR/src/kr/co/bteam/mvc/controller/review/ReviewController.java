package kr.co.bteam.mvc.controller.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.bteam.mvc.dao.ReviewDaoInter;
import kr.co.bteam.mvc.vo.ItemVO;
import kr.co.bteam.mvc.vo.ReviewsVO;

@Controller
@RequestMapping(value = "/review")
public class ReviewController {

	@Autowired
	private ReviewDaoInter reviewDaoInter;
	
	@RequestMapping(value = "/reviewForm")
	public ModelAndView reviewForm() {
		ModelAndView mav = new ModelAndView("review/reviewForm");
		return mav;
	}
	
	@PostMapping(value = "/reviewIn")
	public String addReview(ReviewsVO vo) {
		reviewDaoInter.addReview(vo);
		return "redirect:/member/mypage";
	}
	
	
}





