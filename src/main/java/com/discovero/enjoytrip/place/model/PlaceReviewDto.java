package com.discovero.enjoytrip.place.model;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "PlaceReviewDto : 리뷰 정보", description = "리뷰의 상세 정보를 나타낸다.")
public class PlaceReviewDto {
	private String user_id;
	private int content_id;
	private String user_review;
	private String register_time;
	private int review_id;
	private String title;
	
	public PlaceReviewDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlaceReviewDto(String user_id, int content_id, String user_review, String register_time, int review_id) {
		super();
		this.user_id = user_id;
		this.content_id = content_id;
		this.user_review = user_review;
		this.register_time = register_time;
		this.review_id = review_id;
	}

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
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
  
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "PlaceReviewDto [review_id=" + review_id + ", user_id=" + user_id + ", content_id=" + content_id
				+ ", user_review=" + user_review + ", register_time=" + register_time + ", title=" + title + "]";
	}
}
