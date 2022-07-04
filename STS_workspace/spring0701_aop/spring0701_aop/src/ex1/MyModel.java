package ex1;

import org.springframework.beans.factory.annotation.Autowired;

public class MyModel {
	@Autowired
	private DaoInter dao;
	
	public void first(int code) {
		
		dao.firstStatementTest(code);
		
	}
	
}
