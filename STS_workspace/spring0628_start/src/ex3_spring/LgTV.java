package ex3_spring;

public class LgTV implements TV {
	private String tvname;

	public void setTvname(String tvname) {
		this.tvname = tvname;
	}
	public void powerOn() {
		System.out.println(tvname +"LgTV---전원 키기");
	}
	public void powerOff() {
		System.out.println(tvname +"LgTV---전원 끄기");
	}
	public void volumeUp() {
		System.out.println(tvname +"LgTV---볼륨 올리기");
	}
	public void volumeDown() {
		System.out.println(tvname +"LgTV---볼륨 내리기");
	}
	@Override
	public void run() {
		powerOn();
		volumeUp();
		volumeDown();
		powerOff();
		
	}
	
}

/*
 * 결합도(coupling)가 높은 프로그램
 * -결합도란 하나의 클래스가 다른 클래스와 얼마나 연결되어있는지를
 * 나타내는 표현이다.
 * -결합도가 높은 프로그램은 유지보수(관리)가 어렵고 테스트하기에도 어려움이 많다
 * */

