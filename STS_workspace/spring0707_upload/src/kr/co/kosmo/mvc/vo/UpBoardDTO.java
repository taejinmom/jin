package kr.co.kosmo.mvc.vo;

import org.springframework.web.multipart.MultipartFile;

public class UpBoardDTO {
	private int num;
	private String sub;
	private String writer;
	private String pwd;
	private String cont;
	private String imgn;
	private String udate;
	
	//multipart�� �ش�Ǵ� multipart.MultipartFile - spring web���� ��������
	private MultipartFile mfile;
	
	
	
	
	public MultipartFile getMfile() {
		return mfile;
	}
	public void setMfile(MultipartFile mfile) {
		this.mfile = mfile;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public String getImgn() {
		return imgn;
	}
	public void setImgn(String imgn) {
		this.imgn = imgn;
	}
	public String getUdate() {
		return udate;
	}
	public void setUdate(String udate) {
		this.udate = udate;
	}


}
