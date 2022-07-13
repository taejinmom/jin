package kr.co.kosmo.mvc.aop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import kr.co.kosmo.mvc.dao.PageListInter;
import kr.co.kosmo.mvc.vo.SuperDTO;

@Component
@Aspect
public class PageModulesAdvice {

	 //PageListInter 를 getBean 받아오기 위해서 ..
	 @Autowired
	 private ApplicationContext applicationContext;
	
	 private  int nowPage = 1;// 현재 페이지 값
	 private  int nowBlock = 1;// 현재 블럭
	 private  int totalRecord = 0;// 총 게시물 수   
	 private  int numPerPage = 10;// 한 페이지당 보여질 게시물 수
	 private  int pagePerBlock = 5;// 한 블럭당 보여질 페이지 수
	 private  int totalPage = 0;// 전체 페이지 수 => totalRecord/numPerPage
	 private  int totalBlock = 0;// 전체 블럭 수   
	 private  int beginPerPage = 0;// 각 페이지별 시작 게시물의 index값
	 private  int endPerPage = 0;// 각 페이지별 마지막 게시물의 index값  
	 
	 @Around("execution(* kr.co.kosmo.mvc.controller.*.*Controller.*List(..))")
	 public String pageModule(ProceedingJoinPoint jp) {
		 //------------ 선행처리 영역 
		 Object[] args = jp.getArgs();
		 //첫번째 인자 : Model, 두번째 인자 : 페이지값 String cPage
		 Model m = (Model) args[0];
		 String cPage = (String) args[1];
		 
		 // Model가지고 있는 클래스의 이름을 가져와서 결국 Dao의 선택자로 사용하겠다.
		 //upBoardList or memberList  => 각각의 Dao의 Bean의 이름으로 선택 
		 String myDao = jp.getSignature().getName();
		 System.out.println("myDao =>"+myDao);
		 // 결과적으로 UpBoardDao, MemberDao는 무조건 이름이 upBoardList or memberList 설정되어 있어야 불려 올 수 있다.
		 // @Repository("memberList")
		 PageListInter pageListInter =   applicationContext.getBean(myDao,PageListInter.class);
		String url=null;
		try {
			url = (String) jp.proceed();
			 // total값을 가져 와보자.
			 totalRecord = (int) m.asMap().get("totalRecord");
			 System.out.println("totalRecord =>"+totalRecord);
			 //----------기존 페이지 코드를 붙여 넣기
			 // 총 게시물 수 가져오기
			totalPage = (int) Math.ceil(totalRecord/(double)numPerPage);
			totalBlock = (int) Math.ceil((double) totalPage/pagePerBlock);
			//현재 페이지를 요청할 때 파라미터로 현재 페이지값을 받는다. 1 ~~~~~~~ n
			//String s_page = request.getParameter("cPage");
			String s_page = cPage;
			if(s_page != null){
				nowPage = Integer.parseInt(s_page);
		    }
			// begin ~ end  구하는 공식
			beginPerPage = (nowPage - 1) * numPerPage + 1;
			endPerPage = (beginPerPage-1) + numPerPage;
			Map<String, Integer> map = new HashMap<String, Integer>();
		    map.put("begin", beginPerPage);
		    map.put("end", endPerPage);
		    List<? extends SuperDTO> list = pageListInter.getList(map); 
		    m.addAttribute("list", list);
			int startPage = (int)((nowPage-1)/pagePerBlock)*pagePerBlock+1;
			int endPage = startPage + pagePerBlock - 1;
			if(endPage > totalPage){
				endPage = totalPage;
		    }
			System.out.println("startPage:"+startPage);
			System.out.println("endPage:"+endPage);
			m.addAttribute("startPage", startPage);
			m.addAttribute("endPage", endPage);
			m.addAttribute("nowPage", nowPage);
			m.addAttribute("pagePerBlock", pagePerBlock);
			m.addAttribute("totalPage",totalPage);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		 
		 return url;
	 }
}







