package ex3_spring;

public class Ex1_HelloBean {

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String printMessage() {
		
		String name = "��浿";
		return name + "�� " + msg;
	}
}
