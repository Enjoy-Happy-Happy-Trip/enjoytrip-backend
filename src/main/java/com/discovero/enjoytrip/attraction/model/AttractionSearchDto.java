package com.discovero.enjoytrip.attraction.model;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "AttractionSearchDto : 장소 검색 정보", description = "장소 검색 정보를 나타낸다.")
public class AttractionSearchDto {
	private int sidoCode;
	private int gugunCode;
	private int contentTypeId;
	private String keyword;

	public AttractionSearchDto(int sidoCode, int gugunCode, int contentTypeId, String keyword) {
		super();
		this.sidoCode = sidoCode;
		this.gugunCode = gugunCode;
		this.contentTypeId = contentTypeId;
		this.keyword = keyword;
	}

	public int getGugunCode() {
		return gugunCode;
	}

	public void setGugunCode(int gugunCode) {
		this.gugunCode = gugunCode;
	}

	public int getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}

	public int getContentTypeId() {
		return contentTypeId;
	}

	public void setContentTypeId(int contentTypeId) {
		this.contentTypeId = contentTypeId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "AttractionSearchDto [sidoCode=" + sidoCode + ", gugunCode=" + gugunCode + ", contentTypeId="
				+ contentTypeId + ", keyword=" + keyword + "]";
	}
	
}
