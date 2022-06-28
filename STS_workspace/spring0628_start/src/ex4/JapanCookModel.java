package ex4;

public class JapanCookModel implements OrderCook {
	private String name;

	@Override
	public String orderCook(){
		return name+ "은 일본 요리입니다";
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
}
