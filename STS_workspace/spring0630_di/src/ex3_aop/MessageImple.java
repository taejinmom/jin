package ex3_aop;

import java.util.LinkedList;

//순수한 AOP 기술을 만들어보면서 개념 파악!! 
public class MessageImple implements Message {
	private String message;
	
	
	public void setMessage(String message) {
		this.message = message;
	}
	public MessageImple() {
		message="안녕하세요 첫 AOP입니다";
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
		System.out.println("LinkedList에 들어간 size :" + ar2.size());
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
		return "헬로";
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
		System.out.println("비지니스 핵심로직!");
	}
	
}
