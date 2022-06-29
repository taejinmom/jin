package ex2;

public class ResourceB {
	private String uname;
	
	
	public ResourceB() {
	System.out.println("resource가 생성됨");
	}
	//사용자의 이름을 외부에서 이 메서드가 호출 할 때 값으 ㄹ인자로 전달 받아서
	//멤버필드에 저장하는메서드
    
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUname() {
		return uname + "님의 정보입니다.";
	}
	public int res() {
		return 100000;
	}
}
