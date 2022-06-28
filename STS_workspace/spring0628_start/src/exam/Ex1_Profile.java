package exam;

public class Ex1_Profile {
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String printinfp() {
		String res ="이름 : " + name + " 나이 : " + age;
		return res;
	}
	
}
