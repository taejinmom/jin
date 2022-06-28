package ex4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * 다른나라 요리가 추가된다면 현재 코드가 변경에 유연하도록 고치고 ex4 -> ex5 이것을 스프링으로도 변경 ex5 ->
 * ex5_spring
 */
@WebServlet("/HasaDemoServlet")
public class HasaDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderCook ref = null;
		String cmd = request.getParameter("cmd");
		String resultOrd = "";
		ApplicationContext c = new GenericXmlApplicationContext("ex4/ex4.xml");
		try {
			ref = c.getBean(cmd, OrderCook.class);
			resultOrd = ref.orderCook();

		} catch (Exception e) {
			resultOrd = "모름!";
		}
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter pw = response.getWriter();
		pw.println("resultOrd: " + resultOrd);
	}

}
