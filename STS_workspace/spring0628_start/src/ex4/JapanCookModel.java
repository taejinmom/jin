package ex4;

public class JapanCookModel implements OrderCook {
	private String name;

	@Override
	public String orderCook(){
		return name+ "�� �Ϻ� �丮�Դϴ�";
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
}
