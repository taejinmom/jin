package ex1;

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
 * Servlet implementation class Ex1_AutoServlet
 */
@WebServlet("/Ex1_AutoServlet")
public class Ex1_AutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ApplicationContext c;
	@Override
		public void init() throws ServletException {
		c = new GenericXmlApplicationContext("ex1/ex1.xml");
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Ex1_AutoWired ref = c.getBean("auto1",Ex1_AutoWired.class);
	request.setAttribute("msg", ref.getMessage());
	RequestDispatcher rd = request.getRequestDispatcher("ex1.jsp");
	rd.forward(request, response);
	}

	

}
