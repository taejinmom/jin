package kr.co.bteam.mvc.dao;

import kr.co.bteam.mvc.vo.MemberVO;

public interface MemberDaoInter {

	public void addMember(MemberVO vo);//회원가입
	public MemberVO memberInfo(String id); //마이페이지
	public int idcheck(String id); //아이디 중복체크
	public int getCnt();//관리자 - 총 회원수(memberList뽑을때)
	public MemberVO loginCheck(MemberVO vo); //로그인
}
