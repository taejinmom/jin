package kr.co.bteam.mvc.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.bteam.mvc.vo.ItemVO;
import kr.co.bteam.mvc.vo.SuperVO;

@Repository("itemList")
public class ItemDao implements ItemDaoInter{

	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public int getCnt() {
		int cnt = ss.selectOne("jhy_item.totalCount");
		return cnt;
	}

	@Override
	public List<ItemVO> getList(String i_gender) {
		return ss.selectList("jhy_item.list", i_gender);
	}
	
	@Override
	public List<ItemVO> categoryList() {
		return ss.selectList("jhy_item.category");
	}

//	@Override
//	public ItemVO getDetail(ItemVO vo) {
//		return ss.selectOne("jhy_item.detail", vo);
//	}
//
//	@Override
//	public List<? extends SuperDTO> getList(Map<String, Integer> map) {
//		return ss.selectList("jhy_item.list", map);
//	}

	@Override
	public List<? extends SuperVO> getList(Map<String, Integer> map) {
		return ss.selectList("jhy_item.listpage", map);
	}
	
	//상품 리스트에서 상품명 클릭 시 상세보기 페이지로 넘어갈때  해당 상품의 PK를 기준으로 데이터를 뽑아서 보여주는 리스트
	@Override
	public ItemVO getDetail(int num) {
		return ss.selectOne("jhy_item.detail", num);
	}



}
