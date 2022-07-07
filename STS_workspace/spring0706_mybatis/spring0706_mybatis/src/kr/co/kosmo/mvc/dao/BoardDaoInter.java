package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.BoardVO;
public interface BoardDaoInter {
	
	public void boardInsert(BoardVO vo);
	public String Detail(int num);
	public List<BoardVO> boardList();
	
}
