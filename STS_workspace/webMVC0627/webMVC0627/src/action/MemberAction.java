package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import dao.MemberDao;
import dto.MemerDTO;

public class MemberAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		String sub = request.getParameter("sub");
		if(sub.equals("form")) {
			return memberForm(request);
		}else {
			MemerDTO dto = new MemerDTO();
			dto.setId(request.getParameter("id"));
			dto.setPwd(request.getParameter("pwd"));
			dto.setName(request.getParameter("name"));
			dto.setAge(Integer.parseInt(request.getParameter("age")));
			dto.setGender(request.getParameter("gender"));
			MemberDao.getDao().addMember(dto);
			//redirect
			return new ActionForward("main.kosmo?cmd=index", true);
		}
		
	}
	public ActionForward memberForm(HttpServletRequest request) {
		return new ActionForward("member/memberForm.jsp", false);
	}
}
