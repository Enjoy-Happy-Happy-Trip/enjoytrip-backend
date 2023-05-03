package com.discovero.enjoytrip.place.model;

public class HotPlaceDto {
	private int content_id;
	private int review_count;
	
	public HotPlaceDto(int content_id, int review_count) {
		super();
		this.content_id = content_id;
		this.review_count = review_count;
	}

	public int getContent_id() {
		return content_id;
	}

	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}

	public int getReview_count() {
		return review_count;
	}

	public void setReview_count(int review_count) {
		this.review_count = review_count;
	}
}
