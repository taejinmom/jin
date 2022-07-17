package kr.co.bteam.mvc.dao;

import java.util.List;

import kr.co.bteam.mvc.vo.MemberVO;
import kr.co.bteam.mvc.vo.OrdersVO;
import kr.co.bteam.mvc.vo.SearchVO;
import kr.co.bteam.mvc.vo.SuperVO;

public interface OrdersDaoInter extends OrdersStatusInter {

	public int getCnt(MemberVO mvo);
	public void addOrders(OrdersVO vo);
	public List<? extends SuperVO> getList(SearchVO vo);
	
}
