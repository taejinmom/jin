package ex2;

public class LgTV implements TV {
	
	public void powerOn() {
		System.out.println("LgTV---���� Ű��");
	}
	public void powerOff() {
		System.out.println("LgTV---���� ����");
	}
	public void volumeUp() {
		System.out.println("LgTV---���� �ø���");
	}
	public void volumeDown() {
		System.out.println("LgTV---���� ������");
	}
}

/*
 * ���յ�(coupling)�� ���� ���α׷�
 * -���յ��� �ϳ��� Ŭ������ �ٸ� Ŭ������ �󸶳� ����Ǿ��ִ�����
 * ��Ÿ���� ǥ���̴�.
 * -���յ��� ���� ���α׷��� ��������(����)�� ��ư� �׽�Ʈ�ϱ⿡�� ������� ����
 * */

