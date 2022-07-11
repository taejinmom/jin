package kr.co.kosmo.mvc.dao;

import java.util.List;

import kr.co.kosmo.mvc.vo.BoardVO;

public interface BoardDaoInter extends PageListInter{
	public void addBoard(BoardVO vo);
	public BoardVO getDetail(int num);
	public int getCnt();
	public void viewCount(int num);
}
