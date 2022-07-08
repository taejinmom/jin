package kr.co.kosmo.mvc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.BoardVO;
import kr.co.kosmo.mvc.vo.SuperDTO;
public interface BoardDaoInter extends PageListInter{
	
	public void boardInsert(BoardVO vo);
	public String Detail(int num);
	public List<? extends SuperDTO> getList(Map<String, Integer> map);
	
}
