package com.discovero.enjoytrip.tour.model;

import java.util.Arrays;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "UserPlanDto : 사용자 계획 정보", description = "사용자 계획의 상세 정보를 나타낸다.")
public class UserPlanDto {
	private String[] plan;
	private int[] content_ids;
	private String user_id;
	private String planTitle;
	private String startDate;
	private String endDate;
	
	public UserPlanDto() {
		
	}

	public int[] getContent_ids() {
		return content_ids;
	}
	
	public void setContent_ids(int[] content_id) {
		this.content_ids = content_id;
	}

	public String getPlanTitle() {
		return planTitle;
	}

	public void setPlanTitle(String planTitle) {
		this.planTitle = planTitle;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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

	@Override
	public String toString() {
		return "UserPlanDto [plan=" + Arrays.toString(plan) + ", content_id=" + Arrays.toString(content_ids)
				+ ", user_id=" + user_id + ", planTitle=" + planTitle + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}

}
