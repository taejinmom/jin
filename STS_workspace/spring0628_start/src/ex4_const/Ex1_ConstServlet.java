package ex4_const;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Servlet implementation class Ex1_ConstServlet
 */
@WebServlet("/Ex1_ConstServlet")
public class Ex1_ConstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext c;
	
	@Override
	public void init() throws ServletException {
		c = new GenericXmlApplicationContext("ex4_const/ex4_const.xml");
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
