package kr.co.kosmo.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.MemberDTO;

// Dao���� @Repository ��� => Dao�� Bean���� ��Ͻ����ش�.
// �̱���
@Repository
public class MemberDao implements MemberDaoInter{
	
	@Autowired
	private SqlSessionTemplate ss;
	
	@Override
	public void addMember(MemberDTO dto) {
		// autocommit, autoclose() => Template�� �������ش�.
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
