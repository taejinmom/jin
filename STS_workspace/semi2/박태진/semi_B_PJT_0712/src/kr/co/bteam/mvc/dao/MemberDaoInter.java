package kr.co.bteam.mvc.dao;




import java.util.Map;

import kr.co.bteam.mvc.vo.MemberVO;

public interface MemberDaoInter extends PageListInter{
	public void addMember(MemberVO vo); //ȸ������
	public int idcheck(String id);  // ���̵� �ߺ� üũ
	public int getCnt(); // ������ -> ȸ������Ʈ ��½� �ʿ��� �޼���
	public MemberVO loginCheck(MemberVO vo); //�α��� �޼���
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//1-1 ȸ���� �������� (info) 
	public MemberVO memberInfo(String id); 
	//1-2 ȸ���� �������� (memberupdate)
	public void memberUpdate(MemberVO vo);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
