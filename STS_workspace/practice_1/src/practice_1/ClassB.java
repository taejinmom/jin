package practice_1;

import org.springframework.beans.factory.annotation.Autowired;

public class ClassB {
	@Autowired
	private Student res;
	
	public String B() {
		return res.Msg();
	}
}
