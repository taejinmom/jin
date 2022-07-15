package kr.co.bteam.mvc.dao;

import java.util.List;

import kr.co.bteam.mvc.orderadvice.OrdersStatusInter;
import kr.co.bteam.mvc.vo.OrdersVO;

public interface OrdersDaoInter extends OrdersStatusInter{
	
	public void addOrders(OrdersVO vo);
	public List<OrdersVO> getList(int mem_no);
	

}
