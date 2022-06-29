package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import dao.MemberDao;

public class MemberIdCheck implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		int cnt = MemberDao.getDao().idcheck(id);
		request.setAttribute("cnt", cnt);
		return new ActionForward("member/idchk.jsp", false);
	}

}
