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
		DaoInter dao = ctx.getBean("dao", DaoInter.class);
		MyPublic mp = ctx.getBean("pub",MyPublic.class );
//		dao.second();
		
//		dao.third();
		dao.todayMethod();
//		mp.todayMethod();
		MyModel model = ctx.getBean("model", MyModel.class);
//		model.first(1);
	}

}
