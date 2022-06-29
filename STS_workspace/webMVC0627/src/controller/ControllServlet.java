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
	    //---------�и��� �ڵ� ���� S
		ActionFactory factory = ActionFactory.getFactory();
		action = factory.getAction(cmd);
		//---------�и��� �ڵ� ���� E
		ActionForward af = action.execute(request, response);
		// �̵� ��İ� URL����
		if(af.isMethod()) {
			response.sendRedirect(af.getUrl());
		}else {
			//forward 
			String path = "/WEB-INF/views";
			RequestDispatcher rd = request.getRequestDispatcher(path+"/"+af.getUrl());
			rd.forward(request, response);
		}
		}else {
			// ���� �ڵ� 
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.print("����");
			out.close();
		}
	}
}






