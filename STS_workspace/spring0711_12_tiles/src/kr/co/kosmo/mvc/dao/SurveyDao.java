package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

@Repository
public class SurveyDao {
	// 공통빈 : spring/root-context.xml 에서 SqlSessionTemplate 자동으로 주입
	@Autowired
	private SqlSessionTemplate ss;
	
	public void addSurvey(SurveyVO vo) {
		ss.insert("survey.add", vo);
	}
	public void addSurveyContent(List<SurveyContentVO> list) {
		ss.insert("survey.addcontent", list);
	}
	public SurveyVO adminDetail(int num){
		SurveyVO vo = ss.selectOne("survey.adminDetail",num);
		// 검수용!---------------------------
		List<SurveyContentVO> list = vo.getSubvey();
		System.out.println("Size:"+list.size());
		return vo;
	}
}
