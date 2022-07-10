package kr.co.kosmo.mvc.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.BoardVO;
import kr.co.kosmo.mvc.vo.SuperDTO;

@Repository("boardList")
public class BoardDao implements BoardDaoInter{

	@Autowired
	private SqlSessionTemplate ss;
	
	@Override
	public void addBoard(BoardVO vo) {
		ss.insert("board.add", vo);
	}

	@Override
	public BoardVO getDetail(int num) {
		return ss.selectOne("board.detail", num);
	}

	@Override
	public List<? extends SuperDTO> getList(Map<String, Integer> map) {
		return ss.selectList("board.listpage", map);
	}

	@Override
	public int getCnt() {
		int cnt = ss.selectOne("board.totalCount");
		return cnt;
	}
	@Override
	public void viewCount(int num) {
		ss.update("board.viewCount",num);
	}

}
