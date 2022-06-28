package ex1;

public class TVUser {
//삼성, LG TV를 시청하는 유저 클래스를 만들고
	public static void main(String[] args) {
		
	SamsungTV tv = new SamsungTV();
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		//이후 lg로 변경하려면!?
		//메서드이름이 다 달라서 결합도가 너무 높다
		LgTV tv2 = new LgTV();
		//결합도를 낮추는 방법
		//interface를 이용하여 메서드명을 맞춰주자
//		TV tv1= new SamsungTV();
		TV tv1= new LgTV();
		tv1.powerOn();
		tv1.volumeUp();
		tv1.volumeDown();
		tv1.powerOff();
	}

}
