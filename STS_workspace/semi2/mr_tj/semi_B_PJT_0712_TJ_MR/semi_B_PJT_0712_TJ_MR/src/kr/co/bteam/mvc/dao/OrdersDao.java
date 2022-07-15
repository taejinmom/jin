package kr.co.bteam.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.bteam.mvc.vo.MemberVO;
import kr.co.bteam.mvc.vo.OrdersVO;
import kr.co.bteam.mvc.vo.SearchVO;
import kr.co.bteam.mvc.vo.SuperVO;

@Repository("orderList")
public class OrdersDao implements OrdersDaoInter{

	@Autowired
	private SqlSessionTemplate ss;
	
	@Override
	public List<? extends SuperVO> getList(SearchVO vo) {
		return ss.selectList("cmr_orders.listpage", vo);
	}

	@Override
	public int getCnt(MemberVO mvo) {
		int cnt = ss.selectOne("cmr_orders.totalCount", mvo);
		System.out.println("cnt "+cnt);
		return cnt;
	}

}
