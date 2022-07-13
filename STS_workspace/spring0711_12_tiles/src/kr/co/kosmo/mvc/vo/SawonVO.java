package kr.co.kosmo.mvc.vo;

public class SawonVO {
	private int sabun;
	private int sapay;
	private int samgr;
	private int deptno;
	private String shaire;
	private String saname;
	private String sajob;
	private String gender;
    private SawonPhoneVO sphone;

	
	public SawonPhoneVO getSphone() {
		return sphone;
	}
	public void setSphone(SawonPhoneVO sphone) {
		this.sphone = sphone;
	}
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public int getSapay() {
		return sapay;
	}
	public void setSapay(int sapay) {
		this.sapay = sapay;
	}
	public int getSamgr() {
		return samgr;
	}
	public void setSamgr(int samgr) {
		this.samgr = samgr;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getShaire() {
		return shaire;
	}
	public void setShaire(String shaire) {
		this.shaire = shaire;
	}
	public String getSaname() {
		return saname;
	}
	public void setSaname(String saname) {
		this.saname = saname;
	}
	public String getSajob() {
		return sajob;
	}
	public void setSajob(String sajob) {
		this.sajob = sajob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
