package ex2;
//A��� Ŭ������ BŬ������ �����ؼ� �� ���� �ٸ� ���·� ����
//��) A -> Model , B - Dao
//�������� ���ؼ� DI(������ ����)
//POJO�������
public class MyTestA {
	private ResourceB b;
	
	public MyTestA() {
		//has a ����,���յ��� �ʹ� ����
		//b = new ResourceB();
	System.out.println("MyTestA ����");
	}
	public void setB(ResourceB b) {
		this.b=b;
	}
	public String printUseb() {
		StringBuilder sb = new StringBuilder();
		sb.append("B���� ��ȯ ���� ��:"+(b.res() * 2)).append("<br>");
		sb.append("����� �̸� :").append(b.getUname());
		return sb.toString();
	}


}
