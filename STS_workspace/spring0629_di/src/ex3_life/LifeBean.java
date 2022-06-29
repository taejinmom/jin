package ex3_life;
/**
 *������ ������ ����Ŭ�� was�� servlet ��ü�� ������ �� �⺻ �����ڸ� ȣ���Ѵ�.
 *�����ڷ� servlet ��ü�� �⤱���ʵ带 ���Ԥ��� �ʱ�ȭ �ϱ� ���ؼ��� this(aa,10) ���� ����ؾ� �ϴµ�
 *��, ��� ���� �ʱ�ȭ �� �� ������ �ִ�.
 *�׷��� init()�޼��带 ���ؼ� ������() - > init() ȣ���� �� �ְ� , context -param, init-param� ���⼭ ȣ����
 *
 * ������ �����̳� ���� ������ ���� ���Ͽ� ��ϵ� Ŭ�������� ��ü�� ���� �� �� �⺻�����ڸ� ȣ���Ѵ�.(���� ����)
 * ��ü ���� �Ŀ� ��� ���� �ʱ�ȭ, DI�� ������ �� �����ϸ鼭 �����Ͻ� ������ �����ؾ��ϴ°��� �����̴�
 * init() : �ʱ�ȭ, destroy() : ����
 * Bean -> init-method, destroy-method ȣ��!~
 */
public class LifeBean implements Lifeinter {
	private String name;
	
	public LifeBean() {}
	public LifeBean(String name) {
		this.name = name;
		System.out.println("������ ȣ��====>" + name);
	}
	
	public void setName(String name) {
		this.name = name;
		System.out.println("setter ȣ��====>" + name);
	}

	@Override
	public void init() {
		this.name="��";
		System.out.println("init ȣ��====>" + name);
	}

	@Override
	public void destroy() {
		System.out.println("destroy ====>" + name);
		
	}
	@Override
	public String method1() {
		System.out.println("name : " + name);
		return "name : " + name;
	}

}
