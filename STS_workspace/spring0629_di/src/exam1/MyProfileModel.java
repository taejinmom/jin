package exam1;

public class MyProfileModel {
	private MyProfile pro;

	public void setPro(MyProfile pro) {
		this.pro = pro;
		System.out.println("����");
	}
	
	public MyProfile getPro() {
		return pro;
	}

	//����ϴ� �޼���
//	public void useProfile() {
//		StringBuffer sb = new StringBuffer();
//		sb.append("����� ������ ���� :");
//		sb.append(pro.profile());
//		
//		System.out.println(sb);
//	}
	public String useProfile() {
		StringBuffer sb = new StringBuffer();
		sb.append("����� ������ ���� :");
		sb.append(pro.profile());
		System.out.println(sb.toString());
		return sb.toString();
	}
	

}
