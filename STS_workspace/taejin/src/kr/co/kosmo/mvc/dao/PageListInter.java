package kr.co.kosmo.mvc.dao;

import java.util.List;
import java.util.Map;

import kr.co.kosmo.mvc.vo.SuperDTO;

public interface PageListInter {
	public List<? extends SuperDTO> getList(Map<String, Integer> map);
	
}
