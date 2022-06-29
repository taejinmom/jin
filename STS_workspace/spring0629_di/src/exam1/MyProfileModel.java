package exam1;

public class MyProfileModel {
	private MyProfile pro;

	public void setPro(MyProfile pro) {
		this.pro = pro;
		System.out.println("세터");
	}
	
	public MyProfile getPro() {
		return pro;
	}

	//사용하는 메서드
//	public void useProfile() {
//		StringBuffer sb = new StringBuffer();
//		sb.append("당신의 유일한 정보 :");
//		sb.append(pro.profile());
//		
//		System.out.println(sb);
//	}
	public String useProfile() {
		StringBuffer sb = new StringBuffer();
		sb.append("당신의 유일한 정보 :");
		sb.append(pro.profile());
		System.out.println(sb.toString());
		return sb.toString();
	}
	

}
