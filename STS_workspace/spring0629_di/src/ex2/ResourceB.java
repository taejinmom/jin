package ex2;

public class ResourceB {
	private String uname;
	
	
	public ResourceB() {
	System.out.println("resource�� ������");
	}
	//������� �̸��� �ܺο��� �� �޼��尡 ȣ�� �� �� ���� �����ڷ� ���� �޾Ƽ�
	//����ʵ忡 �����ϴ¸޼���
    
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUname() {
		return uname + "���� �����Դϴ�.";
	}
	public int res() {
		return 100000;
	}
}
