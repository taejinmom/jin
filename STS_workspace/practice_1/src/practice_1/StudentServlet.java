package practice_1;

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
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	
		private static final long serialVersionUID = 1L;
	    private ApplicationContext c;
		@Override
			public void init() throws ServletException {
			c = new GenericXmlApplicationContext("practice_1/ex.xml");
		}
	   
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student ref = c.getBean("student",Student.class);
		request.setAttribute("msg", ref.Msg());
		RequestDispatcher rd = request.getRequestDispatcher("ex1.jsp");
		rd.forward(request, response);
		}

		

	}



