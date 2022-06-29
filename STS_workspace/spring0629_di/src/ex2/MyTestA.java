package ex2;
//A라는 클래스는 B클래스를 참조해서 그 값을 다른 형태로 가공
//예) A -> Model , B - Dao
//스프링에 의해서 DI(의존성 주입)
//POJO기반으로
public class MyTestA {
	private ResourceB b;
	
	public MyTestA() {
		//has a 관계,결합도가 너무 높다
		//b = new ResourceB();
	System.out.println("MyTestA 생성");
	}
	public void setB(ResourceB b) {
		this.b=b;
	}
	public String printUseb() {
		StringBuilder sb = new StringBuilder();
		sb.append("B에서 반환 받은 값:"+(b.res() * 2)).append("<br>");
		sb.append("사용자 이름 :").append(b.getUname());
		return sb.toString();
	}


}
