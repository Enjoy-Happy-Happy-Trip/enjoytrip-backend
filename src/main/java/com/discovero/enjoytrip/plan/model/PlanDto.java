package com.discovero.enjoytrip.plan.model;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "PlanDto : 계획 정보", description = "계획의 상세 정보를 나타낸다.")
public class PlanDto {
	private String plan_id;
	private String user_id;
	private String plan_title;
	private String plan_desc;
	
	public PlanDto() {
		super();
	}

	public PlanDto(String plan_id, String user_id, String plan_title, String plan_desc) {
		super();
		this.plan_id = plan_id;
		this.user_id = user_id;
		this.plan_title = plan_title;
		this.plan_desc = plan_desc;
	}

	public String getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(String plan_id) {
		this.plan_id = plan_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPlan_title() {
		return plan_title;
	}

	public void setPlan_title(String plan_title) {
		this.plan_title = plan_title;
	}

	public String getPlan_desc() {
		return plan_desc;
	}

	public void setPlan_desc(String plan_desc) {
		this.plan_desc = plan_desc;
	}

	@Override
	public String toString() {
		return "PlanDto [plan_id=" + plan_id + ", user_id=" + user_id + ", plan_title=" + plan_title + ", plan_desc="
				+ plan_desc + "]";
	}
}
