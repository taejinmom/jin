package exam1;

public class MyProfile {
	private String name;
	private int age;
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String profile() {
		return name + ":" + age;
	}
}
