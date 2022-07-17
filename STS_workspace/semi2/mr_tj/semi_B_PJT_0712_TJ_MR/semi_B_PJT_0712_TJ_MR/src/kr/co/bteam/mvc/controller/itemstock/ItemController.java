package kr.co.bteam.mvc.controller.itemstock;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.bteam.mvc.dao.ItemDaoInter;
import kr.co.bteam.mvc.dao.ReviewDaoInter;
import kr.co.bteam.mvc.service.ReviewsService;
import kr.co.bteam.mvc.vo.ItemVO;
import kr.co.bteam.mvc.vo.MemberVO;
import kr.co.bteam.mvc.vo.ReviewsVO;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemDaoInter itemList;
	@Autowired
	private ReviewsService service;
	
	@GetMapping(value = "/itemList")
	public String itemList(Model m,String gender) {
		String i_gender = "";
		if (gender.equals("m")) {
			i_gender = "남성";
		} else if (gender.equals("w")) {
			i_gender = "여성";
		}
		
//		int total = itemList.getCnt();
//		m.addAttribute("totalRecord", total);
		List<ItemVO> list = itemList.getList(i_gender);
		m.addAttribute("list", list);
		return "item/itemList";
	}
	
	@GetMapping(value = "/purchaseform")
	public String purChaseForm() {
	
		return "item/purchaseForm";
	}
	@GetMapping(value = "/numchk")
	public String numberCheck(Model m , int num) {
		m.addAttribute("numchk", num);
		System.out.println("뭐라도");
		return "/item/numchk";
		
	}
	
//	@GetMapping("/itemList")
//	public String itemList(Model m, String cPage, String gender) {
//		int totalRecord = itemList.getCnt();
//		m.addAttribute("totalRecord", totalRecord);
//		
//		String i_gender = "";
//		if (gender.equals("m")) {
//			i_gender = "남성";
//		} else if (gender.equals("w")) {
//			i_gender = "여성";
//		}
//		
//		List<ItemVO> list = itemList.getList(i_gender);
//		m.addAttribute("list", list);
//		return "item/itemList";
//	}

	@GetMapping(value = "/categoryList")
	public String itemList2(Model m) {
		List<ItemVO> list = itemList.categoryList();
		m.addAttribute("category", list);
		return "item/categoryList";
	}

	@GetMapping(value = "/itemDetail")
	public String itemDetail(Model m, int s_no) {
		System.out.println("s_no : " +s_no);
		ItemVO vo = itemList.getDetail(s_no);
		int i_no = vo.getI_no();
		m.addAttribute("detail", vo);
		
		List<ReviewsVO> rvo = service.getReviews(i_no); 
		//controller - service - dao 순
		//상품번호에 해당하는 리뷰 리스트 
		m.addAttribute("list", rvo);
		
		return "item/itemDetail";
	}
}
