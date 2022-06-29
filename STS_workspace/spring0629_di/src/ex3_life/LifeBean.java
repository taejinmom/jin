package ex3_life;
/**
 *서블릿의 라이프 싸이클은 was가 servlet 객체를 생성할 때 기본 생성자를 호출한다.
 *생성자로 servlet 객체의 멤ㅁ버필드를 주입ㅎ서 초기화 하기 위해서는 this(aa,10) 등을 사용해야 하는데
 *즉, 멤버 변수 초기화 할 때 문제가 있다.
 *그래서 init()메서드를 통해서 생성자() - > init() 호출할 수 있고 , context -param, init-param등도 여기서 호출함
 *
 * 스프링 컨테이너 역시 스프링 설정 파일에 등록된 클래스들을 객체로 생성 할 때 기본생성자를 호출한다.(변경 가능)
 * 객체 생성 후에 멤버 변수 초기화, DI의 순서를 잘 이해하면서 비지니스 로직을 구성해야하는것이 목적이다
 * init() : 초기화, destroy() : 해제
 * Bean -> init-method, destroy-method 호출!~
 */
public class LifeBean implements Lifeinter {
	private String name;
	
	public LifeBean() {}
	public LifeBean(String name) {
		this.name = name;
		System.out.println("생성자 호출====>" + name);
	}
	
	public void setName(String name) {
		this.name = name;
		System.out.println("setter 호출====>" + name);
	}

	@Override
	public void init() {
		this.name="모";
		System.out.println("init 호출====>" + name);
	}

	@Override
	public void destroy() {
		System.out.println("destroy ====>" + name);
		
	}
	@Override
	public String method1() {
		System.out.println("name : " + name);
		return "name : " + name;
	}

}
