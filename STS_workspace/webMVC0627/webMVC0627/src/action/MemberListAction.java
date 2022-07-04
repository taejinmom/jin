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
	 private  int nowPage = 1;// ���� ������ ��
	 private  int nowBlock = 1;// ���� ��
	 private  int totalRecord = 0;// �� �Խù� ��   
	 private  int numPerPage = 10;// �� �������� ������ �Խù� ��
	 private  int pagePerBlock = 5;// �� ���� ������ ������ ��
	 private  int totalPage = 0;// ��ü ������ �� => totalRecord/numPerPage
	 private  int totalBlock = 0;// ��ü �� ��   
	 private  int beginPerPage = 0;// �� �������� ���� �Խù��� index��
	 private  int endPerPage = 0;// �� �������� ������ �Խù��� index��   

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// �� �Խù� �� ��������
		   totalRecord = MemberDao.getDao().getCnt();
		   //totalPage = totalRecord/numPerPage;
		   // Ǯ�� : ������ �߻��Ѱ��� double Ȯ�� 9.2 => �ø�ó��
		   // double totalPage2 = totalRecord/(double)numPerPage;
		   totalPage = (int) Math.ceil(totalRecord/(double)numPerPage);
		   totalBlock = (int) Math.ceil((double) totalPage/pagePerBlock);
		   //���� �������� ��û�� �� �Ķ���ͷ� ���� ���������� �޴´�. 1 ~~~~~~~ n
		   String s_page = request.getParameter("cPage");
		   if(s_page != null){
				nowPage = Integer.parseInt(s_page);
		   }
		   // begin ~ end  ���ϴ� ����
		   beginPerPage = (nowPage - 1) * numPerPage + 1;
		   endPerPage = (beginPerPage-1) + numPerPage;
		   //----------------------------------��������� �ݵ�� �׽�Ʈ �غ� �� 
			// �׽�Ʈ
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
