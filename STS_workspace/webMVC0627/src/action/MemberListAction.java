package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import dao.MemberDao;
import dto.MemerDTO;

public class MemberListAction implements Action{
	 private  int nowPage = 1;// 현재 페이지 값
	 private  int nowBlock = 1;// 현재 블럭
	 private  int totalRecord = 0;// 총 게시물 수   
	 private  int numPerPage = 10;// 한 페이지당 보여질 게시물 수
	 private  int pagePerBlock = 5;// 한 블럭당 보여질 페이지 수
	 private  int totalPage = 0;// 전체 페이지 수 => totalRecord/numPerPage
	 private  int totalBlock = 0;// 전체 블럭 수   
	 private  int beginPerPage = 0;// 각 페이지별 시작 게시물의 index값
	 private  int endPerPage = 0;// 각 페이지별 마지막 게시물의 index값   

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 총 게시물 수 가져오기
		   totalRecord = MemberDao.getDao().getCnt();
		   //totalPage = totalRecord/numPerPage;
		   // 풀이 : 나머지 발생한것을 double 확인 9.2 => 올림처리
		   // double totalPage2 = totalRecord/(double)numPerPage;
		   totalPage = (int) Math.ceil(totalRecord/(double)numPerPage);
		   totalBlock = (int) Math.ceil((double) totalPage/pagePerBlock);
		   //현재 페이지를 요청할 때 파라미터로 현재 페이지값을 받는다. 1 ~~~~~~~ n
		   String s_page = request.getParameter("cPage");
		   if(s_page != null){
				nowPage = Integer.parseInt(s_page);
		   }
		   // begin ~ end  구하는 공식
		   beginPerPage = (nowPage - 1) * numPerPage + 1;
		   endPerPage = (beginPerPage-1) + numPerPage;
		   //----------------------------------여기까지는 반드시 테스트 해볼 것 
			// 테스트
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("begin", beginPerPage);
			map.put("end", endPerPage);
			List<MemerDTO> list = MemberDao.getDao().getList(map);
			request.setAttribute("list", list);
			
			int startPage = (int)((nowPage-1)/pagePerBlock)*pagePerBlock+1;
			int endPage = startPage + pagePerBlock - 1;
			if(endPage > totalPage){
				endPage = totalPage;
		    }
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("pagePerBlock", pagePerBlock);
			request.setAttribute("totalPage",totalPage);
			
			
		return new ActionForward("member/memberList.jsp", false);
	}
}
