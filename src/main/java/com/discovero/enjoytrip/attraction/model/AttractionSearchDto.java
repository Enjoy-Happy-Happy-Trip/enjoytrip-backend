package com.discovero.enjoytrip.attraction.model;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "AttractionSearchDto : 장소 검색 정보", description = "장소 검색 정보를 나타낸다.")
public class AttractionSearchDto {
	private int sidoCode;
	private int contentTypeId;
	private String keyword;
	
	public AttractionSearchDto(int sidoCode, int contentTypeId, String word) {
		super();
		this.sidoCode = sidoCode;
		this.contentTypeId = contentTypeId;
		this.keyword = word;
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
		return "AttractionSearchDto [sidoCode=" + sidoCode + ", contentTypeId=" + contentTypeId + ", keyword=" + keyword
				+ "]";
	}
	
}
