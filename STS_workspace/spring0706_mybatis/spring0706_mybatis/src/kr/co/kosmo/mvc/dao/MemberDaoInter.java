package kr.co.kosmo.mvc.dao;

import kr.co.kosmo.mvc.vo.MemerDTO;

public interface MemberDaoInter {
	public void addMember(MemerDTO dto);
	public int idcheck(String id); 
}
