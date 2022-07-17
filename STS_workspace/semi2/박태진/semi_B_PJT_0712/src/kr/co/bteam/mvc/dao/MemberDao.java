package kr.co.bteam.mvc.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.bteam.mvc.vo.MemberVO;
import kr.co.bteam.mvc.vo.SuperVO;


@Repository("memberList")
public class MemberDao implements MemberDaoInter{

	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public void addMember(MemberVO vo) {
		ss.insert("ptj_member.add", vo);}
	@Override
	public List<? extends SuperVO> getList(Map<String, Integer> map) {
		return null;}
	@Override
	public int idcheck(String id) {
		return ss.selectOne("ptj_member.idchk", id);}
	
	public int getCnt(){
		return ss.selectOne("ptj_member.totalCount");}

	@Override
	public MemberVO loginCheck(MemberVO vo) {
		return ss.selectOne("ptj_member.login", vo);}

	
	
	
	
	
	
	
	
	
	
	//1-1 회원의 정보보기 (info) 
	@Override
	public MemberVO memberInfo(String id) {
		return ss.selectOne("ptj_member.info",id);}
	//1-2 회원의 정보수정 (memberupdate)
	@Override
	public void memberUpdate(MemberVO vo) {
		ss.update("ptj_member.memberupdate",vo);}

}






















