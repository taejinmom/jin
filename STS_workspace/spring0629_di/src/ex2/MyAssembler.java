package ex2;

public class MyAssembler {
	private String printv;
	public MyAssembler() {
		MyTestA refA = new MyTestA();
		ResourceB refB = new ResourceB();
		refB.setUname("±è±æµ¿");
		refA.setB(refB);
		printv = refA.printUseb();
	}
	public String getPrintv() {
		return printv;
	}
	
}
