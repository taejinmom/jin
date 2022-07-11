package kr.co.kosmo.mvc.dao;

import kr.co.kosmo.mvc.vo.MemberDTO;

public interface MemberDaoInter extends PageListInter{
	public void addMember(MemberDTO dto);
	public int idcheck(String id);
	public int getCnt();
	public MemberDTO loginCheck(MemberDTO vo);
}
