package com.discovero.enjoytrip.place.model;

public class PlaceReviewDto {
	private String user_id;
	private int content_id;
	private String user_review;
	private String register_time;
	
	public PlaceReviewDto(String user_id, int content_id, String user_review, String register_time) {
		super();
		this.user_id = user_id;
		this.content_id = content_id;
		this.user_review = user_review;
		this.register_time = register_time;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getContent_id() {
		return content_id;
	}

	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}

	public String getUser_review() {
		return user_review;
	}

	public void setUser_review(String user_review) {
		this.user_review = user_review;
	}

	public String getRegister_time() {
		return register_time;
	}

	public void setRegister_time(String register_time) {
		this.register_time = register_time;
	}
}
