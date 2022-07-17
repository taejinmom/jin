package kr.co.bteam.mvc.dao;

import java.util.List;

import kr.co.bteam.mvc.vo.ItemVO;

public interface ItemDaoInter extends PageListInter{
	public List<ItemVO> getList(String i_gender);
	public List<ItemVO> categoryList();
//	public ItemVO getDetail(ItemVO vo);
	public int getCnt();
	
	
	
	public ItemVO getDetail(int num);//상품 리스트에서 상품명 클릭 시 상세보기 페이지로 넘어갈때  해당 상품의 PK를 기준으로 데이터를 뽑아서 보여주는 리스트

}
