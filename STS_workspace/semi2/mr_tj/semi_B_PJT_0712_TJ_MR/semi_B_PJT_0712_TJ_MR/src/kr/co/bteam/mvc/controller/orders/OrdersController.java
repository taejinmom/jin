package kr.co.bteam.mvc.controller.orders;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import kr.co.bteam.mvc.dao.OrdersDaoInter;
import kr.co.bteam.mvc.vo.MemberVO;
import kr.co.bteam.mvc.vo.OrdersVO;
import kr.co.bteam.mvc.vo.SearchVO;
import kr.co.bteam.mvc.vo.SuperVO;

@Controller
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private OrdersDaoInter ordersDaoInter;
	
	private int nowPage = 1;// 현재 페이지 값
	private int nowBlock = 1;// 현재 블럭
	private int totalRecord = 0;// 총 게시물 수
	private int numPerPage = 10;// 한 페이지당 보여질 게시물 수
	private int pagePerBlock = 5;// 한 블럭당 보여질 페이지 수
	private int totalPage = 0;// 전체 페이지 수 => totalRecord/numPerPage
	private int totalBlock = 0;// 전체 블럭 수
	private int beginPerPage = 0;// 각 페이지별 시작 게시물의 index값
	private int endPerPage = 0;// 각 페이지별 마지막 게시물의 index값
	
	@RequestMapping(value = "/ordersList")
	public ModelAndView orderList(HttpSession session, String cPage, MemberVO mvo,OrdersVO ovo) {
		ModelAndView mav = new ModelAndView("orders/ordersList");
		System.out.println("여기는 ordersController");
		int mem_no = (int) session.getAttribute("sessionNo");
		mvo.setMem_no(mem_no);
		System.out.println("mem_no : " +mem_no);
		System.out.println("getMem_no : "+mvo.getMem_no());
		totalRecord = ordersDaoInter.getCnt(mvo);
		System.out.println("여기는 getCnt");
		totalPage = (int) Math.ceil(totalRecord / (double) numPerPage);
		totalBlock = (int) Math.ceil((double) totalPage / pagePerBlock);
		if (cPage != null) {
			nowPage = Integer.parseInt(cPage);
		}
		System.out.println("sessionId : "+session.getAttribute("sessionId"));
		beginPerPage = (nowPage - 1) * numPerPage + 1;
		endPerPage = (beginPerPage - 1) + numPerPage;

		SearchVO searvo = new SearchVO();
		searvo.setBeginPerPage(beginPerPage);
		searvo.setEndPerPage(endPerPage);
		
		List<? extends SuperVO> list = ordersDaoInter.getList(searvo);
		int startPage = (int) ((nowPage - 1) / pagePerBlock) * pagePerBlock + 1;
		int endPage = startPage + pagePerBlock - 1;
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		mav.addObject("list", list);
		mav.addObject("startPage", startPage);
		mav.addObject("endPage", endPage);
		mav.addObject("nowPage", nowPage);
		mav.addObject("pagePerBlock", pagePerBlock);
		mav.addObject("totalPage", totalPage);
		
		System.out.println(startPage);
		System.out.println(endPage);
		System.out.println(nowPage);
		System.out.println(pagePerBlock);
		System.out.println(totalPage);
		
		return mav;
	}

	// 주문 삭제
	
	
	
	// 주문 수정
	
	
	
	
	
	
	
}
