package kr.co.kosmo.mvc.dao;

import java.util.List;
import java.util.Map;

import kr.co.kosmo.mvc.vo.MemerDTO;
import kr.co.kosmo.mvc.vo.SuperDTO;

public interface MemberDaoInter extends PageListInter{
	public void addMember(MemerDTO dto);
	public int idcheck(String id); 
	public int getCnt();
	public List<? extends SuperDTO> getList(Map<String, Integer> map);
}
