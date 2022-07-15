package kr.co.bteam.mvc.dao;

import java.util.List;

import kr.co.bteam.mvc.vo.ItemVO;

public interface ItemDaoInter extends PageListInter{
	public List<ItemVO> getList(String i_gender);
	public List<ItemVO> categoryList();
//	public ItemVO getDetail(ItemVO vo);
	public int getCnt();
	public ItemVO getDetail(int num);
}
