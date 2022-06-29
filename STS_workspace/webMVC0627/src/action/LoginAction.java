package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import dao.MemberDao;
import dto.MemerDTO;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String sub = request.getParameter("sub");
		if(sub.equals("form")) {
			return new ActionForward("login/loginForm.jsp", false);
		}else if(sub.equals("logout")) {
			// loginout일 경우는 기존의 세션에서 id 세션값만 삭제 한다.
			
			HttpSession session = request.getSession(false);
			// session.invalidate(); 모든 세션 삭제
			session.removeAttribute("id");
			return new ActionForward("main.kosmo?cmd=index", true);
		}else {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			MemerDTO dto = new MemerDTO();
			dto.setId(id);
			dto.setPwd(pwd);
			int cnt = MemberDao.getDao().login(dto);
			// 
			if(cnt > 0) { //인증됨
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
			}else {
				PrintWriter out = response.getWriter();
				out.println("Error");
				out.println("<a href='main.kosmo?cmd=index'>home</a>");
				out.close();
			}
			return new ActionForward("main.kosmo?cmd=index", true);
		}
	}

}
