package dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dao.MemberDao;

public class PageDTO {
	   int nowPage = 1;// ���� ������ ��
	   int nowBlock = 1;// ���� ��
	   int totalRecord = 0;// �� �Խù� ��   
	   int numPerPage = 10;// �� �������� ������ �Խù� ��
	   int pagePerBlock = 5;// �� ���� ������ ������ ��
	   int totalPage = 0;// ��ü ������ �� => totalRecord/numPerPage
	   int totalBlock = 0;// ��ü �� ��   
	   int beginPerPage = 0;// �� �������� ���� �Խù��� index��
	   int endPerPage = 0;// �� �������� ������ �Խù��� index��   
	   
	   public void pageInfo(HttpServletRequest request) {
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
	   }
}
