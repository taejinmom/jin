package kr.co.bteam.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.bteam.mvc.vo.MemberVO;
import kr.co.bteam.mvc.vo.ReviewsVO;

@Repository("review")
public class ReviewDao implements ReviewDaoInter{

	@Autowired
	private SqlSessionTemplate ss;
	
	
	@Override
	public void addReview(ReviewsVO vo) {
		ss.insert("cmr_review.add", vo);
	}
	@Override
	public List<ReviewsVO> getReview(int i_no) {
		List<ReviewsVO> vo = ss.selectList("cmr_review.reviewlist",i_no);
		return vo;
		
	}

	

}
