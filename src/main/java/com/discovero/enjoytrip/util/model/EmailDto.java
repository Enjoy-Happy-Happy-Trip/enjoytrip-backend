package com.discovero.enjoytrip.util.model;

public class EmailDto {
	private String addressTo;
	private String title;
	private String content;
	
	public EmailDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmailDto(String addressTo, String title, String content) {
		super();
		this.addressTo = addressTo;
		this.title = title;
		this.content = content;
	}

	public String getAddressTo() {
		return addressTo;
	}

	public void setAddressTo(String addressTo) {
		this.addressTo = addressTo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
