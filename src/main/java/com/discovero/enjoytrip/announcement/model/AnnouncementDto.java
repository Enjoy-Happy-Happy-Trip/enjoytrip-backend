package com.discovero.enjoytrip.announcement.model;

public class AnnouncementDto {
	private int article_no;
	private String user_id;
	private String subject;
	private String content;
	private int hit;
	private String register_time;
	
	public AnnouncementDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnnouncementDto(int article_no, String user_id, String subject, String content, int hit,
			String register_time) {
		super();
		this.article_no = article_no;
		this.user_id = user_id;
		this.subject = subject;
		this.content = content;
		this.hit = hit;
		this.register_time = register_time;
	}

	public int getArticle_no() {
		return article_no;
	}

	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getRegister_time() {
		return register_time;
	}

	public void setRegister_time(String register_time) {
		this.register_time = register_time;
	}

	@Override
	public String toString() {
		return "AnnouncementDto [article_no=" + article_no + ", user_id=" + user_id + ", subject=" + subject
				+ ", content=" + content + ", hit=" + hit + ", register_time=" + register_time + "]";
	}
	
	
	
}
