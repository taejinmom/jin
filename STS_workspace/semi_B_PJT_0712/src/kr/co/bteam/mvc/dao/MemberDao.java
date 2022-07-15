package kr.co.bteam.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.bteam.mvc.vo.MemberVO;
@Repository
	public class MemberDao implements MemberDaoInter{
	@Autowired
	private SqlSessionTemplate ss;
	@Override
	public void addMember(MemberVO vo) {
		ss.insert("ptj_member.add",vo);
	}

	@Override
	public MemberVO memberInfo(String id) {
		
		return ss.selectOne("ptj_member.info",id);
	}

	@Override
	public int idcheck(String mem_id) {
		return ss.selectOne("ptj_member.idchk", mem_id);
	}

	
	public int getCnt(){
		int cnt = ss.selectOne("ptj_member.totalCount");
		return cnt;
	}

	@Override
	public MemberVO loginCheck(MemberVO vo) {
		return ss.selectOne("ptj_member.login", vo);
	}

}
