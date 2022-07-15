package kr.co.bteam.mvc.dao;




import java.util.Map;

import kr.co.bteam.mvc.vo.MemberVO;

public interface MemberDaoInter extends PageListInter{
	public void addMember(MemberVO vo); //회원가입
	public int idcheck(String id);  // 아이디 중복 체크
	public int getCnt(); // 관리자 -> 회원리스트 출력시 필요한 메서드
	public MemberVO loginCheck(MemberVO vo); //로그인 메서드
	public MemberVO memberInfo(String id); //마이페이지
//	public void memberUpdate(Map<String, String> map);
	public void memberUpdate(MemberVO vo);
}
