package com.bit2017.jdbc.vo;

public class BookVo {
	private Long no;
	private String name;
	private String pubDate;
	private String state;
	private int authNo;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getAuthNo() {
		return authNo;
	}
	public void setAuthNo(int authNo) {
		this.authNo = authNo;
	}
	@Override
	public String toString() {
		return "BookVo [no=" + no + ", name=" + name + ", pubDate=" + pubDate + ", state=" + state + ", authNo="
				+ authNo + "]";
	}
	
	
}
