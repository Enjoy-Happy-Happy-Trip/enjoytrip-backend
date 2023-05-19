package com.discovero.enjoytrip.tour.model;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;

// TODO: contentId, contentTypeId, desc 추가하기
@ApiModel(value = "TourDto : 사용자 계획 정보", description = "사용자 계획의 상세 정보를 나타낸다.")
public class UserPlanDto {
	private String[] plan;
	private String user_id;
	
	public UserPlanDto() {
		
	}

	public String[] getPlan() {
		return plan;
	}

	public void setPlan(String[] plan) {
		this.plan = plan;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public UserPlanDto(String[] plan, String user_id) {
		super();
		this.plan = plan;
		this.user_id = user_id;
	}
	
}
