package mobile.kosmo.mvc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.UpBoardDTO;

@Repository("upBoardList")
public class UpBoardDao implements UpBoardDaoInter{

	@Autowired
	private SqlSessionTemplate ss;
	public void addUpBoard(UpBoardDTO vo) {
		ss.insert("upboard.add", vo);	
	}

	public int getCnt(){
		int cnt = ss.selectOne("upboard.totalCount");
		return cnt;
	}
	// 페이징 처리가 완료될 리스트
	public List<UpBoardDTO> getList(Map<String, Integer> map){
		
		//Map<String, Integer> map = new HashMap<String, Integer>();
		//map.put("begin", 11);
		//map.put("end", 20);
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







