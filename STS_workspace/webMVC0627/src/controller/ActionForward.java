package controller;
//Controller�� ���� �޼��带 ȣ���� �� ���� ��ȯ �ؾ��� ��ü
public class ActionForward {
	private String url;// ���� ������ �� ��ȯ�ϴ� ViewName
	private boolean method; // ���� ���� �� �̵��� �̵� ���
	public ActionForward() {
	}
	public ActionForward(String url, boolean method) {
		this.url = url;
		this.method = method;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isMethod() {
		return method;
	}
	public void setMethod(boolean method) {
		this.method = method;
	}
	
}
