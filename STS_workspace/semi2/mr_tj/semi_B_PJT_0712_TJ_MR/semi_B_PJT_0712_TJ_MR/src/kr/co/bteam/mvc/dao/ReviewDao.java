package kr.co.bteam.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.bteam.mvc.vo.ReviewsVO;

@Repository("review")
public class ReviewDao implements ReviewDaoInter{

	@Autowired
	private SqlSessionTemplate ss;
	
	
	@Override
	public void addReview(ReviewsVO vo) {
		ss.insert("cmr_review.add", vo);
	}

}
