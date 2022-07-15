package kr.co.bteam.mvc.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.bteam.mvc.vo.OrdersVO;
@Repository("addOrders")
public class OrdersDao implements OrdersDaoInter {
	@Autowired
	private SqlSessionTemplate ss;
	


	@Override
	public List<OrdersVO> getList(int mem_no) {
		return ss.selectList("jhy_item.purchaseList",mem_no);
	}



	@Override
	public void addOrders(OrdersVO vo) {
		ss.insert("ptj_orders.add",vo);
	}



	@Override
	public void statusUpdate(Map<String, Integer> map) {
		ss.update("ptj_orders.status",map);
	}	
		
	
	
}
