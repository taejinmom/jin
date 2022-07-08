package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.BoardVO;

@Repository
public class BoardDao implements BoardDaoInter{

	@Autowired
	private SqlSessionTemplate ss;
	
	@Override
	public void addBoard(BoardVO vo) {
		ss.insert("board.add", vo);
	}

	@Override
	public List<BoardVO> getList() {
		return ss.selectList("board.list");
	}

	@Override
	public BoardVO getDetail(int num) {
		return ss.selectOne("board.detail", num);
	}

}
