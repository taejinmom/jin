package ex1;

public class BizServiceImple implements BizService{
	
	@Override
	public void bizMethod1() {
		System.out.println("����!");
	}

	@Override
	public String second() {
		StringBuffer sb = new StringBuffer();
		sb.append("--------------------").append("\n");
		sb.append("��浿").append("\n");
		sb.append("--------------------").append("\n");
		return sb.toString();
	}

	@Override
	public void first() {
		// TODO Auto-generated method stub
		for(int i=0; i<10;i++) {
			try {
				Thread.sleep(1000);
				System.out.print(i+"\t");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
