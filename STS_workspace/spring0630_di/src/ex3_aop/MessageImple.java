package ex3_aop;

import java.util.LinkedList;

//������ AOP ����� �����鼭 ���� �ľ�!! 
public class MessageImple implements Message {
	private String message;
	
	
	public void setMessage(String message) {
		this.message = message;
	}
	public MessageImple() {
		message="�ȳ��ϼ��� ù AOP�Դϴ�";
	}
	@Override
	public void print() {
		LinkedList<String> ar2 = new LinkedList<String>();
		for(int i=0;i<10000000; i++) {
			if(i % 5 == 0) {
				ar2.add("kosmo");
				
			}else {
				ar2.add("Python");
			}
		}
		System.out.println("LinkedList�� �� size :" + ar2.size());
		for(String e : ar2) {
			String msg = e;
			if(e.equals("kosmo")) {
				System.out.println(msg);
			}else {
				System.out.println(msg);
			}
		}
	}

	@Override
	public String printTest() {
		for(int i =0;i<10;i++) {
			try {
				Thread.sleep(1000);
				System.out.println("printTest("+(i+1)+")");
			} catch (Exception e) {
			e.printStackTrace();
			}
		}
		return "���";
	}

	@Override
	public String message() {
		
		return "message() : "+message;
	}

	@Override
	public void test() {
		System.out.println("Test~~~~~~~~~!");
	}
	@Override
	public void test2() {
		System.out.println("test2~~~~~~!");
	}
	@Override
	public void test3(String msg) {
		System.out.println("�����Ͻ� �ٽɷ���!");
	}
	
}
