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
		//today.xml에 선언한 Bean들은 스프링컨테이너가 이 빈들을 읽어들일때 싱글톤 레지스터리에 등록해두고 생성한다.

		c = new GenericXmlApplicationContext("ex1/today.xml");	
	}

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		싱글톤 생성
//		ApplicationContext c = new GenericXmlApplicationContext("ex1/today.xml");	
		//bean 주소 받아오기
		LocalToday today = c.getBean("today",LocalToday.class);
		LocalToday today1 = c.getBean("today",LocalToday.class);
//		today = c.getBean("today",LocalToday.class);
//		//forward로 전송
		//el 방식
		request.setAttribute("msg", today.printLocalToday());
		
		//xml에서 해당빈을 init"true"로 줄 경우 getBean()을 하는 동시에 객체 생성이 이루어 진다.
		LazyBean ref = c.getBean("lazy",LazyBean.class);
		LazyBean ref1 = c.getBean("lazy",LazyBean.class);
		System.out.println("싱글톤 비교1 : " +(today == today1));
		System.out.println("싱글톤 비교2 : " +(ref == ref1));
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
