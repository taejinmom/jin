package exam;

import org.springframework.beans.factory.annotation.Autowired;

public class LoginTest {
	@Autowired
	private BizService ref;
	
	public void print() {
		System.out.println("인증완료");
		ref.securityMethod();
	}
}
