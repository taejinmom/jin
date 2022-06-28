package ex3_spring;

public class LgTV implements TV {
	private String tvname;

	public void setTvname(String tvname) {
		this.tvname = tvname;
	}
	public void powerOn() {
		System.out.println(tvname +"LgTV---���� Ű��");
	}
	public void powerOff() {
		System.out.println(tvname +"LgTV---���� ����");
	}
	public void volumeUp() {
		System.out.println(tvname +"LgTV---���� �ø���");
	}
	public void volumeDown() {
		System.out.println(tvname +"LgTV---���� ������");
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
 * ���յ�(coupling)�� ���� ���α׷�
 * -���յ��� �ϳ��� Ŭ������ �ٸ� Ŭ������ �󸶳� ����Ǿ��ִ�����
 * ��Ÿ���� ǥ���̴�.
 * -���յ��� ���� ���α׷��� ��������(����)�� ��ư� �׽�Ʈ�ϱ⿡�� ������� ����
 * */

