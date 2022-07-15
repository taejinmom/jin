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
	
	@PostMapping(value = "/orderIn")
	public ModelAndView addOrders(OrdersVO vo,HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/main");
		int mem_no = (int) session.getAttribute("sessionNo");
		int ord_count = Integer.parseInt(request.getParameter("number"));
		vo.setMem_no(mem_no);
		vo.setOrd_count(ord_count);
		System.out.println(vo.getOrd_address());
		System.out.println(vo.getOrd_name());
		System.out.println(vo.getOrd_count());
		System.out.println(vo.getMem_no());
		System.out.println("orderIn 작동1");
		ordersDaoInter.addOrders(vo);
		System.out.println("orderIn 작동2");
		return mav;
	}
	

	
}
