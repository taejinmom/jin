package ex2;

import org.springframework.beans.factory.annotation.Autowired;

public class Ex1_Resource {
	@Autowired
	private Ex1_MyResource res;
	
	public Ex1_MyResource getRes() {
		return res;
	}

//	public void setRes(Ex1_MyResource res) {
//		this.res = res;
//	}
	
}
