package ex2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Servlet implementation class TestA
 */
@WebServlet("/TestA")
public class TestA extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext c;
       
  

		@Override
	public void init() throws ServletException {
		c = new GenericXmlApplicationContext("ex2/ex2.xml");
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyTestA testA= c.getBean("testA",MyTestA.class);
		request.setAttribute("msg", testA.printUseb());
		RequestDispatcher rd = request.getRequestDispatcher("today.jsp");
		rd.forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
//	private void springDemo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		MyTestA testA= c.getBean("testA",MyTestA.class);
//		request.setAttribute("msg", testA.printUseb());
//		RequestDispatcher rd = request.getRequestDispatcher("today.jsp");
//		rd.forward(request, response);
//	}
//	private void nonspring(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String res = new MyAssembler().getPrintv();
//		request.setAttribute("msg", res);
//		RequestDispatcher rd = request.getRequestDispatcher("today.jsp");
//		rd.forward(request, response);
//	}

}
