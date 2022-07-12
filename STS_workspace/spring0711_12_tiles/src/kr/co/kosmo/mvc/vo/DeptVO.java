package kr.co.kosmo.mvc.vo;

import java.util.List;

public class DeptVO {
	private String dname;
	private String loc;
	private int deptno;
	private List<SawonVO> sawonvo;
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public List<SawonVO> getSawonvo() {
		return sawonvo;
	}
	public void setSawonvo(List<SawonVO> sawonvo) {
		this.sawonvo = sawonvo;
	}
	
	
	
}
