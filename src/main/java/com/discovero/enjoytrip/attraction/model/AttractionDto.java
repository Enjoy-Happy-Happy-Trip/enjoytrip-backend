package com.discovero.enjoytrip.attraction.model;

public class AttractionDto {
	private int contentId;
	private int contentTypeId;
	private String title;
	private String addr;
	private String tel;
	private String firstImage;
	private int readCount;
	private int latitude;
	private int longitude;
	
	public AttractionDto(int contentId, int contentTypeId, String title, String addr, String tel, String firstImage,
			int readCount, int latitude, int longitude) {
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

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "AttractionDto [contentId=" + contentId + ", contentTypeId=" + contentTypeId + ", title=" + title + "]";
	}
}