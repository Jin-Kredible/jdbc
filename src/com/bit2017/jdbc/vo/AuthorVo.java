package com.bit2017.jdbc.vo;

public class AuthorVo {
	
	private Long no;
	private String name;
	private String content;

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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "AuthorVo [no=" + no + ", name=" + name + ", content=" + content + "]";
	}
	
	
}
