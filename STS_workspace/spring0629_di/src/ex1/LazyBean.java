package ex1;

public class LazyBean {
	private String msg;
	
	public LazyBean() {
		System.out.println("LazyBean ������ ȣ��");
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String printMsg() {
		return msg;
	}
}
