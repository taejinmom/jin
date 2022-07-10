package kr.co.kosmo.mvc.aop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import kr.co.kosmo.mvc.dao.PageListInter;
import kr.co.kosmo.mvc.vo.SuperDTO;

@Component
@Aspect
public class PageModulesAdvice {

	// PageListInter�� getBean���� �޾ƿ��� ����
	@Autowired
	private ApplicationContext applicationContext;
	
	private int nowPage = 1;// ���� ������ ��
	private int nowBlock = 1;// ���� ��
	private int totalRecord = 0;// �� �Խù� ��
	private int numPerPage = 10;// �� �������� ������ �Խù� ��
	private int pagePerBlock = 5;// �� ���� ������ ������ ��
	private int totalPage = 0;// ��ü ������ �� => totalRecord/numPerPage
	private int totalBlock = 0;// ��ü �� ��
	private int beginPerPage = 0;// �� �������� ���� �Խù��� index��
	private int endPerPage = 0;// �� �������� ������ �Խù��� index��

	@Around("execution(* kr.co.kosmo.mvc.controller.*.*Controller.*List(..))")
	public String pageModule(ProceedingJoinPoint pjp) {
		// ------------------ ���� ó�� ���� ------------------
		Object[] args = pjp.getArgs();
		// ù ��° ���� : Model, �� ��° ���� : �������� String cPage
		Model m = (Model) args[0];
		String cPage = (String) args[1];
		
		// Model�� ������ �ִ� class�� �̸��� �����ͼ� �ᱹ Dao�� �����ڷ� ���ڴ�..
		// upBoardList, memberList => ������ Dao�� Bean�� �̸����� ����
		String myDao = pjp.getSignature().getName();
		System.out.println("myDao : "+myDao);
		
		// ��������� UpBoardDao�� MemberDao�� ������ �̸��� upBoardList, memberList �����Ǿ� �־�� �ҷ��� �� �ִ�.
		PageListInter pageListInter = applicationContext.getBean(myDao, PageListInter.class);
		
		// target�� �޼��带 ȣ��
		String url = null;
		try {
			url = (String) pjp.proceed();
			// total �� ��������
			totalRecord = (int) m.asMap().get("totalRecord");
			System.out.println("totalRecord : "+totalRecord);
			totalPage = (int) Math.ceil(totalRecord / (double) numPerPage);
	        totalBlock = (int) Math.ceil((double) totalPage / pagePerBlock);
			
			// ------------- ���� ������ �ڵ� �ٿ� �ֱ�
			String s_Page = cPage;
			if (s_Page != null) {
	            nowPage = Integer.parseInt(s_Page);
	        }
	        beginPerPage = (nowPage - 1) * numPerPage + 1;
	        endPerPage = (beginPerPage - 1) + numPerPage;
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
