package kr.co.bteam.mvc.dao;




import java.util.Map;

import kr.co.bteam.mvc.vo.MemberVO;

public interface MemberDaoInter extends PageListInter{
	public void addMember(MemberVO vo); //ȸ������
	public int idcheck(String id);  // ���̵� �ߺ� üũ
	public int getCnt(); // ������ -> ȸ������Ʈ ��½� �ʿ��� �޼���
	public MemberVO loginCheck(MemberVO vo); //�α��� �޼���
	public MemberVO memberInfo(String id); //����������
//	public void memberUpdate(Map<String, String> map);
	public void memberUpdate(MemberVO vo);
}
