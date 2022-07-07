package kr.co.kosmo.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.MemerDTO;

//Dao���� @Repository ��� => Dao�� ������ ��� �����ش�.
//�̱����̴�. �⺻��
@Repository
public class MemberDao implements MemberDaoInter{
	// kosmo-web.xml���� ������ bean byName
	// ��, <bean id="ss" class="org.mybatis.spring.SqlSessionTemplate"> ����
	// SqlSession ss = FactoryService.getFactory().openSession(true); ��� 
	@Autowired
	private SqlSessionTemplate ss;
	//public void setSs(SqlSessionTemplate ss) {
	//	this.ss = ss;
	//}
	@Override
	public void addMember(MemerDTO dto) {
		//autocommit, autoclose()  => Template �� ���� ���ش�.
		ss.insert("member.add", dto);
	}

	@Override
	public int idcheck(String id) {
		// TODO Auto-generated method stub
		return ss.selectOne("member.idchk", id);
	}

}




