package ex3_spring;

public class SamsungTV implements TV{
	private String tvname;

	public void setTvname(String tvname) {
		this.tvname = tvname;
	}
	public void powerOn() {
		System.out.println(tvname +"SamsungTV---전원 키기");
	}
	public void powerOff() {
		System.out.println(tvname +"SamsungTV---전원 끄기");
	}
	public void volumeUp() {
		System.out.println(tvname +"SamsungTV---볼륨 올리기");
	}
	public void volumeDown() {
		System.out.println(tvname +"SamsungTV---볼륨 내리기");
	}
	@Override
	public void run() {
		powerOn();
		volumeUp();
		volumeDown();
		powerOff();
		
	}

}
