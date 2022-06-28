package ex3;

public class TVUser {
//삼성, LG TV를 시청하는 유저 클래스를 만들고
	public static void main(String[] args) {
		
	BeanFactory factory = new BeanFactory();
	TV tv = factory.getBean("lg");
	tv.powerOn();
	tv.volumeUp();
	tv.volumeDown();
	tv.powerOff();
	}

}
