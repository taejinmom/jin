package ex1;

public class TVUser {
//�Ｚ, LG TV�� ��û�ϴ� ���� Ŭ������ �����
	public static void main(String[] args) {
		
	SamsungTV tv = new SamsungTV();
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		//���� lg�� �����Ϸ���!?
		//�޼����̸��� �� �޶� ���յ��� �ʹ� ����
		LgTV tv2 = new LgTV();
		//���յ��� ���ߴ� ���
		//interface�� �̿��Ͽ� �޼������ ��������
//		TV tv1= new SamsungTV();
		TV tv1= new LgTV();
		tv1.powerOn();
		tv1.volumeUp();
		tv1.volumeDown();
		tv1.powerOff();
	}

}
