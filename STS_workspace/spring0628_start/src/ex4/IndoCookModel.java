package ex4;

public class IndoCookModel implements OrderCook{
	private String name;
	
	
	public void setName(String name) {
		this.name = name;
	}


	public String orderCook(){
		return name+ "�� �ε� �丮�Դϴ�";
	}
}
