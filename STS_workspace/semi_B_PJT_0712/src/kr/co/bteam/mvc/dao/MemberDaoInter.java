package kr.co.bteam.mvc.dao;

import kr.co.bteam.mvc.vo.MemberVO;

public interface MemberDaoInter {

	public void addMember(MemberVO vo);//ȸ������
	public MemberVO memberInfo(String id); //����������
	public int idcheck(String id); //���̵� �ߺ�üũ
	public int getCnt();//������ - �� ȸ����(memberList������)
	public MemberVO loginCheck(MemberVO vo); //�α���
}
