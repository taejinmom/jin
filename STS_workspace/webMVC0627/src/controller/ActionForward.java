package controller;
//Controller가 모델의 메서드를 호출한 후 모델이 반환 해야할 객체
public class ActionForward {
	private String url;// 모델이 실행한 후 반환하는 ViewName
	private boolean method; // 모델이 실행 후 이동할 이동 방식
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
