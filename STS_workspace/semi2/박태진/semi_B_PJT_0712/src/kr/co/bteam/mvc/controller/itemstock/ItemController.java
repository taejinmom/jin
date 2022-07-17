package kr.co.bteam.mvc.controller.itemstock;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.bteam.mvc.dao.ItemDaoInter;
import kr.co.bteam.mvc.vo.ItemVO;
import kr.co.bteam.mvc.vo.OrdersVO;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemDaoInter itemList;

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
	
	//상품 리스트에서 상품명 클릭 시 상세보기 페이지로 넘어갈때  해당 상품의 PK를 기준으로 데이터를 뽑아서 보여주는 리스트
	@GetMapping(value = "/itemDetail")
	public String itemDetail(Model m, int s_no) {
		System.out.println("s_no : " +s_no);
		//s_no(stock테이블의 pk) = i_no(item테이블의 pk)
		ItemVO vo = itemList.getDetail(s_no);
		m.addAttribute("detail", vo);//itemDetail.jsp로 상세정보를 보내주기
		return "item/itemDetail";
	}
	
	
	//상세보기 페이지에서 구매 버튼 클릭 시 구매 정보를 입력하는 폼으로 이동
	@PostMapping(value = "/order")
	public ModelAndView ordersForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("orders/ordersForm");
		int s_no = Integer.parseInt(request.getParameter("i_no"));
		int stock = Integer.parseInt(request.getParameter("num"));
		int price = Integer.parseInt(request.getParameter("i_price"));
		ItemVO vo = itemList.getDetail(s_no);
		
		mav.addObject("detail", vo);
		mav.addObject("price", price);
		mav.addObject("stock", stock);
		
		return mav;
	}
	
	
	
}
