package exam;

import org.springframework.beans.factory.annotation.Autowired;

public class LoginTest {
	@Autowired
	private BizService ref;
	
	public void print() {
		System.out.println("�����Ϸ�");
		ref.securityMethod();
	}
}
