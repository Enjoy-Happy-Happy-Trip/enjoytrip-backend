package com.discovero.enjoytrip.tour.model;

import java.math.BigDecimal;

// TODO: contentId, contentTypeId, desc 추가하기
public class TourDto {
	private String imageUrl;
	private String placeName;
	private String address;
	private BigDecimal latitude;
	private BigDecimal longitude;
	
	public TourDto() {
		
	}

	public TourDto(String imageUrl, String placeName, String address, BigDecimal latitude, BigDecimal longitude) {
		super();
		this.imageUrl = imageUrl;
		this.placeName = placeName;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "TourDto [imageUrl=" + imageUrl + ", placeName=" + placeName + ", address=" + address + ", latitude="
				+ latitude + ", longitude=" + longitude + "]";
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	
}
