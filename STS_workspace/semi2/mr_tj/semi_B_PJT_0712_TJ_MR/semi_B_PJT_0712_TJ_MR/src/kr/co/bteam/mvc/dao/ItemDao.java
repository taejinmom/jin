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

	@Override
	public ItemVO getDetail(int num) {
		// TODO Auto-generated method stub
		return ss.selectOne("jhy_item.detail", num);
	}



}
