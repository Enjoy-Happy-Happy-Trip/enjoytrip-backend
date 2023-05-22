package com.discovero.enjoytrip.attraction.model;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "AttractionSearchDto : 장소 검색 정보", description = "장소 검색 정보를 나타낸다.")
public class AttractionSearchDto {
	private int sidoCode;
	private int gugunCode;
	private int contentTypeId;
	private String keyword;
	private int pageNo;
	private int offset; // 검색하려는 page의 이전 정보들 개수
	private int itemCount; // 한 페이지 당 개수

	public AttractionSearchDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AttractionSearchDto(int sidoCode, int gugunCode, int contentTypeId, String keyword, int pageNo) {
		super();
		this.sidoCode = sidoCode;
		this.gugunCode = gugunCode;
		this.contentTypeId = contentTypeId;
		this.keyword = keyword;
		this.pageNo = pageNo;
	}

	public AttractionSearchDto(int sidoCode, int gugunCode, int contentTypeId, String keyword, int pageNo, int offset,
			int itemCount) {
		super();
		this.sidoCode = sidoCode;
		this.gugunCode = gugunCode;
		this.contentTypeId = contentTypeId;
		this.keyword = keyword;
		this.pageNo = pageNo;
		this.offset = offset;
		this.itemCount = itemCount;
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

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	@Override
	public String toString() {
		return "AttractionSearchDto [sidoCode=" + sidoCode + ", gugunCode=" + gugunCode + ", contentTypeId="
				+ contentTypeId + ", keyword=" + keyword + ", pageNo=" + pageNo + ", offset=" + offset + ", itemCount="
				+ itemCount + "]";
	}
	
	
}
