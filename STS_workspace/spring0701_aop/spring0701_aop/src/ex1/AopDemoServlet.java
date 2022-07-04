package ex1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


@WebServlet("/AopDemoServlet")
public class AopDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext ctx;
	@Override
	public void init() throws ServletException {
		ctx = new GenericXmlApplicationContext("ex1/ex1_aop.xml");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoInter dao = ctx.getBean("dao",DaoInter.class);
		 // dao.first();
		//dao.second();
		dao.third();
		MyModel model = ctx.getBean("model",MyModel.class);
		//for(int i=2; i<1000; i++) {
		 //model.first(2);
		//}
	}

}
