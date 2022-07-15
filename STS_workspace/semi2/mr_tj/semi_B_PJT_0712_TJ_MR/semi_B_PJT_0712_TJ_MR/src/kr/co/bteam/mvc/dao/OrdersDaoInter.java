package kr.co.bteam.mvc.dao;

import java.util.List;

import kr.co.bteam.mvc.vo.MemberVO;
import kr.co.bteam.mvc.vo.SearchVO;
import kr.co.bteam.mvc.vo.SuperVO;

public interface OrdersDaoInter {

	public int getCnt(MemberVO mvo);
	public List<? extends SuperVO> getList(SearchVO vo);
	
}
