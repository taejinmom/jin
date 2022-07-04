package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dto.MemerDTO;
import factory.FactoryService;

public class MemberDao {

	private static MemberDao dao;

	private MemberDao() {}
	// 서블릿으로 요청 : synchronized 동기화
	public synchronized static MemberDao getDao() {
		if(dao == null) dao = new MemberDao();
		return dao;
	}
	public void addMember(MemerDTO dto) {
		SqlSession ss = FactoryService.getFactory().openSession(true);
		ss.insert("member.add", dto);
		ss.close();
	}
	// select count(*) from member where id=?
	public int idcheck(String id) {
		SqlSession ss = FactoryService.getFactory().openSession();
		int cnt = ss.selectOne("member.idchk", id);
		ss.close();
		return cnt;
	}
	// myPage
	public MemerDTO myPage(String id) {
		SqlSession ss = FactoryService.getFactory().openSession();
		MemerDTO dto = ss.selectOne("member.mypage", id);
		ss.close();
		return dto;
	}
	// login
	public int login(MemerDTO dto) {
		SqlSession ss = FactoryService.getFactory().openSession();
		int cnt = ss.selectOne("member.login", dto);
		ss.close();
		return cnt;
	}
	public int getCnt(){
		SqlSession ss = FactoryService.getFactory().openSession();
		int cnt = ss.selectOne("member.totalCount");
		ss.close();
		return cnt;
	}
	
	public List<MemerDTO> getList(Map<String, Integer> map){
		SqlSession ss = FactoryService.getFactory().openSession();
		//Map<String, Integer> map = new HashMap<String, Integer>();
		//map.put("begin", 11);
		//map.put("end", 20);
		List<MemerDTO> list = ss.selectList("member.listpage",map);
		ss.close();
		return list;
	}
}




















