package kr.co.kosmo.mvc.dao;

import java.util.List;

import kr.co.kosmo.mvc.vo.BoardVO;

public interface BoardDaoInter {
	public void addBoard(BoardVO vo);
	public List<BoardVO> getList();
	public BoardVO getDetail(int num);
}
