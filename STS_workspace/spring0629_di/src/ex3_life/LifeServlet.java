package ex3_life;

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
 * Servlet implementation class LifeServlet
 */
@WebServlet("/LifeServlet")
public class LifeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ApplicationContext c; 
    
	@Override
	public void init() throws ServletException {
		//1. �����������̳ʿ� ���ؼ� ��ü�� ����
		//1-1. �����ڷ� injection�� ����ߴٸ� �̶� �ش� ���� �ʱ�ȭ ��
		//2. setter����
		//3. init() �ʱ�ȭ
		//4. getBean() �ش� ��ü�� �ּҰ��� ����
		//5. method1() ȣ�� �� �� ȣ���� ��
		//6. ������ �����̳ʰ� ���� : destroy() ȣ��
		c= new GenericXmlApplicationContext("ex3_life/life.xml");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Lifeinter inter = c.getBean("life",Lifeinter.class);
		String name = inter.method1();
		request.setAttribute("msg", name);
		RequestDispatcher rd = request.getRequestDispatcher("today.jsp");
		rd.forward(request, response);
	}

	

}
