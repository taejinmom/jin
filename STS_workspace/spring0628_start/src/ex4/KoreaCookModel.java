package ex4;

public class KoreaCookModel implements OrderCook {
private String name;
	
	
	public void setName(String name) {
		this.name = name;
	}
	public String orderCook(){
		return name + "�� �ѱ� �丮�Դϴ�";
	}
}
