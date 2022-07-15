package kr.co.bteam.mvc.vo;

public class SearchVO extends SuperVO{
	
	private int beginPerPage, endPerPage;
	private String search, category ;
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getBeginPerPage() {
		return beginPerPage;
	}
	public void setBeginPerPage(int beginPerPage) {
		this.beginPerPage = beginPerPage;
	}
	public int getEndPerPage() {
		return endPerPage;
	}
	public void setEndPerPage(int endPerPage) {
		this.endPerPage = endPerPage;
	}

	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	
}
