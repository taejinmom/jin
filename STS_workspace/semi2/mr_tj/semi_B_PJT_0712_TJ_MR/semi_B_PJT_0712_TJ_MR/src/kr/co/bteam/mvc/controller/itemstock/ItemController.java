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
import kr.co.bteam.mvc.vo.ItemVO;

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

	@GetMapping(value = "/itemDetail")
	public String itemDetail(Model m, int s_no) {
		System.out.println("s_no : " +s_no);
		
		ItemVO vo = itemList.getDetail(s_no);
		System.out.println("getI_price : " +vo.getI_price());
		System.out.println("getI_comm : " +vo.getI_comm());
		System.out.println("getI_gender : " +vo.getI_gender());
		System.out.println("getI_img : " +vo.getI_img());
		System.out.println("getI_no : " +vo.getI_no());
		System.out.println("getI_name : " +vo.getI_name());
		m.addAttribute("detail", vo);
		return "item/itemDetail";
	}
}
