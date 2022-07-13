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

	 //PageListInter �� getBean �޾ƿ��� ���ؼ� ..
	 @Autowired
	 private ApplicationContext applicationContext;
	
	 private  int nowPage = 1;// ���� ������ ��
	 private  int nowBlock = 1;// ���� ��
	 private  int totalRecord = 0;// �� �Խù� ��   
	 private  int numPerPage = 10;// �� �������� ������ �Խù� ��
	 private  int pagePerBlock = 5;// �� ���� ������ ������ ��
	 private  int totalPage = 0;// ��ü ������ �� => totalRecord/numPerPage
	 private  int totalBlock = 0;// ��ü �� ��   
	 private  int beginPerPage = 0;// �� �������� ���� �Խù��� index��
	 private  int endPerPage = 0;// �� �������� ������ �Խù��� index��  
	 
	 @Around("execution(* kr.co.kosmo.mvc.controller.*.*Controller.*List(..))")
	 public String pageModule(ProceedingJoinPoint jp) {
		 //------------ ����ó�� ���� 
		 Object[] args = jp.getArgs();
		 //ù��° ���� : Model, �ι�° ���� : �������� String cPage
		 Model m = (Model) args[0];
		 String cPage = (String) args[1];
		 
		 // Model������ �ִ� Ŭ������ �̸��� �����ͼ� �ᱹ Dao�� �����ڷ� ����ϰڴ�.
		 //upBoardList or memberList  => ������ Dao�� Bean�� �̸����� ���� 
		 String myDao = jp.getSignature().getName();
		 System.out.println("myDao =>"+myDao);
		 // ��������� UpBoardDao, MemberDao�� ������ �̸��� upBoardList or memberList �����Ǿ� �־�� �ҷ� �� �� �ִ�.
		 // @Repository("memberList")
		 PageListInter pageListInter =   applicationContext.getBean(myDao,PageListInter.class);
		String url=null;
		try {
			url = (String) jp.proceed();
			 // total���� ���� �ͺ���.
			 totalRecord = (int) m.asMap().get("totalRecord");
			 System.out.println("totalRecord =>"+totalRecord);
			 //----------���� ������ �ڵ带 �ٿ� �ֱ�
			 // �� �Խù� �� ��������
			totalPage = (int) Math.ceil(totalRecord/(double)numPerPage);
			totalBlock = (int) Math.ceil((double) totalPage/pagePerBlock);
			//���� �������� ��û�� �� �Ķ���ͷ� ���� ���������� �޴´�. 1 ~~~~~~~ n
			//String s_page = request.getParameter("cPage");
			String s_page = cPage;
			if(s_page != null){
				nowPage = Integer.parseInt(s_page);
		    }
			// begin ~ end  ���ϴ� ����
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







