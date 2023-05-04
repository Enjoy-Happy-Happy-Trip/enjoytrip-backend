package com.discovero.enjoytrip.plan.model;

public class PlanDto {
	private String plan_id;
	private String user_id;
	private String plan_title;
	private String start_date;
	private String end_date;
	
	public PlanDto() {
		super();
	}

	public PlanDto(String plan_id, String user_id, String plan_title, String start_date, String end_date) {
		super();
		this.plan_id = plan_id;
		this.user_id = user_id;
		this.plan_title = plan_title;
		this.start_date = start_date;
		this.end_date = end_date;
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

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	@Override
	public String toString() {
		return "PlanDto [plan_id=" + plan_id + ", user_id=" + user_id + ", plan_title=" + plan_title + ", start_date="
				+ start_date + ", end_date=" + end_date + "]";
	}
	
}
