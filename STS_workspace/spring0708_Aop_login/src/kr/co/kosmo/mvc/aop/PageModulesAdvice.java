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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kosmo.mvc.dao.PageListInter;
import kr.co.kosmo.mvc.vo.SuperDTO;

@Component
@Aspect
public class PageModulesAdvice {
	@Autowired
	private ApplicationContext aplliApplicationContext;
	
	private int nowPage = 1;// 현재 페이지 값
    private int nowBlock = 1;// 현재 블럭
    private int totalRecord = 0;// 총 게시물 수
    private int numPerPage = 10;// 한 페이지당 보여질 게시물 수
    private int pagePerBlock = 5;// 한 블럭당 보여질 페이지 수
    private int totalPage = 0;// 전체 페이지 수 => totalRecord/numPerPage
    private int totalBlock = 0;// 전체 블럭 수
    private int beginPerPage = 0;// 각 페이지별 시작 게시물의 index값
    private int endPerPage = 0;// 각 페이지별 마지막 게시물의 index값
    
    @Around("execution(* kr.co.kosmo.mvc.controller.*.*Controller.*List(..))")
    public String pageModule(ProceedingJoinPoint jp) {
    	String myDao = jp.getSignature().getName();
    	System.out.println("myDao = " + myDao);
    	//------------선행 처리영역
        Object[] args = jp.getArgs();
        // 첫 번째 인자 : Model, 두 번째 인자 : 페이지값 String cPage
        Model m = (Model) args[0];
        String cPage = (String) args[1];
        PageListInter pageListInter =  aplliApplicationContext.getBean(myDao,PageListInter.class);
        
        // target의 메서드를 호출
        String url = null;
        try {
            url = (String) jp.proceed();
            // total 값 가져오기
            totalRecord = (int) m.asMap().get("totalRecord");
            System.out.println("totalRecord : "+totalRecord);
            totalPage = (int) Math.ceil(totalRecord / (double) numPerPage);
            totalBlock = (int) Math.ceil((double) totalPage / pagePerBlock);
            
            // ------------- 기존 페이지 코드 붙여 넣기
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
//    @Around("execution(* kr.co.kosmo.mvc.controller.*.*Controller.*detail(..))")
//    public String a(ProceedingJoinPoint jp) {
//    	String res = jp.getSignature().getName();
//    	System.out.println("myDao = " + res);
//    	try {
//			jp.proceed();
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	return res;
//    }
}

