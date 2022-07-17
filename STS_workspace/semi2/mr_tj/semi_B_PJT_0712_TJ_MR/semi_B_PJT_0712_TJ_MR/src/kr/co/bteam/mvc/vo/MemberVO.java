package kr.co.bteam.mvc.vo;

import java.util.List;


public class MemberVO extends SuperVO{
	private int mem_no;
    private String mem_id;
    private String mem_pw;
    private String mem_name;
    private String mem_jubun;
    private String mem_phone;
    private String mem_adr;
    private String mem_date;
    private List<ReviewsVO> reviewvo;
    
    
    
	public List<ReviewsVO> getReviewvo() {
		return reviewvo;
	}
	public void setReviewvo(List<ReviewsVO> reviewvo) {
		this.reviewvo = reviewvo;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_jubun() {
		return mem_jubun;
	}
	public void setMem_jubun(String mem_jubun) {
		this.mem_jubun = mem_jubun;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public String getMem_adr() {
		return mem_adr;
	}
	public void setMem_adr(String mem_adr) {
		this.mem_adr = mem_adr;
	}
	public String getMem_date() {
		return mem_date;
	}
	public void setMem_date(String mem_date) {
		this.mem_date = mem_date;
	}
    
}
