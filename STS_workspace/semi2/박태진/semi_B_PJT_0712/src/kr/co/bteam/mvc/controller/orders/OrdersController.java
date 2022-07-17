package kr.co.bteam.mvc.controller.orders;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.bteam.mvc.dao.OrdersDaoInter;
import kr.co.bteam.mvc.vo.OrdersVO;

@Controller
@RequestMapping(value = "/orders")
public class OrdersController {
	@Autowired
	private OrdersDaoInter ordersDaoInter;
	
	//구매하기 버튼을 눌러 최종적으로 구입
	@PostMapping(value = "/orderIn")
	public ModelAndView addOrders(OrdersVO vo,
			HttpServletRequest request,HttpSession session) {
		
		ModelAndView mav = new ModelAndView("redirect:/main");//메인 페이지로 setViewName
		int mem_no = (int) session.getAttribute("sessionNo");//로그인 되어있는 사용자의 회원 번호
		int ord_count = Integer.parseInt(request.getParameter("number"));//구매할 상품의 상품번호
		vo.setMem_no(mem_no);
		vo.setOrd_count(ord_count);
		ordersDaoInter.addOrders(vo);
		return mav;
	}
}
