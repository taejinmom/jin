package kr.co.kosmo.mvc.dao;

import kr.co.kosmo.mvc.vo.MemerDTO;

public interface MemberDaoInter extends PageListInter{
	public void addMember(MemerDTO dto);
	public int idcheck(String id); 
	public int getCnt();
	public MemerDTO loginCheck(MemerDTO vo);
}
