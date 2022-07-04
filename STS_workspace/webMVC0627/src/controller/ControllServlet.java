package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
@WebServlet("*.kosmo")
public class ControllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		//pro.kosmo?cmd=hello
		//pro.kosmo?cmd=movielist
		String cmd = request.getParameter("cmd");
		Action action = null;
		if(cmd !=null) {
	    //---------분리한 코드 영역 S
		ActionFactory factory = ActionFactory.getFactory();
		action = factory.getAction(cmd);
		//---------분리한 코드 영역 E
		ActionForward af = action.execute(request, response);
		// 이동 방식과 URL결정
		if(af.isMethod()) {
			response.sendRedirect(af.getUrl());
		}else {
			//forward 
			String path = "/WEB-INF/views";
			RequestDispatcher rd = request.getRequestDispatcher(path+"/"+af.getUrl());
			rd.forward(request, response);
		}
		}else {
			// 오류 코드 
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.print("오류");
			out.close();
		}
	}
}






