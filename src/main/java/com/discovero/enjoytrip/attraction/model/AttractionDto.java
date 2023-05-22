package com.discovero.enjoytrip.attraction.model;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "AttractionDto : 장소 정보", description = "장소의 상세 정보를 나타낸다.")
public class AttractionDto {
	private int contentId;
	private int contentTypeId;
	private String title;
	private String addr;
	private String tel;
	private String firstImage;
	private int readCount;
	private double latitude;
	private double longitude;
	private int review_count;
	
	public int getReview_count() {
		return review_count;
	}

	public void setReview_count(int review_count) {
		this.review_count = review_count;
	}

	public AttractionDto(int contentId, int contentTypeId, String title, String addr, String tel, String firstImage,
			int readCount, double latitude, double longitude) {
		super();
		this.contentId = contentId;
		this.contentTypeId = contentTypeId;
		this.title = title;
		this.addr = addr;
		this.tel = tel;
		this.firstImage = firstImage;
		this.readCount = readCount;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public int getContentTypeId() {
		return contentTypeId;
	}

	public void setContentTypeId(int contentTypeId) {
		this.contentTypeId = contentTypeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFirstImage() {
		return firstImage;
	}

	public void setFirstImage(String firstImage) {
		this.firstImage = firstImage;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "AttractionDto [contentId=" + contentId + ", contentTypeId=" + contentTypeId + ", title=" + title
				+ ", addr=" + addr + ", tel=" + tel + ", firstImage=" + firstImage + ", readCount=" + readCount
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", review_count=" + review_count + "]";
	}

}