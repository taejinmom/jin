package ex3;

public class TVUser {
//�Ｚ, LG TV�� ��û�ϴ� ���� Ŭ������ �����
	public static void main(String[] args) {
		
	BeanFactory factory = new BeanFactory();
	TV tv = factory.getBean("lg");
	tv.powerOn();
	tv.volumeUp();
	tv.volumeDown();
	tv.powerOff();
	}

}
