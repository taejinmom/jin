package kr.co.kosmo.mvc.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.MemberDTO;
import kr.co.kosmo.mvc.vo.SuperDTO;

// Dao단은 @Repository 사용 => Dao를 Bean으로 등록시켜준다.
// 싱글톤
@Repository("memberList")
public class MemberDao implements MemberDaoInter{
	
	@Autowired
	private SqlSessionTemplate ss;
	
	@Override
	public void addMember(MemberDTO dto) {
		// autocommit, autoclose() => Template로 관리해준다.
		ss.insert("member.add", dto);
	}

	@Override
	public int idcheck(String id) {
		return ss.selectOne("member.idchk", id);
	}

	@Override
	public List<? extends SuperDTO> getList(Map<String, Integer> map) {
		return null;
	}

	@Override
	public int getCnt() {
		int cnt = ss.selectOne("member.totalCount");
		return cnt;
	}

	@Override
	public MemberDTO loginCheck(MemberDTO vo) {
		return ss.selectOne("member.login", vo);
	}

	@Override
	public MemberDTO myPage(String id) {
		
		return ss.selectOne("member.mypage",id);
	}
	
	@Override
	public List<? extends SuperDTO> myPageBoardList(Map<String, Integer> map) {
		
		return ss.selectList("board.listpage", map);
	}
	
	

	

	
}
