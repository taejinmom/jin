package kr.co.kosmo.mvc.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.kosmo.mvc.dao.SurveyDao;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;
//<context:component-scan base-package="kr.co.kosmo.mvc"/>
// @Service,@Repository, @Component, @Configuration, @Controller,
// @RestController, @ControllerAdvice
// 비지니스 로직을 담당 할 수 있다.
@Service
public class SurveyService {
	@Autowired
	private SurveyDao surveyDao;
	
	// Transaction 처리를 하기 위해서 
	// 공통빈에서 설정 <tx:annotation-driven> , DataSourceTransactionManager di
	@Transactional
	public void addSurvey(SurveyVO vo,List<SurveyContentVO> list) {
		//
		surveyDao.addSurvey(vo);
		surveyDao.addSurveyContent(list);
		//
	}
	
	public SurveyVO adminDetail(int num){
		return surveyDao.adminDetail(num);
	}
}
