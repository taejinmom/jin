package kr.co.kosmo.mvc.dao;

import java.util.List;
import java.util.Map;

import kr.co.kosmo.mvc.vo.MemberDTO;
import kr.co.kosmo.mvc.vo.SuperDTO;

public interface MemberDaoInter extends PageListInter{
	public void addMember(MemberDTO dto);
	public int idcheck(String id);
	public int getCnt();
	public MemberDTO loginCheck(MemberDTO vo);
	public MemberDTO myPage(String id);
	public List<? extends SuperDTO> myPageBoardList(Map<String, Integer> map);
}
