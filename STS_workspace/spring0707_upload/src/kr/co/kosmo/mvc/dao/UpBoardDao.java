package kr.co.kosmo.mvc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.UpBoardDTO;
@Repository
public class UpBoardDao implements UpBoardDaoInter{

	@Autowired
	private SqlSessionTemplate ss;
	
	public void addUpBoard(UpBoardDTO vo) {
		ss.insert("upboard.add",vo);
	}
	public int getCnt(){
		int cnt = ss.selectOne("upboard.totalCount");
		return cnt;
	}
	
	public List<UpBoardDTO> getList(Map<String, Integer> map){
		List<UpBoardDTO> list = ss.selectList("upboard.listpage",map);
		return list;
	}
	// detail 
	public UpBoardDTO getDetail(int num) {
		UpBoardDTO vo = ss.selectOne("upboard.detail", num);
		return vo;
	}
	
	public void upUpBoard(UpBoardDTO vo) {
		ss.update("upboard.update", vo);
	}
	public void upDelete(int num) {
		ss.delete("upboard.del", num);
	}
}







