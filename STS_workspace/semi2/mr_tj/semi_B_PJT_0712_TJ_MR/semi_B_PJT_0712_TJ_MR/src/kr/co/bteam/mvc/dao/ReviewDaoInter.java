package kr.co.bteam.mvc.dao;

import java.util.List;

import kr.co.bteam.mvc.vo.MemberVO;
import kr.co.bteam.mvc.vo.ReviewsVO;

public interface ReviewDaoInter {
	
	public void addReview(ReviewsVO vo); 
	
	public List<ReviewsVO> getReview(int i_no);
	
}
