package ex1;

public class BizServiceImple implements BizService{
	
	@Override
	public void bizMethod1() {
		System.out.println("¼öÇà!");
	}

	@Override
	public String second() {
		StringBuffer sb = new StringBuffer();
		sb.append("--------------------").append("\n");
		sb.append("±è±æµ¿").append("\n");
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
