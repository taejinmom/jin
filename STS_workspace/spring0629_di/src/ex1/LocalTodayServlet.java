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
 * Servlet implementation class LocalTodayServlet
 */
@WebServlet("/LocalTodayServlet")
public class LocalTodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext c ;
	@Override
	public void init() throws ServletException {
		//today.xml�� ������ Bean���� �����������̳ʰ� �� ����� �о���϶� �̱��� �������͸��� ����صΰ� �����Ѵ�.

		c = new GenericXmlApplicationContext("ex1/today.xml");	
	}

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		�̱��� ����
//		ApplicationContext c = new GenericXmlApplicationContext("ex1/today.xml");	
		//bean �ּ� �޾ƿ���
		LocalToday today = c.getBean("today",LocalToday.class);
		LocalToday today1 = c.getBean("today",LocalToday.class);
//		today = c.getBean("today",LocalToday.class);
//		//forward�� ����
		//el ���
		request.setAttribute("msg", today.printLocalToday());
		
		//xml���� �ش���� init"true"�� �� ��� getBean()�� �ϴ� ���ÿ� ��ü ������ �̷�� ����.
		LazyBean ref = c.getBean("lazy",LazyBean.class);
		LazyBean ref1 = c.getBean("lazy",LazyBean.class);
		System.out.println("�̱��� ��1 : " +(today == today1));
		System.out.println("�̱��� ��2 : " +(ref == ref1));
		request.setAttribute("msg", today.printLocalToday());
		RequestDispatcher rd = request.getRequestDispatcher("today.jsp");
		rd.forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
