package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import dao.MemberDao;
import dto.MemerDTO;

public class MyPage implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		MemerDTO dto = MemberDao.getDao().myPage(id);
		request.setAttribute("dto", dto);
		return new ActionForward("member/mypage.jsp", false);
	}

	
}
