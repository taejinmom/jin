package kr.co.bteam.mvc.dao;

import java.util.List;
import java.util.Map;

import kr.co.bteam.mvc.vo.SuperVO;

public interface PageListInter {
	public List<? extends SuperVO> getList(Map<String, Integer> map);
	
}
