package ex3_spring;

public class SamsungTV implements TV{
	private String tvname;

	public void setTvname(String tvname) {
		this.tvname = tvname;
	}
	public void powerOn() {
		System.out.println(tvname +"SamsungTV---���� Ű��");
	}
	public void powerOff() {
		System.out.println(tvname +"SamsungTV---���� ����");
	}
	public void volumeUp() {
		System.out.println(tvname +"SamsungTV---���� �ø���");
	}
	public void volumeDown() {
		System.out.println(tvname +"SamsungTV---���� ������");
	}
	@Override
	public void run() {
		powerOn();
		volumeUp();
		volumeDown();
		powerOff();
		
	}

}
