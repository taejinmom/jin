package kr.co.kosmo.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.MemerDTO;

//Dao단은 @Repository 사용 => Dao를 빈으로 등록 시켜준다.
//싱글톤이다. 기본이
@Repository
public class MemberDao implements MemberDaoInter{
	// kosmo-web.xml에서 정의한 bean byName
	// 즉, <bean id="ss" class="org.mybatis.spring.SqlSessionTemplate"> 에서
	// SqlSession ss = FactoryService.getFactory().openSession(true); 대신 
	@Autowired
	private SqlSessionTemplate ss;
	//public void setSs(SqlSessionTemplate ss) {
	//	this.ss = ss;
	//}
	@Override
	public void addMember(MemerDTO dto) {
		//autocommit, autoclose()  => Template 로 관리 해준다.
		ss.insert("member.add", dto);
	}

	@Override
	public int idcheck(String id) {
		// TODO Auto-generated method stub
		return ss.selectOne("member.idchk", id);
	}

}




