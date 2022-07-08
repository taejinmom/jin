package kr.co.kosmo.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.MemberDTO;

// Dao단은 @Repository 사용 => Dao를 Bean으로 등록시켜준다.
// 싱글톤
@Repository
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
	public int login(MemberDTO dto) {
		return ss.selectOne("member.login", dto);
	}
}
