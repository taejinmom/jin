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
 * Servlet implementation class Ex1_AutoServlet
 */
@WebServlet("/Ex1_ResourceServlet")
public class Ex1_ResourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ApplicationContext c;
	@Override
		public void init() throws ServletException {
		c = new GenericXmlApplicationContext("ex2/resource.xml");
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Ex1_Resource ref = c.getBean("ex2",Ex1_Resource.class);
	request.setAttribute("msg", ref.getRes().resource1());
	RequestDispatcher rd = request.getRequestDispatcher("ex1.jsp");
	rd.forward(request, response);
	}

	

}
